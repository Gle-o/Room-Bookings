package com.zenixia.plugins.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.zenixia.plugins.service.RoomServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.zenixia.plugins.service.RoomServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.zenixia.plugins.model.RoomSoap}.
 * If the method in the service utility returns a
 * {@link com.zenixia.plugins.model.Room}, that is translated to a
 * {@link com.zenixia.plugins.model.RoomSoap}. Methods that SOAP cannot
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
 * @see RoomServiceHttp
 * @see com.zenixia.plugins.model.RoomSoap
 * @see com.zenixia.plugins.service.RoomServiceUtil
 * @generated
 */
public class RoomServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(RoomServiceSoap.class);

    public static com.zenixia.plugins.model.RoomSoap addRoom(
        com.zenixia.plugins.model.RoomSoap room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.Room returnValue = RoomServiceUtil.addRoom(com.zenixia.plugins.model.impl.RoomModelImpl.toModel(
                        room), serviceContext);

            return com.zenixia.plugins.model.RoomSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.RoomSoap updateRoom(
        com.zenixia.plugins.model.RoomSoap room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.Room returnValue = RoomServiceUtil.updateRoom(com.zenixia.plugins.model.impl.RoomModelImpl.toModel(
                        room), serviceContext);

            return com.zenixia.plugins.model.RoomSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.RoomSoap deleteRoom(long roomId)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.Room returnValue = RoomServiceUtil.deleteRoom(roomId);

            return com.zenixia.plugins.model.RoomSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.RoomSoap getRoom(long roomId)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.Room returnValue = RoomServiceUtil.getRoom(roomId);

            return com.zenixia.plugins.model.RoomSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.RoomSoap[] getRoomByGroupId(
        long groupId) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.Room> returnValue = RoomServiceUtil.getRoomByGroupId(groupId);

            return com.zenixia.plugins.model.RoomSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.RoomSoap[] getRoomByGroupId(
        long groupId, int start, int end) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.Room> returnValue = RoomServiceUtil.getRoomByGroupId(groupId,
                    start, end);

            return com.zenixia.plugins.model.RoomSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getRoomCountByGroupId(long groupId)
        throws RemoteException {
        try {
            int returnValue = RoomServiceUtil.getRoomCountByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
