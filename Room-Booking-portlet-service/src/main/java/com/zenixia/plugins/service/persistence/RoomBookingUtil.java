package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.zenixia.plugins.model.RoomBooking;

import java.util.List;

/**
 * The persistence utility for the room booking service. This utility wraps {@link RoomBookingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see RoomBookingPersistence
 * @see RoomBookingPersistenceImpl
 * @generated
 */
public class RoomBookingUtil {
    private static RoomBookingPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(RoomBooking roomBooking) {
        getPersistence().clearCache(roomBooking);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<RoomBooking> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<RoomBooking> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<RoomBooking> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static RoomBooking update(RoomBooking roomBooking)
        throws SystemException {
        return getPersistence().update(roomBooking);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static RoomBooking update(RoomBooking roomBooking,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(roomBooking, serviceContext);
    }

    /**
    * Returns all the room bookings where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the room bookings where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of room bookings
    * @param end the upper bound of the range of room bookings (not inclusive)
    * @return the range of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the room bookings where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of room bookings
    * @param end the upper bound of the range of room bookings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the room bookings before and after the current room booking in the ordered set where uuid = &#63;.
    *
    * @param roomBookingId the primary key of the current room booking
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking[] findByUuid_PrevAndNext(
        long roomBookingId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence()
                   .findByUuid_PrevAndNext(roomBookingId, uuid,
            orderByComparator);
    }

    /**
    * Removes all the room bookings where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of room bookings where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the room booking where uuid = &#63; and groupId = &#63; or throws a {@link com.zenixia.plugins.NoSuchRoomBookingException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the room booking where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the room booking where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the room booking where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the room booking that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of room bookings where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the room bookings where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the room bookings where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of room bookings
    * @param end the upper bound of the range of room bookings (not inclusive)
    * @return the range of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the room bookings where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of room bookings
    * @param end the upper bound of the range of room bookings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the room bookings before and after the current room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param roomBookingId the primary key of the current room booking
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking[] findByUuid_C_PrevAndNext(
        long roomBookingId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(roomBookingId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the room bookings where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of room bookings where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Caches the room booking in the entity cache if it is enabled.
    *
    * @param roomBooking the room booking
    */
    public static void cacheResult(
        com.zenixia.plugins.model.RoomBooking roomBooking) {
        getPersistence().cacheResult(roomBooking);
    }

    /**
    * Caches the room bookings in the entity cache if it is enabled.
    *
    * @param roomBookings the room bookings
    */
    public static void cacheResult(
        java.util.List<com.zenixia.plugins.model.RoomBooking> roomBookings) {
        getPersistence().cacheResult(roomBookings);
    }

    /**
    * Creates a new room booking with the primary key. Does not add the room booking to the database.
    *
    * @param roomBookingId the primary key for the new room booking
    * @return the new room booking
    */
    public static com.zenixia.plugins.model.RoomBooking create(
        long roomBookingId) {
        return getPersistence().create(roomBookingId);
    }

    /**
    * Removes the room booking with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking that was removed
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking remove(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence().remove(roomBookingId);
    }

    public static com.zenixia.plugins.model.RoomBooking updateImpl(
        com.zenixia.plugins.model.RoomBooking roomBooking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(roomBooking);
    }

    /**
    * Returns the room booking with the primary key or throws a {@link com.zenixia.plugins.NoSuchRoomBookingException} if it could not be found.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking findByPrimaryKey(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException {
        return getPersistence().findByPrimaryKey(roomBookingId);
    }

    /**
    * Returns the room booking with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking, or <code>null</code> if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.RoomBooking fetchByPrimaryKey(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(roomBookingId);
    }

    /**
    * Returns all the room bookings.
    *
    * @return the room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the room bookings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of room bookings
    * @param end the upper bound of the range of room bookings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of room bookings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.RoomBooking> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the room bookings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of room bookings.
    *
    * @return the number of room bookings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RoomBookingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RoomBookingPersistence) PortletBeanLocatorUtil.locate(com.zenixia.plugins.service.ClpSerializer.getServletContextName(),
                    RoomBookingPersistence.class.getName());

            ReferenceRegistry.registerReference(RoomBookingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RoomBookingPersistence persistence) {
    }
}
