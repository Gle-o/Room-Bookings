package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EquipmentService}.
 *
 * @author Guillaume Lenoir
 * @see EquipmentService
 * @generated
 */
public class EquipmentServiceWrapper implements EquipmentService,
    ServiceWrapper<EquipmentService> {
    private EquipmentService _equipmentService;

    public EquipmentServiceWrapper(EquipmentService equipmentService) {
        _equipmentService = equipmentService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _equipmentService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _equipmentService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _equipmentService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.zenixia.plugins.model.Equipment addEquipment(
        com.zenixia.plugins.model.Equipment equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentService.addEquipment(equipment, serviceContext);
    }

    @Override
    public com.zenixia.plugins.model.Equipment updateEquipment(
        com.zenixia.plugins.model.Equipment equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentService.updateEquipment(equipment, serviceContext);
    }

    @Override
    public com.zenixia.plugins.model.Equipment deleteEquipment(long equipmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentService.deleteEquipment(equipmentId);
    }

    @Override
    public com.zenixia.plugins.model.Equipment getEquipment(long equipmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentService.getEquipment(equipmentId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentService.getEquipmentByGroupId(groupId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentService.getEquipmentByGroupId(groupId, start, end);
    }

    @Override
    public int getEquipmentCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentService.getEquipmentCountByGroupId(groupId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByGroupIdEquipementTypeId(
        long groupId, long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentService.getEquipmentByGroupIdEquipementTypeId(groupId,
            equipmentTypeId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EquipmentService getWrappedEquipmentService() {
        return _equipmentService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEquipmentService(EquipmentService equipmentService) {
        _equipmentService = equipmentService;
    }

    @Override
    public EquipmentService getWrappedService() {
        return _equipmentService;
    }

    @Override
    public void setWrappedService(EquipmentService equipmentService) {
        _equipmentService = equipmentService;
    }
}
