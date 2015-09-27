package com.zenixia.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for EquipmentType. This utility wraps
 * {@link com.zenixia.plugins.service.impl.EquipmentTypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see EquipmentTypeService
 * @see com.zenixia.plugins.service.base.EquipmentTypeServiceBaseImpl
 * @see com.zenixia.plugins.service.impl.EquipmentTypeServiceImpl
 * @generated
 */
public class EquipmentTypeServiceUtil {
    private static EquipmentTypeService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.zenixia.plugins.service.impl.EquipmentTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.zenixia.plugins.model.EquipmentType addEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().addEquipmentType(equipmentType, serviceContext);
    }

    public static com.zenixia.plugins.model.EquipmentType updateEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().updateEquipmentType(equipmentType, serviceContext);
    }

    public static com.zenixia.plugins.model.EquipmentType deleteEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteEquipmentType(equipmentTypeId);
    }

    public static com.zenixia.plugins.model.EquipmentType getEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentType(equipmentTypeId);
    }

    public static java.util.List<com.zenixia.plugins.model.EquipmentType> getEquipmentTypeByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentTypeByGroupId(groupId);
    }

    public static java.util.List<com.zenixia.plugins.model.EquipmentType> getEquipmentTypeByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentTypeByGroupId(groupId, start, end);
    }

    public static int getEquipmentCountTypeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentCountTypeByGroupId(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static EquipmentTypeService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EquipmentTypeService.class.getName());

            if (invokableService instanceof EquipmentTypeService) {
                _service = (EquipmentTypeService) invokableService;
            } else {
                _service = new EquipmentTypeServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(EquipmentTypeServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(EquipmentTypeService service) {
    }
}
