package com.glenoir.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EquipmentTypeService}.
 *
 * @author guillaume Lenoir
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
