package com.glenoir.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoomService}.
 *
 * @author guillaume Lenoir
 * @see RoomService
 * @generated
 */
public class RoomServiceWrapper implements RoomService,
    ServiceWrapper<RoomService> {
    private RoomService _roomService;

    public RoomServiceWrapper(RoomService roomService) {
        _roomService = roomService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _roomService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _roomService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _roomService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RoomService getWrappedRoomService() {
        return _roomService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRoomService(RoomService roomService) {
        _roomService = roomService;
    }

    @Override
    public RoomService getWrappedService() {
        return _roomService;
    }

    @Override
    public void setWrappedService(RoomService roomService) {
        _roomService = roomService;
    }
}
