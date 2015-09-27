package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.zenixia.plugins.NoSuchRoomException;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.model.impl.RoomImpl;
import com.zenixia.plugins.model.impl.RoomModelImpl;
import com.zenixia.plugins.service.persistence.RoomPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see RoomPersistence
 * @see RoomUtil
 * @generated
 */
public class RoomPersistenceImpl extends BasePersistenceImpl<Room>
    implements RoomPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RoomUtil} to access the room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RoomImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            RoomModelImpl.UUID_COLUMN_BITMASK |
            RoomModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "room.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "room.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(room.uuid IS NULL OR room.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            RoomModelImpl.UUID_COLUMN_BITMASK |
            RoomModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "room.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "room.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(room.uuid IS NULL OR room.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "room.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            RoomModelImpl.UUID_COLUMN_BITMASK |
            RoomModelImpl.COMPANYID_COLUMN_BITMASK |
            RoomModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "room.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "room.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(room.uuid IS NULL OR room.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "room.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, RoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            RoomModelImpl.GROUPID_COLUMN_BITMASK |
            RoomModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "room.groupId = ?";
    private static final String _SQL_SELECT_ROOM = "SELECT room FROM Room room";
    private static final String _SQL_SELECT_ROOM_WHERE = "SELECT room FROM Room room WHERE ";
    private static final String _SQL_COUNT_ROOM = "SELECT COUNT(room) FROM Room room";
    private static final String _SQL_COUNT_ROOM_WHERE = "SELECT COUNT(room) FROM Room room WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "room.roomId";
    private static final String _FILTER_SQL_SELECT_ROOM_WHERE = "SELECT DISTINCT {room.*} FROM RoomBooking_Room room WHERE ";
    private static final String _FILTER_SQL_SELECT_ROOM_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {RoomBooking_Room.*} FROM (SELECT DISTINCT room.roomId FROM RoomBooking_Room room WHERE ";
    private static final String _FILTER_SQL_SELECT_ROOM_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN RoomBooking_Room ON TEMP_TABLE.roomId = RoomBooking_Room.roomId";
    private static final String _FILTER_SQL_COUNT_ROOM_WHERE = "SELECT COUNT(DISTINCT room.roomId) AS COUNT_VALUE FROM RoomBooking_Room room WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "room";
    private static final String _FILTER_ENTITY_TABLE = "RoomBooking_Room";
    private static final String _ORDER_BY_ENTITY_ALIAS = "room.";
    private static final String _ORDER_BY_ENTITY_TABLE = "RoomBooking_Room.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Room exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Room exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RoomPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Room _nullRoom = new RoomImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Room> toCacheModel() {
                return _nullRoomCacheModel;
            }
        };

    private static CacheModel<Room> _nullRoomCacheModel = new CacheModel<Room>() {
            @Override
            public Room toEntityModel() {
                return _nullRoom;
            }
        };

    public RoomPersistenceImpl() {
        setModelClass(Room.class);
    }

    /**
     * Returns all the rooms where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Room> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Room> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

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
    @Override
    public List<Room> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Room> list = (List<Room>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Room room : list) {
                if (!Validator.equals(uuid, room.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_ROOM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RoomModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Room>(list);
                } else {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first room in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room
     * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByUuid_First(uuid, orderByComparator);

        if (room != null) {
            return room;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomException(msg.toString());
    }

    /**
     * Returns the first room in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Room> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last room in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room
     * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByUuid_Last(uuid, orderByComparator);

        if (room != null) {
            return room;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomException(msg.toString());
    }

    /**
     * Returns the last room in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Room> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Room[] findByUuid_PrevAndNext(long roomId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            Room[] array = new RoomImpl[3];

            array[0] = getByUuid_PrevAndNext(session, room, uuid,
                    orderByComparator, true);

            array[1] = room;

            array[2] = getByUuid_PrevAndNext(session, room, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Room getByUuid_PrevAndNext(Session session, Room room,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ROOM_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RoomModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(room);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Room> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the rooms where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Room room : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(room);
        }
    }

    /**
     * Returns the number of rooms where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ROOM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the room where uuid = &#63; and groupId = &#63; or throws a {@link com.zenixia.plugins.NoSuchRoomException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching room
     * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByUUID_G(String uuid, long groupId)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByUUID_G(uuid, groupId);

        if (room == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRoomException(msg.toString());
        }

        return room;
    }

    /**
     * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the room where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Room) {
            Room room = (Room) result;

            if (!Validator.equals(uuid, room.getUuid()) ||
                    (groupId != room.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_ROOM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Room> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Room room = list.get(0);

                    result = room;

                    cacheResult(room);

                    if ((room.getUuid() == null) ||
                            !room.getUuid().equals(uuid) ||
                            (room.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, room);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Room) result;
        }
    }

    /**
     * Removes the room where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the room that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room removeByUUID_G(String uuid, long groupId)
        throws NoSuchRoomException, SystemException {
        Room room = findByUUID_G(uuid, groupId);

        return remove(room);
    }

    /**
     * Returns the number of rooms where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_ROOM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the rooms where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Room> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Room> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

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
    @Override
    public List<Room> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Room> list = (List<Room>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Room room : list) {
                if (!Validator.equals(uuid, room.getUuid()) ||
                        (companyId != room.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_ROOM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RoomModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Room>(list);
                } else {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

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
    @Override
    public Room findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (room != null) {
            return room;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomException(msg.toString());
    }

    /**
     * Returns the first room in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Room> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Room findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (room != null) {
            return room;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomException(msg.toString());
    }

    /**
     * Returns the last room in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Room> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Room[] findByUuid_C_PrevAndNext(long roomId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            Room[] array = new RoomImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, room, uuid, companyId,
                    orderByComparator, true);

            array[1] = room;

            array[2] = getByUuid_C_PrevAndNext(session, room, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Room getByUuid_C_PrevAndNext(Session session, Room room,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ROOM_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RoomModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(room);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Room> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the rooms where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Room room : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(room);
        }
    }

    /**
     * Returns the number of rooms where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_ROOM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the rooms where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Room> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Room> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

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
    @Override
    public List<Room> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Room> list = (List<Room>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Room room : list) {
                if ((groupId != room.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_ROOM_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RoomModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Room>(list);
                } else {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room
     * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByGroupId_First(groupId, orderByComparator);

        if (room != null) {
            return room;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomException(msg.toString());
    }

    /**
     * Returns the first room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Room> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room
     * @throws com.zenixia.plugins.NoSuchRoomException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByGroupId_Last(groupId, orderByComparator);

        if (room != null) {
            return room;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomException(msg.toString());
    }

    /**
     * Returns the last room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Room> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Room[] findByGroupId_PrevAndNext(long roomId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        Room room = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            Room[] array = new RoomImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, room, groupId,
                    orderByComparator, true);

            array[1] = room;

            array[2] = getByGroupId_PrevAndNext(session, room, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Room getByGroupId_PrevAndNext(Session session, Room room,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ROOM_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RoomModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(room);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Room> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the rooms that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching rooms that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Room> filterFindByGroupId(long groupId)
        throws SystemException {
        return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Room> filterFindByGroupId(long groupId, int start, int end)
        throws SystemException {
        return filterFindByGroupId(groupId, start, end, null);
    }

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
    @Override
    public List<Room> filterFindByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId(groupId, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(3 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_ROOM_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_ROOM_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_ROOM_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(RoomModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(RoomModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Room.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, RoomImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, RoomImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            return (List<Room>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

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
    @Override
    public Room[] filterFindByGroupId_PrevAndNext(long roomId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId_PrevAndNext(roomId, groupId, orderByComparator);
        }

        Room room = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            Room[] array = new RoomImpl[3];

            array[0] = filterGetByGroupId_PrevAndNext(session, room, groupId,
                    orderByComparator, true);

            array[1] = room;

            array[2] = filterGetByGroupId_PrevAndNext(session, room, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Room filterGetByGroupId_PrevAndNext(Session session, Room room,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_ROOM_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_ROOM_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_ROOM_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(RoomModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(RoomModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Room.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, RoomImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, RoomImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(room);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Room> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the rooms where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Room room : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(room);
        }
    }

    /**
     * Returns the number of rooms where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ROOM_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of rooms that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching rooms that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupId(long groupId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupId(groupId);
        }

        StringBundler query = new StringBundler(2);

        query.append(_FILTER_SQL_COUNT_ROOM_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Room.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Caches the room in the entity cache if it is enabled.
     *
     * @param room the room
     */
    @Override
    public void cacheResult(Room room) {
        EntityCacheUtil.putResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomImpl.class, room.getPrimaryKey(), room);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { room.getUuid(), room.getGroupId() }, room);

        room.resetOriginalValues();
    }

    /**
     * Caches the rooms in the entity cache if it is enabled.
     *
     * @param rooms the rooms
     */
    @Override
    public void cacheResult(List<Room> rooms) {
        for (Room room : rooms) {
            if (EntityCacheUtil.getResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
                        RoomImpl.class, room.getPrimaryKey()) == null) {
                cacheResult(room);
            } else {
                room.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all rooms.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RoomImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RoomImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the room.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Room room) {
        EntityCacheUtil.removeResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomImpl.class, room.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(room);
    }

    @Override
    public void clearCache(List<Room> rooms) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Room room : rooms) {
            EntityCacheUtil.removeResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
                RoomImpl.class, room.getPrimaryKey());

            clearUniqueFindersCache(room);
        }
    }

    protected void cacheUniqueFindersCache(Room room) {
        if (room.isNew()) {
            Object[] args = new Object[] { room.getUuid(), room.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, room);
        } else {
            RoomModelImpl roomModelImpl = (RoomModelImpl) room;

            if ((roomModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { room.getUuid(), room.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    room);
            }
        }
    }

    protected void clearUniqueFindersCache(Room room) {
        RoomModelImpl roomModelImpl = (RoomModelImpl) room;

        Object[] args = new Object[] { room.getUuid(), room.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((roomModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    roomModelImpl.getOriginalUuid(),
                    roomModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new room with the primary key. Does not add the room to the database.
     *
     * @param roomId the primary key for the new room
     * @return the new room
     */
    @Override
    public Room create(long roomId) {
        Room room = new RoomImpl();

        room.setNew(true);
        room.setPrimaryKey(roomId);

        String uuid = PortalUUIDUtil.generate();

        room.setUuid(uuid);

        return room;
    }

    /**
     * Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param roomId the primary key of the room
     * @return the room that was removed
     * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room remove(long roomId) throws NoSuchRoomException, SystemException {
        return remove((Serializable) roomId);
    }

    /**
     * Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the room
     * @return the room that was removed
     * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room remove(Serializable primaryKey)
        throws NoSuchRoomException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Room room = (Room) session.get(RoomImpl.class, primaryKey);

            if (room == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(room);
        } catch (NoSuchRoomException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Room removeImpl(Room room) throws SystemException {
        room = toUnwrappedModel(room);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(room)) {
                room = (Room) session.get(RoomImpl.class,
                        room.getPrimaryKeyObj());
            }

            if (room != null) {
                session.delete(room);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (room != null) {
            clearCache(room);
        }

        return room;
    }

    @Override
    public Room updateImpl(com.zenixia.plugins.model.Room room)
        throws SystemException {
        room = toUnwrappedModel(room);

        boolean isNew = room.isNew();

        RoomModelImpl roomModelImpl = (RoomModelImpl) room;

        if (Validator.isNull(room.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            room.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (room.isNew()) {
                session.save(room);

                room.setNew(false);
            } else {
                session.merge(room);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RoomModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((roomModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { roomModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { roomModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((roomModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        roomModelImpl.getOriginalUuid(),
                        roomModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        roomModelImpl.getUuid(), roomModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((roomModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { roomModelImpl.getOriginalGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { roomModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
            RoomImpl.class, room.getPrimaryKey(), room);

        clearUniqueFindersCache(room);
        cacheUniqueFindersCache(room);

        return room;
    }

    protected Room toUnwrappedModel(Room room) {
        if (room instanceof RoomImpl) {
            return room;
        }

        RoomImpl roomImpl = new RoomImpl();

        roomImpl.setNew(room.isNew());
        roomImpl.setPrimaryKey(room.getPrimaryKey());

        roomImpl.setUuid(room.getUuid());
        roomImpl.setRoomId(room.getRoomId());
        roomImpl.setCompanyId(room.getCompanyId());
        roomImpl.setGroupId(room.getGroupId());
        roomImpl.setUserId(room.getUserId());
        roomImpl.setUserName(room.getUserName());
        roomImpl.setCreateDate(room.getCreateDate());
        roomImpl.setModifiedDate(room.getModifiedDate());
        roomImpl.setName(room.getName());
        roomImpl.setDescription(room.getDescription());
        roomImpl.setCapacity(room.getCapacity());
        roomImpl.setLevel(room.getLevel());

        return roomImpl;
    }

    /**
     * Returns the room with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the room
     * @return the room
     * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRoomException, SystemException {
        Room room = fetchByPrimaryKey(primaryKey);

        if (room == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return room;
    }

    /**
     * Returns the room with the primary key or throws a {@link com.zenixia.plugins.NoSuchRoomException} if it could not be found.
     *
     * @param roomId the primary key of the room
     * @return the room
     * @throws com.zenixia.plugins.NoSuchRoomException if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room findByPrimaryKey(long roomId)
        throws NoSuchRoomException, SystemException {
        return findByPrimaryKey((Serializable) roomId);
    }

    /**
     * Returns the room with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the room
     * @return the room, or <code>null</code> if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Room room = (Room) EntityCacheUtil.getResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
                RoomImpl.class, primaryKey);

        if (room == _nullRoom) {
            return null;
        }

        if (room == null) {
            Session session = null;

            try {
                session = openSession();

                room = (Room) session.get(RoomImpl.class, primaryKey);

                if (room != null) {
                    cacheResult(room);
                } else {
                    EntityCacheUtil.putResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
                        RoomImpl.class, primaryKey, _nullRoom);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
                    RoomImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return room;
    }

    /**
     * Returns the room with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param roomId the primary key of the room
     * @return the room, or <code>null</code> if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchByPrimaryKey(long roomId) throws SystemException {
        return fetchByPrimaryKey((Serializable) roomId);
    }

    /**
     * Returns all the rooms.
     *
     * @return the rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Room> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Room> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Room> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Room> list = (List<Room>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ROOM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ROOM;

                if (pagination) {
                    sql = sql.concat(RoomModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Room>(list);
                } else {
                    list = (List<Room>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the rooms from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Room room : findAll()) {
            remove(room);
        }
    }

    /**
     * Returns the number of rooms.
     *
     * @return the number of rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_ROOM);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the room persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.zenixia.plugins.model.Room")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Room>> listenersList = new ArrayList<ModelListener<Room>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Room>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RoomImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
