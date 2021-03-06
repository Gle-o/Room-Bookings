package com.zenixia.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RoomBooking. This utility wraps
 * {@link com.zenixia.plugins.service.impl.RoomBookingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Guillaume Lenoir
 * @see RoomBookingLocalService
 * @see com.zenixia.plugins.service.base.RoomBookingLocalServiceBaseImpl
 * @see com.zenixia.plugins.service.impl.RoomBookingLocalServiceImpl
 * @generated
 */
public class RoomBookingLocalServiceUtil {
    private static RoomBookingLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.zenixia.plugins.service.impl.RoomBookingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the room booking to the database. Also notifies the appropriate model listeners.
    *
    * @param roomBooking the room booking
    * @return the room booking that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking addRoomBooking(
        com.zenixia.plugins.model.RoomBooking roomBooking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addRoomBooking(roomBooking);
    }

    /**
    * Creates a new room booking with the primary key. Does not add the room booking to the database.
    *
    * @param roomBookingId the primary key for the new room booking
    * @return the new room booking
    */
    public static com.zenixia.plugins.model.RoomBooking createRoomBooking(
        long roomBookingId) {
        return getService().createRoomBooking(roomBookingId);
    }

    /**
    * Deletes the room booking with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking that was removed
    * @throws PortalException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking deleteRoomBooking(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRoomBooking(roomBookingId);
    }

    /**
    * Deletes the room booking from the database. Also notifies the appropriate model listeners.
    *
    * @param roomBooking the room booking
    * @return the room booking that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking deleteRoomBooking(
        com.zenixia.plugins.model.RoomBooking roomBooking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRoomBooking(roomBooking);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.zenixia.plugins.model.RoomBooking fetchRoomBooking(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRoomBooking(roomBookingId);
    }

    /**
    * Returns the room booking with the matching UUID and company.
    *
    * @param uuid the room booking's UUID
    * @param companyId the primary key of the company
    * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchRoomBookingByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRoomBookingByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the room booking matching the UUID and group.
    *
    * @param uuid the room booking's UUID
    * @param groupId the primary key of the group
    * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchRoomBookingByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRoomBookingByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the room booking with the primary key.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking
    * @throws PortalException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking getRoomBooking(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomBooking(roomBookingId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the room booking with the matching UUID and company.
    *
    * @param uuid the room booking's UUID
    * @param companyId the primary key of the company
    * @return the matching room booking
    * @throws PortalException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking getRoomBookingByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomBookingByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the room booking matching the UUID and group.
    *
    * @param uuid the room booking's UUID
    * @param groupId the primary key of the group
    * @return the matching room booking
    * @throws PortalException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking getRoomBookingByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomBookingByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the room bookings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of room bookings
    * @param end the upper bound of the range of room bookings (not inclusive)
    * @return the range of room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> getRoomBookings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomBookings(start, end);
    }

    /**
    * Returns the number of room bookings.
    *
    * @return the number of room bookings
    * @throws SystemException if a system exception occurred
    */
    public static int getRoomBookingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomBookingsCount();
    }

    /**
    * Updates the room booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param roomBooking the room booking
    * @return the room booking that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking updateRoomBooking(
        com.zenixia.plugins.model.RoomBooking roomBooking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateRoomBooking(roomBooking);
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

    public static RoomBookingLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RoomBookingLocalService.class.getName());

            if (invokableLocalService instanceof RoomBookingLocalService) {
                _service = (RoomBookingLocalService) invokableLocalService;
            } else {
                _service = new RoomBookingLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(RoomBookingLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RoomBookingLocalService service) {
    }
}
