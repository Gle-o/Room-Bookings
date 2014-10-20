package com.glenoir.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Room. This utility wraps
 * {@link com.glenoir.plugins.service.impl.RoomLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author guillaume Lenoir
 * @see RoomLocalService
 * @see com.glenoir.plugins.service.base.RoomLocalServiceBaseImpl
 * @see com.glenoir.plugins.service.impl.RoomLocalServiceImpl
 * @generated
 */
public class RoomLocalServiceUtil {
    private static RoomLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.glenoir.plugins.service.impl.RoomLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the room to the database. Also notifies the appropriate model listeners.
    *
    * @param room the room
    * @return the room that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.glenoir.plugins.model.Room addRoom(
        com.glenoir.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addRoom(room);
    }

    /**
    * Creates a new room with the primary key. Does not add the room to the database.
    *
    * @param roomId the primary key for the new room
    * @return the new room
    */
    public static com.glenoir.plugins.model.Room createRoom(long roomId) {
        return getService().createRoom(roomId);
    }

    /**
    * Deletes the room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the room
    * @return the room that was removed
    * @throws PortalException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.glenoir.plugins.model.Room deleteRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRoom(roomId);
    }

    /**
    * Deletes the room from the database. Also notifies the appropriate model listeners.
    *
    * @param room the room
    * @return the room that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.glenoir.plugins.model.Room deleteRoom(
        com.glenoir.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRoom(room);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.glenoir.plugins.model.Room fetchRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRoom(roomId);
    }

    /**
    * Returns the room with the matching UUID and company.
    *
    * @param uuid the room's UUID
    * @param companyId the primary key of the company
    * @return the matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.glenoir.plugins.model.Room fetchRoomByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRoomByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the room with the primary key.
    *
    * @param roomId the primary key of the room
    * @return the room
    * @throws PortalException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.glenoir.plugins.model.Room getRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoom(roomId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static com.glenoir.plugins.model.Room getRoomByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns a range of all the rooms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @return the range of rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.glenoir.plugins.model.Room> getRooms(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRooms(start, end);
    }

    /**
    * Returns the number of rooms.
    *
    * @return the number of rooms
    * @throws SystemException if a system exception occurred
    */
    public static int getRoomsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomsCount();
    }

    /**
    * Updates the room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param room the room
    * @return the room that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.glenoir.plugins.model.Room updateRoom(
        com.glenoir.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateRoom(room);
    }

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

    public static void clearService() {
        _service = null;
    }

    public static RoomLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RoomLocalService.class.getName());

            if (invokableLocalService instanceof RoomLocalService) {
                _service = (RoomLocalService) invokableLocalService;
            } else {
                _service = new RoomLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(RoomLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RoomLocalService service) {
    }
}
