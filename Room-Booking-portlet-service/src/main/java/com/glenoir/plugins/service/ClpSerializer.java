package com.glenoir.plugins.service;

import com.glenoir.plugins.model.EquipmentClp;
import com.glenoir.plugins.model.EquipmentTypeClp;
import com.glenoir.plugins.model.RoomBookingClp;
import com.glenoir.plugins.model.RoomClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "Room-Booking-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "Room-Booking-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "Room-Booking-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(EquipmentClp.class.getName())) {
            return translateInputEquipment(oldModel);
        }

        if (oldModelClassName.equals(EquipmentTypeClp.class.getName())) {
            return translateInputEquipmentType(oldModel);
        }

        if (oldModelClassName.equals(RoomClp.class.getName())) {
            return translateInputRoom(oldModel);
        }

        if (oldModelClassName.equals(RoomBookingClp.class.getName())) {
            return translateInputRoomBooking(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputEquipment(BaseModel<?> oldModel) {
        EquipmentClp oldClpModel = (EquipmentClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getEquipmentRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputEquipmentType(BaseModel<?> oldModel) {
        EquipmentTypeClp oldClpModel = (EquipmentTypeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getEquipmentTypeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRoom(BaseModel<?> oldModel) {
        RoomClp oldClpModel = (RoomClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRoomRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRoomBooking(BaseModel<?> oldModel) {
        RoomBookingClp oldClpModel = (RoomBookingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRoomBookingRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.glenoir.plugins.model.impl.EquipmentImpl")) {
            return translateOutputEquipment(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.glenoir.plugins.model.impl.EquipmentTypeImpl")) {
            return translateOutputEquipmentType(oldModel);
        }

        if (oldModelClassName.equals("com.glenoir.plugins.model.impl.RoomImpl")) {
            return translateOutputRoom(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.glenoir.plugins.model.impl.RoomBookingImpl")) {
            return translateOutputRoomBooking(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("com.glenoir.plugins.NoSuchEquipmentException")) {
            return new com.glenoir.plugins.NoSuchEquipmentException();
        }

        if (className.equals("com.glenoir.plugins.NoSuchEquipmentTypeException")) {
            return new com.glenoir.plugins.NoSuchEquipmentTypeException();
        }

        if (className.equals("com.glenoir.plugins.NoSuchRoomException")) {
            return new com.glenoir.plugins.NoSuchRoomException();
        }

        if (className.equals("com.glenoir.plugins.NoSuchRoomBookingException")) {
            return new com.glenoir.plugins.NoSuchRoomBookingException();
        }

        return throwable;
    }

    public static Object translateOutputEquipment(BaseModel<?> oldModel) {
        EquipmentClp newModel = new EquipmentClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setEquipmentRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputEquipmentType(BaseModel<?> oldModel) {
        EquipmentTypeClp newModel = new EquipmentTypeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setEquipmentTypeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRoom(BaseModel<?> oldModel) {
        RoomClp newModel = new RoomClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRoomRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRoomBooking(BaseModel<?> oldModel) {
        RoomBookingClp newModel = new RoomBookingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRoomBookingRemoteModel(oldModel);

        return newModel;
    }
}
