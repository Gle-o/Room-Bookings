package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoomService}.
 *
 * @author Guillaume Lenoir
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

    @Override
    public com.zenixia.plugins.model.Room addRoom(
        com.zenixia.plugins.model.Room room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _roomService.addRoom(room, serviceContext);
    }

    @Override
    public com.zenixia.plugins.model.Room updateRoom(
        com.zenixia.plugins.model.Room room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _roomService.updateRoom(room, serviceContext);
    }

    @Override
    public com.zenixia.plugins.model.Room deleteRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _roomService.deleteRoom(roomId);
    }

    @Override
    public com.zenixia.plugins.model.Room getRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomService.getRoom(roomId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.Room> getRoomByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomService.getRoomByGroupId(groupId);
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.Room> getRoomByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomService.getRoomByGroupId(groupId, start, end);
    }

    @Override
    public int getRoomCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomService.getRoomCountByGroupId(groupId);
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
