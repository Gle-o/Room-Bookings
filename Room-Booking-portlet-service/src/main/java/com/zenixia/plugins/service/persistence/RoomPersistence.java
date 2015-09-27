package com.zenixia.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.zenixia.plugins.model.Room;

/**
 * The persistence interface for the room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see RoomPersistenceImpl
 * @see RoomUtil
 * @generated
 */
public interface RoomPersistence extends BasePersistence<Room> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RoomUtil} to access the room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the rooms where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the rooms where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @return the range of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the rooms where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first room in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the first room in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last room in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the last room in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the rooms before and after the current room in the ordered set where uuid = &#63;.
    *
    * @param roomId the primary key of the current room
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next room
    * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room[] findByUuid_PrevAndNext(
        long roomId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Removes all the rooms where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rooms where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the room where uuid = &#63; and groupId = &#63; or throws a {@link com.zenixia.plugins.NoSuchRoomException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByUUID_G(java.lang.String uuid,
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the room where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the room that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the number of rooms where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the rooms where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the rooms where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @return the range of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the rooms where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first room in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the first room in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last room in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the last room in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the rooms before and after the current room in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param roomId the primary key of the current room
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next room
    * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room[] findByUuid_C_PrevAndNext(
        long roomId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Removes all the rooms where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rooms where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the rooms where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the rooms where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @return the range of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the rooms where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the first room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room
    * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the last room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching room, or <code>null</code> if a matching room could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the rooms before and after the current room in the ordered set where groupId = &#63;.
    *
    * @param roomId the primary key of the current room
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next room
    * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room[] findByGroupId_PrevAndNext(
        long roomId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns all the rooms that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching rooms that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the rooms that the user has permission to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @return the range of matching rooms that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the rooms that the user has permissions to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rooms that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the rooms before and after the current room in the ordered set of rooms that the user has permission to view where groupId = &#63;.
    *
    * @param roomId the primary key of the current room
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next room
    * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room[] filterFindByGroupId_PrevAndNext(
        long roomId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Removes all the rooms where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rooms where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rooms that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching rooms that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the room in the entity cache if it is enabled.
    *
    * @param room the room
    */
    public void cacheResult(com.zenixia.plugins.model.Room room);

    /**
    * Caches the rooms in the entity cache if it is enabled.
    *
    * @param rooms the rooms
    */
    public void cacheResult(
        java.util.List<com.zenixia.plugins.model.Room> rooms);

    /**
    * Creates a new room with the primary key. Does not add the room to the database.
    *
    * @param roomId the primary key for the new room
    * @return the new room
    */
    public com.zenixia.plugins.model.Room create(long roomId);

    /**
    * Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the room
    * @return the room that was removed
    * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room remove(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    public com.zenixia.plugins.model.Room updateImpl(
        com.zenixia.plugins.model.Room room)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the room with the primary key or throws a {@link com.zenixia.plugins.NoSuchRoomException} if it could not be found.
    *
    * @param roomId the primary key of the room
    * @return the room
    * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room findByPrimaryKey(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchRoomException;

    /**
    * Returns the room with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param roomId the primary key of the room
    * @return the room, or <code>null</code> if a room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.zenixia.plugins.model.Room fetchByPrimaryKey(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the rooms.
    *
    * @return the rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.zenixia.plugins.model.Room> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the rooms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of rooms
    * @param end the upper bound of the range of rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.zenixia.plugins.model.Room> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the rooms from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rooms.
    *
    * @return the number of rooms
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
