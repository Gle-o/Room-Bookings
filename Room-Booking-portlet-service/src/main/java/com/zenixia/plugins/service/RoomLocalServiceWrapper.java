package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoomLocalService}.
 *
 * @author Guillaume Lenoir
 * @see RoomLocalService
 * @generated
 */
public class RoomLocalServiceWrapper implements RoomLocalService,
    ServiceWrapper<RoomLocalService> {
    private RoomLocalService _roomLocalService;

    public RoomLocalServiceWrapper(RoomLocalService roomLocalService) {
        _roomLocalService = roomLocalService;
    }

    /**
    * Adds the room to the database. Also notifies the appropriate model listeners.
    *
    * @param room the room
    * @return the room that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room addRoom(
        com.zenixia.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.addRoom(room);
    }

    /**
    * Creates a new room with the primary key. Does not add the room to the database.
    *
    * @param roomId the primary key for the new room
    * @return the new room
    */
    @Override
    public com.zenixia.plugins.model.Room createRoom(long roomId) {
        return _roomLocalService.createRoom(roomId);
    }

    /**
    * Deletes the room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the room
    * @return the room that was removed
    * @throws PortalException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.liferay.portal.security.auth.PrincipalException
    */
    @Override
    public com.zenixia.plugins.model.Room deleteRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _roomLocalService.deleteRoom(roomId);
    }

    /**
    * Deletes the room from the database. Also notifies the appropriate model listeners.
    *
    * @param room the room
    * @return the room that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room deleteRoom(
        com.zenixia.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.deleteRoom(room);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _roomLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.zenixia.plugins.model.Room fetchRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.fetchRoom(roomId);
    }

    /**
    * Returns the room with the matching UUID and company.
    *
    * @param uuid the room's UUID
    * @param companyId the primary key of the company
    * @return the matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room fetchRoomByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.fetchRoomByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the room matching the UUID and group.
    *
    * @param uuid the room's UUID
    * @param groupId the primary key of the group
    * @return the matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room fetchRoomByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.fetchRoomByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the room with the primary key.
    *
    * @param roomId the primary key of the room
    * @return the room
    * @throws PortalException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room getRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.getRoom(roomId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the room with the matching UUID and company.
    *
    * @param uuid the room's UUID
    * @param companyId the primary key of the company
    * @return the matching room
    * @throws PortalException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room getRoomByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.getRoomByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the room matching the UUID and group.
    *
    * @param uuid the room's UUID
    * @param groupId the primary key of the group
    * @return the matching room
    * @throws PortalException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room getRoomByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.getRoomByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the rooms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @return the range of rooms
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.zenixia.plugins.model.Room> getRooms(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.getRooms(start, end);
    }

    /**
    * Returns the number of rooms.
    *
    * @return the number of rooms
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getRoomsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.getRoomsCount();
    }

    /**
    * Updates the room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param room the room
    * @return the room that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Room updateRoom(
        com.zenixia.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.updateRoom(room);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _roomLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _roomLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _roomLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Add room
    *
    * @param room
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.zenixia.plugins.model.Room addRoom(
        com.zenixia.plugins.model.Room room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _roomLocalService.addRoom(room, serviceContext);
    }

    /**
    * Update room
    *
    * @param room
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PrincipalException
    * @throws PortalException
    */
    @Override
    public com.zenixia.plugins.model.Room updateRoom(
        com.zenixia.plugins.model.Room room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _roomLocalService.updateRoom(room, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RoomLocalService getWrappedRoomLocalService() {
        return _roomLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRoomLocalService(RoomLocalService roomLocalService) {
        _roomLocalService = roomLocalService;
    }

    @Override
    public RoomLocalService getWrappedService() {
        return _roomLocalService;
    }

    @Override
    public void setWrappedService(RoomLocalService roomLocalService) {
        _roomLocalService = roomLocalService;
    }
}
