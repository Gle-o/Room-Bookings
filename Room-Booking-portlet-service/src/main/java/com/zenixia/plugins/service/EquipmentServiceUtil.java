package com.zenixia.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Equipment. This utility wraps
 * {@link com.zenixia.plugins.service.impl.EquipmentServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see EquipmentService
 * @see com.zenixia.plugins.service.base.EquipmentServiceBaseImpl
 * @see com.zenixia.plugins.service.impl.EquipmentServiceImpl
 * @generated
 */
public class EquipmentServiceUtil {
    private static EquipmentService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.zenixia.plugins.service.impl.EquipmentServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.zenixia.plugins.model.Equipment addEquipment(
        com.zenixia.plugins.model.Equipment equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().addEquipment(equipment, serviceContext);
    }

    public static com.zenixia.plugins.model.Equipment updateEquipment(
        com.zenixia.plugins.model.Equipment equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().updateEquipment(equipment, serviceContext);
    }

    public static com.zenixia.plugins.model.Equipment deleteEquipment(
        long equipmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteEquipment(equipmentId);
    }

    public static com.zenixia.plugins.model.Equipment getEquipment(
        long equipmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipment(equipmentId);
    }

    public static java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentByGroupId(groupId);
    }

    public static java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentByGroupId(groupId, start, end);
    }

    public static int getEquipmentCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEquipmentCountByGroupId(groupId);
    }

    public static java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByGroupIdEquipementTypeId(
        long groupId, long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getEquipmentByGroupIdEquipementTypeId(groupId,
            equipmentTypeId);
    }

    public static void clearService() {
        _service = null;
    }

    public static EquipmentService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EquipmentService.class.getName());

            if (invokableService instanceof EquipmentService) {
                _service = (EquipmentService) invokableService;
            } else {
                _service = new EquipmentServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(EquipmentServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(EquipmentService service) {
    }
}
