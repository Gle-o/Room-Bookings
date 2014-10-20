package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.NoSuchRoomBookingException;
import com.glenoir.plugins.model.RoomBooking;
import com.glenoir.plugins.model.impl.RoomBookingImpl;
import com.glenoir.plugins.model.impl.RoomBookingModelImpl;
import com.glenoir.plugins.service.persistence.RoomBookingPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the room booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaume Lenoir
 * @see RoomBookingPersistence
 * @see RoomBookingUtil
 * @generated
 */
public class RoomBookingPersistenceImpl extends BasePersistenceImpl<RoomBooking>
    implements RoomBookingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RoomBookingUtil} to access the room booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RoomBookingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            RoomBookingModelImpl.UUID_COLUMN_BITMASK |
            RoomBookingModelImpl.STARTTIME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "roomBooking.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "roomBooking.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(roomBooking.uuid IS NULL OR roomBooking.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            RoomBookingModelImpl.UUID_COLUMN_BITMASK |
            RoomBookingModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "roomBooking.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "roomBooking.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(roomBooking.uuid IS NULL OR roomBooking.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "roomBooking.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, RoomBookingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            RoomBookingModelImpl.UUID_COLUMN_BITMASK |
            RoomBookingModelImpl.COMPANYID_COLUMN_BITMASK |
            RoomBookingModelImpl.STARTTIME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "roomBooking.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "roomBooking.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(roomBooking.uuid IS NULL OR roomBooking.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "roomBooking.companyId = ?";
    private static final String _SQL_SELECT_ROOMBOOKING = "SELECT roomBooking FROM RoomBooking roomBooking";
    private static final String _SQL_SELECT_ROOMBOOKING_WHERE = "SELECT roomBooking FROM RoomBooking roomBooking WHERE ";
    private static final String _SQL_COUNT_ROOMBOOKING = "SELECT COUNT(roomBooking) FROM RoomBooking roomBooking";
    private static final String _SQL_COUNT_ROOMBOOKING_WHERE = "SELECT COUNT(roomBooking) FROM RoomBooking roomBooking WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "roomBooking.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RoomBooking exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RoomBooking exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RoomBookingPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static RoomBooking _nullRoomBooking = new RoomBookingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<RoomBooking> toCacheModel() {
                return _nullRoomBookingCacheModel;
            }
        };

    private static CacheModel<RoomBooking> _nullRoomBookingCacheModel = new CacheModel<RoomBooking>() {
            @Override
            public RoomBooking toEntityModel() {
                return _nullRoomBooking;
            }
        };

    public RoomBookingPersistenceImpl() {
        setModelClass(RoomBooking.class);
    }

    /**
     * Returns all the room bookings where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the room bookings where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of room bookings
     * @param end the upper bound of the range of room bookings (not inclusive)
     * @return the range of matching room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the room bookings where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of room bookings
     * @param end the upper bound of the range of room bookings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findByUuid(String uuid, int start, int end,
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

        List<RoomBooking> list = (List<RoomBooking>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RoomBooking roomBooking : list) {
                if (!Validator.equals(uuid, roomBooking.getUuid())) {
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

            query.append(_SQL_SELECT_ROOMBOOKING_WHERE);

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
                query.append(RoomBookingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<RoomBooking>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<RoomBooking>(list);
                } else {
                    list = (List<RoomBooking>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first room booking in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = fetchByUuid_First(uuid, orderByComparator);

        if (roomBooking != null) {
            return roomBooking;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomBookingException(msg.toString());
    }

    /**
     * Returns the first room booking in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room booking, or <code>null</code> if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<RoomBooking> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last room booking in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = fetchByUuid_Last(uuid, orderByComparator);

        if (roomBooking != null) {
            return roomBooking;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomBookingException(msg.toString());
    }

    /**
     * Returns the last room booking in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room booking, or <code>null</code> if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<RoomBooking> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the room bookings before and after the current room booking in the ordered set where uuid = &#63;.
     *
     * @param roomBookingId the primary key of the current room booking
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking[] findByUuid_PrevAndNext(long roomBookingId,
        String uuid, OrderByComparator orderByComparator)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = findByPrimaryKey(roomBookingId);

        Session session = null;

        try {
            session = openSession();

            RoomBooking[] array = new RoomBookingImpl[3];

            array[0] = getByUuid_PrevAndNext(session, roomBooking, uuid,
                    orderByComparator, true);

            array[1] = roomBooking;

            array[2] = getByUuid_PrevAndNext(session, roomBooking, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RoomBooking getByUuid_PrevAndNext(Session session,
        RoomBooking roomBooking, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ROOMBOOKING_WHERE);

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
            query.append(RoomBookingModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(roomBooking);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RoomBooking> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the room bookings where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (RoomBooking roomBooking : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(roomBooking);
        }
    }

    /**
     * Returns the number of room bookings where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching room bookings
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

            query.append(_SQL_COUNT_ROOMBOOKING_WHERE);

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
     * Returns the room booking where uuid = &#63; and groupId = &#63; or throws a {@link com.glenoir.plugins.NoSuchRoomBookingException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByUUID_G(String uuid, long groupId)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = fetchByUUID_G(uuid, groupId);

        if (roomBooking == null) {
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

            throw new NoSuchRoomBookingException(msg.toString());
        }

        return roomBooking;
    }

    /**
     * Returns the room booking where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching room booking, or <code>null</code> if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public RoomBooking fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof RoomBooking) {
            RoomBooking roomBooking = (RoomBooking) result;

            if (!Validator.equals(uuid, roomBooking.getUuid()) ||
                    (groupId != roomBooking.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_ROOMBOOKING_WHERE);

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

                List<RoomBooking> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    RoomBooking roomBooking = list.get(0);

                    result = roomBooking;

                    cacheResult(roomBooking);

                    if ((roomBooking.getUuid() == null) ||
                            !roomBooking.getUuid().equals(uuid) ||
                            (roomBooking.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, roomBooking);
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
            return (RoomBooking) result;
        }
    }

    /**
     * Removes the room booking where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the room booking that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking removeByUUID_G(String uuid, long groupId)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = findByUUID_G(uuid, groupId);

        return remove(roomBooking);
    }

    /**
     * Returns the number of room bookings where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching room bookings
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

            query.append(_SQL_COUNT_ROOMBOOKING_WHERE);

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
     * Returns all the room bookings where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the room bookings where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of room bookings
     * @param end the upper bound of the range of room bookings (not inclusive)
     * @return the range of matching room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the room bookings where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    @Override
    public List<RoomBooking> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<RoomBooking> list = (List<RoomBooking>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RoomBooking roomBooking : list) {
                if (!Validator.equals(uuid, roomBooking.getUuid()) ||
                        (companyId != roomBooking.getCompanyId())) {
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

            query.append(_SQL_SELECT_ROOMBOOKING_WHERE);

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
                query.append(RoomBookingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<RoomBooking>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<RoomBooking>(list);
                } else {
                    list = (List<RoomBooking>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first room booking in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (roomBooking != null) {
            return roomBooking;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomBookingException(msg.toString());
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
    @Override
    public RoomBooking fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<RoomBooking> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last room booking in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a matching room booking could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (roomBooking != null) {
            return roomBooking;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRoomBookingException(msg.toString());
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
    @Override
    public RoomBooking fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<RoomBooking> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the room bookings before and after the current room booking in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param roomBookingId the primary key of the current room booking
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking[] findByUuid_C_PrevAndNext(long roomBookingId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = findByPrimaryKey(roomBookingId);

        Session session = null;

        try {
            session = openSession();

            RoomBooking[] array = new RoomBookingImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, roomBooking, uuid,
                    companyId, orderByComparator, true);

            array[1] = roomBooking;

            array[2] = getByUuid_C_PrevAndNext(session, roomBooking, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RoomBooking getByUuid_C_PrevAndNext(Session session,
        RoomBooking roomBooking, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ROOMBOOKING_WHERE);

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
            query.append(RoomBookingModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(roomBooking);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RoomBooking> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the room bookings where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (RoomBooking roomBooking : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(roomBooking);
        }
    }

    /**
     * Returns the number of room bookings where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching room bookings
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

            query.append(_SQL_COUNT_ROOMBOOKING_WHERE);

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
     * Caches the room booking in the entity cache if it is enabled.
     *
     * @param roomBooking the room booking
     */
    @Override
    public void cacheResult(RoomBooking roomBooking) {
        EntityCacheUtil.putResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingImpl.class, roomBooking.getPrimaryKey(), roomBooking);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { roomBooking.getUuid(), roomBooking.getGroupId() },
            roomBooking);

        roomBooking.resetOriginalValues();
    }

    /**
     * Caches the room bookings in the entity cache if it is enabled.
     *
     * @param roomBookings the room bookings
     */
    @Override
    public void cacheResult(List<RoomBooking> roomBookings) {
        for (RoomBooking roomBooking : roomBookings) {
            if (EntityCacheUtil.getResult(
                        RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
                        RoomBookingImpl.class, roomBooking.getPrimaryKey()) == null) {
                cacheResult(roomBooking);
            } else {
                roomBooking.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all room bookings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RoomBookingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RoomBookingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the room booking.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(RoomBooking roomBooking) {
        EntityCacheUtil.removeResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingImpl.class, roomBooking.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(roomBooking);
    }

    @Override
    public void clearCache(List<RoomBooking> roomBookings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (RoomBooking roomBooking : roomBookings) {
            EntityCacheUtil.removeResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
                RoomBookingImpl.class, roomBooking.getPrimaryKey());

            clearUniqueFindersCache(roomBooking);
        }
    }

    protected void cacheUniqueFindersCache(RoomBooking roomBooking) {
        if (roomBooking.isNew()) {
            Object[] args = new Object[] {
                    roomBooking.getUuid(), roomBooking.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                roomBooking);
        } else {
            RoomBookingModelImpl roomBookingModelImpl = (RoomBookingModelImpl) roomBooking;

            if ((roomBookingModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        roomBooking.getUuid(), roomBooking.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    roomBooking);
            }
        }
    }

    protected void clearUniqueFindersCache(RoomBooking roomBooking) {
        RoomBookingModelImpl roomBookingModelImpl = (RoomBookingModelImpl) roomBooking;

        Object[] args = new Object[] {
                roomBooking.getUuid(), roomBooking.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((roomBookingModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    roomBookingModelImpl.getOriginalUuid(),
                    roomBookingModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new room booking with the primary key. Does not add the room booking to the database.
     *
     * @param roomBookingId the primary key for the new room booking
     * @return the new room booking
     */
    @Override
    public RoomBooking create(long roomBookingId) {
        RoomBooking roomBooking = new RoomBookingImpl();

        roomBooking.setNew(true);
        roomBooking.setPrimaryKey(roomBookingId);

        String uuid = PortalUUIDUtil.generate();

        roomBooking.setUuid(uuid);

        return roomBooking;
    }

    /**
     * Removes the room booking with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param roomBookingId the primary key of the room booking
     * @return the room booking that was removed
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking remove(long roomBookingId)
        throws NoSuchRoomBookingException, SystemException {
        return remove((Serializable) roomBookingId);
    }

    /**
     * Removes the room booking with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the room booking
     * @return the room booking that was removed
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking remove(Serializable primaryKey)
        throws NoSuchRoomBookingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            RoomBooking roomBooking = (RoomBooking) session.get(RoomBookingImpl.class,
                    primaryKey);

            if (roomBooking == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRoomBookingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(roomBooking);
        } catch (NoSuchRoomBookingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected RoomBooking removeImpl(RoomBooking roomBooking)
        throws SystemException {
        roomBooking = toUnwrappedModel(roomBooking);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(roomBooking)) {
                roomBooking = (RoomBooking) session.get(RoomBookingImpl.class,
                        roomBooking.getPrimaryKeyObj());
            }

            if (roomBooking != null) {
                session.delete(roomBooking);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (roomBooking != null) {
            clearCache(roomBooking);
        }

        return roomBooking;
    }

    @Override
    public RoomBooking updateImpl(
        com.glenoir.plugins.model.RoomBooking roomBooking)
        throws SystemException {
        roomBooking = toUnwrappedModel(roomBooking);

        boolean isNew = roomBooking.isNew();

        RoomBookingModelImpl roomBookingModelImpl = (RoomBookingModelImpl) roomBooking;

        if (Validator.isNull(roomBooking.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            roomBooking.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (roomBooking.isNew()) {
                session.save(roomBooking);

                roomBooking.setNew(false);
            } else {
                session.merge(roomBooking);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RoomBookingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((roomBookingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        roomBookingModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { roomBookingModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((roomBookingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        roomBookingModelImpl.getOriginalUuid(),
                        roomBookingModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        roomBookingModelImpl.getUuid(),
                        roomBookingModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
            RoomBookingImpl.class, roomBooking.getPrimaryKey(), roomBooking);

        clearUniqueFindersCache(roomBooking);
        cacheUniqueFindersCache(roomBooking);

        return roomBooking;
    }

    protected RoomBooking toUnwrappedModel(RoomBooking roomBooking) {
        if (roomBooking instanceof RoomBookingImpl) {
            return roomBooking;
        }

        RoomBookingImpl roomBookingImpl = new RoomBookingImpl();

        roomBookingImpl.setNew(roomBooking.isNew());
        roomBookingImpl.setPrimaryKey(roomBooking.getPrimaryKey());

        roomBookingImpl.setUuid(roomBooking.getUuid());
        roomBookingImpl.setRoomBookingId(roomBooking.getRoomBookingId());
        roomBookingImpl.setCompanyId(roomBooking.getCompanyId());
        roomBookingImpl.setGroupId(roomBooking.getGroupId());
        roomBookingImpl.setCreateDate(roomBooking.getCreateDate());
        roomBookingImpl.setModifiedDate(roomBooking.getModifiedDate());
        roomBookingImpl.setUserId(roomBooking.getUserId());
        roomBookingImpl.setUserName(roomBooking.getUserName());
        roomBookingImpl.setRoomId(roomBooking.getRoomId());
        roomBookingImpl.setTitle(roomBooking.getTitle());
        roomBookingImpl.setDescription(roomBooking.getDescription());
        roomBookingImpl.setStartTime(roomBooking.getStartTime());
        roomBookingImpl.setEndTime(roomBooking.getEndTime());
        roomBookingImpl.setAllDay(roomBooking.isAllDay());
        roomBookingImpl.setRecurrence(roomBooking.getRecurrence());
        roomBookingImpl.setFirstReminder(roomBooking.getFirstReminder());
        roomBookingImpl.setFirstReminderType(roomBooking.getFirstReminderType());
        roomBookingImpl.setSecondReminder(roomBooking.getSecondReminder());
        roomBookingImpl.setSecondReminderType(roomBooking.getSecondReminderType());
        roomBookingImpl.setStatus(roomBooking.getStatus());
        roomBookingImpl.setStatusByUserId(roomBooking.getStatusByUserId());
        roomBookingImpl.setStatusByUserName(roomBooking.getStatusByUserName());
        roomBookingImpl.setStatusDate(roomBooking.getStatusDate());

        return roomBookingImpl;
    }

    /**
     * Returns the room booking with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the room booking
     * @return the room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRoomBookingException, SystemException {
        RoomBooking roomBooking = fetchByPrimaryKey(primaryKey);

        if (roomBooking == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRoomBookingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return roomBooking;
    }

    /**
     * Returns the room booking with the primary key or throws a {@link com.glenoir.plugins.NoSuchRoomBookingException} if it could not be found.
     *
     * @param roomBookingId the primary key of the room booking
     * @return the room booking
     * @throws com.glenoir.plugins.NoSuchRoomBookingException if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking findByPrimaryKey(long roomBookingId)
        throws NoSuchRoomBookingException, SystemException {
        return findByPrimaryKey((Serializable) roomBookingId);
    }

    /**
     * Returns the room booking with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the room booking
     * @return the room booking, or <code>null</code> if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        RoomBooking roomBooking = (RoomBooking) EntityCacheUtil.getResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
                RoomBookingImpl.class, primaryKey);

        if (roomBooking == _nullRoomBooking) {
            return null;
        }

        if (roomBooking == null) {
            Session session = null;

            try {
                session = openSession();

                roomBooking = (RoomBooking) session.get(RoomBookingImpl.class,
                        primaryKey);

                if (roomBooking != null) {
                    cacheResult(roomBooking);
                } else {
                    EntityCacheUtil.putResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
                        RoomBookingImpl.class, primaryKey, _nullRoomBooking);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RoomBookingModelImpl.ENTITY_CACHE_ENABLED,
                    RoomBookingImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return roomBooking;
    }

    /**
     * Returns the room booking with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param roomBookingId the primary key of the room booking
     * @return the room booking, or <code>null</code> if a room booking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RoomBooking fetchByPrimaryKey(long roomBookingId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) roomBookingId);
    }

    /**
     * Returns all the room bookings.
     *
     * @return the room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the room bookings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of room bookings
     * @param end the upper bound of the range of room bookings (not inclusive)
     * @return the range of room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the room bookings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.RoomBookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of room bookings
     * @param end the upper bound of the range of room bookings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of room bookings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RoomBooking> findAll(int start, int end,
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

        List<RoomBooking> list = (List<RoomBooking>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ROOMBOOKING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ROOMBOOKING;

                if (pagination) {
                    sql = sql.concat(RoomBookingModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<RoomBooking>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<RoomBooking>(list);
                } else {
                    list = (List<RoomBooking>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the room bookings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (RoomBooking roomBooking : findAll()) {
            remove(roomBooking);
        }
    }

    /**
     * Returns the number of room bookings.
     *
     * @return the number of room bookings
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

                Query q = session.createQuery(_SQL_COUNT_ROOMBOOKING);

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
     * Initializes the room booking persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.glenoir.plugins.model.RoomBooking")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<RoomBooking>> listenersList = new ArrayList<ModelListener<RoomBooking>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<RoomBooking>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RoomBookingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
