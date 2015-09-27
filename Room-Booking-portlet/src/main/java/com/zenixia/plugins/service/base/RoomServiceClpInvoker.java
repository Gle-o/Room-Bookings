package com.zenixia.plugins.service.base;

import com.zenixia.plugins.service.RoomServiceUtil;

import java.util.Arrays;

/**
 * @author Guillaume Lenoir
 * @generated
 */
public class RoomServiceClpInvoker {
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName48;
    private String[] _methodParameterTypes48;

    public RoomServiceClpInvoker() {
        _methodName36 = "getBeanIdentifier";

        _methodParameterTypes36 = new String[] {  };

        _methodName37 = "setBeanIdentifier";

        _methodParameterTypes37 = new String[] { "java.lang.String" };

        _methodName42 = "addRoom";

        _methodParameterTypes42 = new String[] {
                "com.zenixia.plugins.model.Room",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName43 = "updateRoom";

        _methodParameterTypes43 = new String[] {
                "com.zenixia.plugins.model.Room",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName44 = "deleteRoom";

        _methodParameterTypes44 = new String[] { "long" };

        _methodName45 = "getRoom";

        _methodParameterTypes45 = new String[] { "long" };

        _methodName46 = "getRoomByGroupId";

        _methodParameterTypes46 = new String[] { "long" };

        _methodName47 = "getRoomByGroupId";

        _methodParameterTypes47 = new String[] { "long", "int", "int" };

        _methodName48 = "getRoomCountByGroupId";

        _methodParameterTypes48 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            return RoomServiceUtil.getBeanIdentifier();
        }

        if (_methodName37.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
            RoomServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return RoomServiceUtil.addRoom((com.zenixia.plugins.model.Room) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return RoomServiceUtil.updateRoom((com.zenixia.plugins.model.Room) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return RoomServiceUtil.deleteRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return RoomServiceUtil.getRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return RoomServiceUtil.getRoomByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            return RoomServiceUtil.getRoomByGroupId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return RoomServiceUtil.getRoomCountByGroupId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
