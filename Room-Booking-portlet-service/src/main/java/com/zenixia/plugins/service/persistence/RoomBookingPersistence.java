package com.zenixia.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.zenixia.plugins.model.RoomBooking;

/**
 * The persistence interface for the room booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see RoomBookingPersistenceImpl
 * @see RoomBookingUtil
 * @generated
 */
public interface RoomBookingPersistence extends BasePersistence<RoomBooking> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RoomBookingUtil} to access the room booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the room bookings where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the first room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the last room booking in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.zenixia.plugins.model.RoomBooking[] findByUuid_PrevAndNext(
        long roomBookingId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Removes all the room bookings where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of room bookings where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the room booking where uuid = &#63; and groupId = &#63; or throws a {@link com.zenixia.plugins.NoSuchRoomBookingException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the room booking where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the room booking where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the room booking where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the room booking that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the number of room bookings where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the room bookings where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.zenixia.plugins.model.RoomBooking findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the first room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.zenixia.plugins.model.RoomBooking findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the last room booking in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room booking, or <code>null</code> if a matching room booking could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.zenixia.plugins.model.RoomBooking[] findByUuid_C_PrevAndNext(
        long roomBookingId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Removes all the room bookings where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of room bookings where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching room bookings
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the room booking in the entity cache if it is enabled.
    *
    * @param roomBooking the room booking
    */
    public void cacheResult(com.zenixia.plugins.model.RoomBooking roomBooking);

    /**
    * Caches the room bookings in the entity cache if it is enabled.
    *
    * @param roomBookings the room bookings
    */
    public void cacheResult(
        java.util.List<com.zenixia.plugins.model.RoomBooking> roomBookings);

    /**
    * Creates a new room booking with the primary key. Does not add the room booking to the database.
    *
    * @param roomBookingId the primary key for the new room booking
    * @return the new room booking
    */
    public com.zenixia.plugins.model.RoomBooking create(long roomBookingId);

    /**
    * Removes the room booking with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking that was removed
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking remove(long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    public com.zenixia.plugins.model.RoomBooking updateImpl(
        com.zenixia.plugins.model.RoomBooking roomBooking)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the room booking with the primary key or throws a {@link com.zenixia.plugins.NoSuchRoomBookingException} if it could not be found.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking
    * @throws com.zenixia.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking findByPrimaryKey(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomBookingException;

    /**
    * Returns the room booking with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param roomBookingId the primary key of the room booking
    * @return the room booking, or <code>null</code> if a room booking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.RoomBooking fetchByPrimaryKey(
        long roomBookingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the room bookings.
    *
    * @return the room bookings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.RoomBooking> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the room bookings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of room bookings.
    *
    * @return the number of room bookings
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
