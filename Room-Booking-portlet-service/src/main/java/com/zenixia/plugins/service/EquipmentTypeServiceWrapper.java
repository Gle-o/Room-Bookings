package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EquipmentTypeService}.
 *
 * @author Guillaume Lenoir
 * @see EquipmentTypeService
 * @generated
 */
public class EquipmentTypeServiceWrapper implements EquipmentTypeService,
    ServiceWrapper<EquipmentTypeService> {
    private EquipmentTypeService _equipmentTypeService;

    public EquipmentTypeServiceWrapper(
        EquipmentTypeService equipmentTypeService) {
        _equipmentTypeService = equipmentTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _equipmentTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _equipmentTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _equipmentTypeService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.zenixia.plugins.model.EquipmentType addEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentTypeService.addEquipmentType(equipmentType,
            serviceContext);
    }

    @Override
    public com.zenixia.plugins.model.EquipmentType updateEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentTypeService.updateEquipmentType(equipmentType,
            serviceContext);
    }

    @Override
    public com.zenixia.plugins.model.EquipmentType deleteEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentTypeService.deleteEquipmentType(equipmentTypeId);
    }

    @Override
    public com.zenixia.plugins.model.EquipmentType getEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeService.getEquipmentType(equipmentTypeId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.EquipmentType> getEquipmentTypeByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeService.getEquipmentTypeByGroupId(groupId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.EquipmentType> getEquipmentTypeByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeService.getEquipmentTypeByGroupId(groupId, start,
            end);
    }

    @Override
    public int getEquipmentCountTypeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeService.getEquipmentCountTypeByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EquipmentTypeService getWrappedEquipmentTypeService() {
        return _equipmentTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEquipmentTypeService(
        EquipmentTypeService equipmentTypeService) {
        _equipmentTypeService = equipmentTypeService;
    }

    @Override
    public EquipmentTypeService getWrappedService() {
        return _equipmentTypeService;
    }

    @Override
    public void setWrappedService(EquipmentTypeService equipmentTypeService) {
        _equipmentTypeService = equipmentTypeService;
    }
}
