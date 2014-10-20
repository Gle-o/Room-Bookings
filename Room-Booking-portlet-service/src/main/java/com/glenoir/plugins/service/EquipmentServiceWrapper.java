package com.glenoir.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EquipmentService}.
 *
 * @author guillaume Lenoir
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
