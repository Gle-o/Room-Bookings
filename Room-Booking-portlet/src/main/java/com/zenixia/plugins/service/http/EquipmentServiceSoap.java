package com.zenixia.plugins.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.zenixia.plugins.service.EquipmentServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.zenixia.plugins.service.EquipmentServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.zenixia.plugins.model.EquipmentSoap}.
 * If the method in the service utility returns a
 * {@link com.zenixia.plugins.model.Equipment}, that is translated to a
 * {@link com.zenixia.plugins.model.EquipmentSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see EquipmentServiceHttp
 * @see com.zenixia.plugins.model.EquipmentSoap
 * @see com.zenixia.plugins.service.EquipmentServiceUtil
 * @generated
 */
public class EquipmentServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(EquipmentServiceSoap.class);

    public static com.zenixia.plugins.model.EquipmentSoap addEquipment(
        com.zenixia.plugins.model.EquipmentSoap equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.Equipment returnValue = EquipmentServiceUtil.addEquipment(com.zenixia.plugins.model.impl.EquipmentModelImpl.toModel(
                        equipment), serviceContext);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentSoap updateEquipment(
        com.zenixia.plugins.model.EquipmentSoap equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.Equipment returnValue = EquipmentServiceUtil.updateEquipment(com.zenixia.plugins.model.impl.EquipmentModelImpl.toModel(
                        equipment), serviceContext);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentSoap deleteEquipment(
        long equipmentId) throws RemoteException {
        try {
            com.zenixia.plugins.model.Equipment returnValue = EquipmentServiceUtil.deleteEquipment(equipmentId);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentSoap getEquipment(
        long equipmentId) throws RemoteException {
        try {
            com.zenixia.plugins.model.Equipment returnValue = EquipmentServiceUtil.getEquipment(equipmentId);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentSoap[] getEquipmentByGroupId(
        long groupId) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.Equipment> returnValue = EquipmentServiceUtil.getEquipmentByGroupId(groupId);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentSoap[] getEquipmentByGroupId(
        long groupId, int start, int end) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.Equipment> returnValue = EquipmentServiceUtil.getEquipmentByGroupId(groupId,
                    start, end);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getEquipmentCountByGroupId(long groupId)
        throws RemoteException {
        try {
            int returnValue = EquipmentServiceUtil.getEquipmentCountByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentSoap[] getEquipmentByGroupIdEquipementTypeId(
        long groupId, long equipmentTypeId) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.Equipment> returnValue = EquipmentServiceUtil.getEquipmentByGroupIdEquipementTypeId(groupId,
                    equipmentTypeId);

            return com.zenixia.plugins.model.EquipmentSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
