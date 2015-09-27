package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoomBookingService}.
 *
 * @author Guillaume Lenoir
 * @see RoomBookingService
 * @generated
 */
public class RoomBookingServiceWrapper implements RoomBookingService,
    ServiceWrapper<RoomBookingService> {
    private RoomBookingService _roomBookingService;

    public RoomBookingServiceWrapper(RoomBookingService roomBookingService) {
        _roomBookingService = roomBookingService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _roomBookingService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _roomBookingService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _roomBookingService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RoomBookingService getWrappedRoomBookingService() {
        return _roomBookingService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRoomBookingService(
        RoomBookingService roomBookingService) {
        _roomBookingService = roomBookingService;
    }

    @Override
    public RoomBookingService getWrappedService() {
        return _roomBookingService;
    }

    @Override
    public void setWrappedService(RoomBookingService roomBookingService) {
        _roomBookingService = roomBookingService;
    }
}
