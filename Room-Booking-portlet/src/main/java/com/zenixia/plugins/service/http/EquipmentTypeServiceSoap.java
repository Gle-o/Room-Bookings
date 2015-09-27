package com.zenixia.plugins.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.zenixia.plugins.service.EquipmentTypeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.zenixia.plugins.service.EquipmentTypeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.zenixia.plugins.model.EquipmentTypeSoap}.
 * If the method in the service utility returns a
 * {@link com.zenixia.plugins.model.EquipmentType}, that is translated to a
 * {@link com.zenixia.plugins.model.EquipmentTypeSoap}. Methods that SOAP cannot
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
 * @see EquipmentTypeServiceHttp
 * @see com.zenixia.plugins.model.EquipmentTypeSoap
 * @see com.zenixia.plugins.service.EquipmentTypeServiceUtil
 * @generated
 */
public class EquipmentTypeServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(EquipmentTypeServiceSoap.class);

    public static com.zenixia.plugins.model.EquipmentTypeSoap addEquipmentType(
        com.zenixia.plugins.model.EquipmentTypeSoap equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.EquipmentType returnValue = EquipmentTypeServiceUtil.addEquipmentType(com.zenixia.plugins.model.impl.EquipmentTypeModelImpl.toModel(
                        equipmentType), serviceContext);

            return com.zenixia.plugins.model.EquipmentTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentTypeSoap updateEquipmentType(
        com.zenixia.plugins.model.EquipmentTypeSoap equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.model.EquipmentType returnValue = EquipmentTypeServiceUtil.updateEquipmentType(com.zenixia.plugins.model.impl.EquipmentTypeModelImpl.toModel(
                        equipmentType), serviceContext);

            return com.zenixia.plugins.model.EquipmentTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentTypeSoap deleteEquipmentType(
        long equipmentTypeId) throws RemoteException {
        try {
            com.zenixia.plugins.model.EquipmentType returnValue = EquipmentTypeServiceUtil.deleteEquipmentType(equipmentTypeId);

            return com.zenixia.plugins.model.EquipmentTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentTypeSoap getEquipmentType(
        long equipmentTypeId) throws RemoteException {
        try {
            com.zenixia.plugins.model.EquipmentType returnValue = EquipmentTypeServiceUtil.getEquipmentType(equipmentTypeId);

            return com.zenixia.plugins.model.EquipmentTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentTypeSoap[] getEquipmentTypeByGroupId(
        long groupId) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.EquipmentType> returnValue = EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(groupId);

            return com.zenixia.plugins.model.EquipmentTypeSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.model.EquipmentTypeSoap[] getEquipmentTypeByGroupId(
        long groupId, int start, int end) throws RemoteException {
        try {
            java.util.List<com.zenixia.plugins.model.EquipmentType> returnValue = EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(groupId,
                    start, end);

            return com.zenixia.plugins.model.EquipmentTypeSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getEquipmentCountTypeByGroupId(long groupId)
        throws RemoteException {
        try {
            int returnValue = EquipmentTypeServiceUtil.getEquipmentCountTypeByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
