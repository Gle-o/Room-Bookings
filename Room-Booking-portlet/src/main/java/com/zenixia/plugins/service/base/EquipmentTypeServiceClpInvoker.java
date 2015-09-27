package com.zenixia.plugins.service.base;

import com.zenixia.plugins.service.EquipmentTypeServiceUtil;

import java.util.Arrays;

/**
 * @author Guillaume Lenoir
 * @generated
 */
public class EquipmentTypeServiceClpInvoker {
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

    public EquipmentTypeServiceClpInvoker() {
        _methodName36 = "getBeanIdentifier";

        _methodParameterTypes36 = new String[] {  };

        _methodName37 = "setBeanIdentifier";

        _methodParameterTypes37 = new String[] { "java.lang.String" };

        _methodName42 = "addEquipmentType";

        _methodParameterTypes42 = new String[] {
                "com.zenixia.plugins.model.EquipmentType",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName43 = "updateEquipmentType";

        _methodParameterTypes43 = new String[] {
                "com.zenixia.plugins.model.EquipmentType",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName44 = "deleteEquipmentType";

        _methodParameterTypes44 = new String[] { "long" };

        _methodName45 = "getEquipmentType";

        _methodParameterTypes45 = new String[] { "long" };

        _methodName46 = "getEquipmentTypeByGroupId";

        _methodParameterTypes46 = new String[] { "long" };

        _methodName47 = "getEquipmentTypeByGroupId";

        _methodParameterTypes47 = new String[] { "long", "int", "int" };

        _methodName48 = "getEquipmentCountTypeByGroupId";

        _methodParameterTypes48 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            return EquipmentTypeServiceUtil.getBeanIdentifier();
        }

        if (_methodName37.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
            EquipmentTypeServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return EquipmentTypeServiceUtil.addEquipmentType((com.zenixia.plugins.model.EquipmentType) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return EquipmentTypeServiceUtil.updateEquipmentType((com.zenixia.plugins.model.EquipmentType) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return EquipmentTypeServiceUtil.deleteEquipmentType(((Long) arguments[0]).longValue());
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return EquipmentTypeServiceUtil.getEquipmentType(((Long) arguments[0]).longValue());
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            return EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return EquipmentTypeServiceUtil.getEquipmentCountTypeByGroupId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
