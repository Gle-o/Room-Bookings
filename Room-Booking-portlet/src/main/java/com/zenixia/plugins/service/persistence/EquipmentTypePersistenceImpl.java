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

import com.zenixia.plugins.NoSuchEquipmentTypeException;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.model.impl.EquipmentTypeImpl;
import com.zenixia.plugins.model.impl.EquipmentTypeModelImpl;
import com.zenixia.plugins.service.persistence.EquipmentTypePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the equipment type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see EquipmentTypePersistence
 * @see EquipmentTypeUtil
 * @generated
 */
public class EquipmentTypePersistenceImpl extends BasePersistenceImpl<EquipmentType>
    implements EquipmentTypePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EquipmentTypeUtil} to access the equipment type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EquipmentTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUuid", new String[] { String.class.getName() },
            EquipmentTypeModelImpl.UUID_COLUMN_BITMASK |
            EquipmentTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "equipmentType.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "equipmentType.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(equipmentType.uuid IS NULL OR equipmentType.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            EquipmentTypeModelImpl.UUID_COLUMN_BITMASK |
            EquipmentTypeModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "equipmentType.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "equipmentType.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(equipmentType.uuid IS NULL OR equipmentType.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "equipmentType.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            EquipmentTypeModelImpl.UUID_COLUMN_BITMASK |
            EquipmentTypeModelImpl.COMPANYID_COLUMN_BITMASK |
            EquipmentTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "equipmentType.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "equipmentType.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(equipmentType.uuid IS NULL OR equipmentType.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "equipmentType.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED,
            EquipmentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByGroupId", new String[] { Long.class.getName() },
            EquipmentTypeModelImpl.GROUPID_COLUMN_BITMASK |
            EquipmentTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "equipmentType.groupId = ?";
    private static final String _SQL_SELECT_EQUIPMENTTYPE = "SELECT equipmentType FROM EquipmentType equipmentType";
    private static final String _SQL_SELECT_EQUIPMENTTYPE_WHERE = "SELECT equipmentType FROM EquipmentType equipmentType WHERE ";
    private static final String _SQL_COUNT_EQUIPMENTTYPE = "SELECT COUNT(equipmentType) FROM EquipmentType equipmentType";
    private static final String _SQL_COUNT_EQUIPMENTTYPE_WHERE = "SELECT COUNT(equipmentType) FROM EquipmentType equipmentType WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "equipmentType.equipmentTypeId";
    private static final String _FILTER_SQL_SELECT_EQUIPMENTTYPE_WHERE = "SELECT DISTINCT {equipmentType.*} FROM RoomBooking_EquipmentType equipmentType WHERE ";
    private static final String _FILTER_SQL_SELECT_EQUIPMENTTYPE_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {RoomBooking_EquipmentType.*} FROM (SELECT DISTINCT equipmentType.equipmentTypeId FROM RoomBooking_EquipmentType equipmentType WHERE ";
    private static final String _FILTER_SQL_SELECT_EQUIPMENTTYPE_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN RoomBooking_EquipmentType ON TEMP_TABLE.equipmentTypeId = RoomBooking_EquipmentType.equipmentTypeId";
    private static final String _FILTER_SQL_COUNT_EQUIPMENTTYPE_WHERE = "SELECT COUNT(DISTINCT equipmentType.equipmentTypeId) AS COUNT_VALUE FROM RoomBooking_EquipmentType equipmentType WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "equipmentType";
    private static final String _FILTER_ENTITY_TABLE = "RoomBooking_EquipmentType";
    private static final String _ORDER_BY_ENTITY_ALIAS = "equipmentType.";
    private static final String _ORDER_BY_ENTITY_TABLE = "RoomBooking_EquipmentType.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EquipmentType exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EquipmentType exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EquipmentTypePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static EquipmentType _nullEquipmentType = new EquipmentTypeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<EquipmentType> toCacheModel() {
                return _nullEquipmentTypeCacheModel;
            }
        };

    private static CacheModel<EquipmentType> _nullEquipmentTypeCacheModel = new CacheModel<EquipmentType>() {
            @Override
            public EquipmentType toEntityModel() {
                return _nullEquipmentType;
            }
        };

    public EquipmentTypePersistenceImpl() {
        setModelClass(EquipmentType.class);
    }

    /**
     * Returns all the equipment types where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByUuid(String uuid)
        throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipment types where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @return the range of matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipment types where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByUuid(String uuid, int start, int end,
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

        List<EquipmentType> list = (List<EquipmentType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EquipmentType equipmentType : list) {
                if (!Validator.equals(uuid, equipmentType.getUuid())) {
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

            query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

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
                query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
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
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EquipmentType>(list);
                } else {
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first equipment type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByUuid_First(uuid, orderByComparator);

        if (equipmentType != null) {
            return equipmentType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentTypeException(msg.toString());
    }

    /**
     * Returns the first equipment type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<EquipmentType> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByUuid_Last(uuid, orderByComparator);

        if (equipmentType != null) {
            return equipmentType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentTypeException(msg.toString());
    }

    /**
     * Returns the last equipment type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<EquipmentType> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipment types before and after the current equipment type in the ordered set where uuid = &#63;.
     *
     * @param equipmentTypeId the primary key of the current equipment type
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType[] findByUuid_PrevAndNext(long equipmentTypeId,
        String uuid, OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = findByPrimaryKey(equipmentTypeId);

        Session session = null;

        try {
            session = openSession();

            EquipmentType[] array = new EquipmentTypeImpl[3];

            array[0] = getByUuid_PrevAndNext(session, equipmentType, uuid,
                    orderByComparator, true);

            array[1] = equipmentType;

            array[2] = getByUuid_PrevAndNext(session, equipmentType, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EquipmentType getByUuid_PrevAndNext(Session session,
        EquipmentType equipmentType, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

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
            query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(equipmentType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EquipmentType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipment types where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (EquipmentType equipmentType : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipmentType);
        }
    }

    /**
     * Returns the number of equipment types where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching equipment types
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

            query.append(_SQL_COUNT_EQUIPMENTTYPE_WHERE);

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
     * Returns the equipment type where uuid = &#63; and groupId = &#63; or throws a {@link com.zenixia.plugins.NoSuchEquipmentTypeException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByUUID_G(String uuid, long groupId)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByUUID_G(uuid, groupId);

        if (equipmentType == null) {
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

            throw new NoSuchEquipmentTypeException(msg.toString());
        }

        return equipmentType;
    }

    /**
     * Returns the equipment type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the equipment type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof EquipmentType) {
            EquipmentType equipmentType = (EquipmentType) result;

            if (!Validator.equals(uuid, equipmentType.getUuid()) ||
                    (groupId != equipmentType.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

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

                List<EquipmentType> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    EquipmentType equipmentType = list.get(0);

                    result = equipmentType;

                    cacheResult(equipmentType);

                    if ((equipmentType.getUuid() == null) ||
                            !equipmentType.getUuid().equals(uuid) ||
                            (equipmentType.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, equipmentType);
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
            return (EquipmentType) result;
        }
    }

    /**
     * Removes the equipment type where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the equipment type that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType removeByUUID_G(String uuid, long groupId)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = findByUUID_G(uuid, groupId);

        return remove(equipmentType);
    }

    /**
     * Returns the number of equipment types where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching equipment types
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

            query.append(_SQL_COUNT_EQUIPMENTTYPE_WHERE);

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
     * Returns all the equipment types where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipment types where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @return the range of matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipment types where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByUuid_C(String uuid, long companyId,
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

        List<EquipmentType> list = (List<EquipmentType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EquipmentType equipmentType : list) {
                if (!Validator.equals(uuid, equipmentType.getUuid()) ||
                        (companyId != equipmentType.getCompanyId())) {
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

            query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

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
                query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
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
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EquipmentType>(list);
                } else {
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (equipmentType != null) {
            return equipmentType;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentTypeException(msg.toString());
    }

    /**
     * Returns the first equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<EquipmentType> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (equipmentType != null) {
            return equipmentType;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentTypeException(msg.toString());
    }

    /**
     * Returns the last equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<EquipmentType> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipment types before and after the current equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param equipmentTypeId the primary key of the current equipment type
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType[] findByUuid_C_PrevAndNext(long equipmentTypeId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = findByPrimaryKey(equipmentTypeId);

        Session session = null;

        try {
            session = openSession();

            EquipmentType[] array = new EquipmentTypeImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, equipmentType, uuid,
                    companyId, orderByComparator, true);

            array[1] = equipmentType;

            array[2] = getByUuid_C_PrevAndNext(session, equipmentType, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EquipmentType getByUuid_C_PrevAndNext(Session session,
        EquipmentType equipmentType, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

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
            query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(equipmentType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EquipmentType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipment types where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (EquipmentType equipmentType : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipmentType);
        }
    }

    /**
     * Returns the number of equipment types where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching equipment types
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

            query.append(_SQL_COUNT_EQUIPMENTTYPE_WHERE);

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
     * Returns all the equipment types where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipment types where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @return the range of matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipment types where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findByGroupId(long groupId, int start, int end,
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

        List<EquipmentType> list = (List<EquipmentType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EquipmentType equipmentType : list) {
                if ((groupId != equipmentType.getGroupId())) {
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

            query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EquipmentType>(list);
                } else {
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first equipment type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByGroupId_First(groupId,
                orderByComparator);

        if (equipmentType != null) {
            return equipmentType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentTypeException(msg.toString());
    }

    /**
     * Returns the first equipment type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<EquipmentType> list = findByGroupId(groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (equipmentType != null) {
            return equipmentType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentTypeException(msg.toString());
    }

    /**
     * Returns the last equipment type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<EquipmentType> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipment types before and after the current equipment type in the ordered set where groupId = &#63;.
     *
     * @param equipmentTypeId the primary key of the current equipment type
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType[] findByGroupId_PrevAndNext(long equipmentTypeId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = findByPrimaryKey(equipmentTypeId);

        Session session = null;

        try {
            session = openSession();

            EquipmentType[] array = new EquipmentTypeImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, equipmentType,
                    groupId, orderByComparator, true);

            array[1] = equipmentType;

            array[2] = getByGroupId_PrevAndNext(session, equipmentType,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EquipmentType getByGroupId_PrevAndNext(Session session,
        EquipmentType equipmentType, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENTTYPE_WHERE);

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
            query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipmentType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EquipmentType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the equipment types that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching equipment types that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> filterFindByGroupId(long groupId)
        throws SystemException {
        return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipment types that the user has permission to view where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @return the range of matching equipment types that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> filterFindByGroupId(long groupId, int start,
        int end) throws SystemException {
        return filterFindByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipment types that the user has permissions to view where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipment types that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> filterFindByGroupId(long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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
            query.append(_FILTER_SQL_SELECT_EQUIPMENTTYPE_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENTTYPE_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENTTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentTypeModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                EquipmentType.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentTypeImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EquipmentTypeImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            return (List<EquipmentType>) QueryUtil.list(q, getDialect(), start,
                end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns the equipment types before and after the current equipment type in the ordered set of equipment types that the user has permission to view where groupId = &#63;.
     *
     * @param equipmentTypeId the primary key of the current equipment type
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType[] filterFindByGroupId_PrevAndNext(
        long equipmentTypeId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentTypeException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId_PrevAndNext(equipmentTypeId, groupId,
                orderByComparator);
        }

        EquipmentType equipmentType = findByPrimaryKey(equipmentTypeId);

        Session session = null;

        try {
            session = openSession();

            EquipmentType[] array = new EquipmentTypeImpl[3];

            array[0] = filterGetByGroupId_PrevAndNext(session, equipmentType,
                    groupId, orderByComparator, true);

            array[1] = equipmentType;

            array[2] = filterGetByGroupId_PrevAndNext(session, equipmentType,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EquipmentType filterGetByGroupId_PrevAndNext(Session session,
        EquipmentType equipmentType, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENTTYPE_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENTTYPE_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENTTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentTypeModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentTypeModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                EquipmentType.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentTypeImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EquipmentTypeImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipmentType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EquipmentType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipment types where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (EquipmentType equipmentType : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipmentType);
        }
    }

    /**
     * Returns the number of equipment types where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching equipment types
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

            query.append(_SQL_COUNT_EQUIPMENTTYPE_WHERE);

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
     * Returns the number of equipment types that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching equipment types that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupId(long groupId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupId(groupId);
        }

        StringBundler query = new StringBundler(2);

        query.append(_FILTER_SQL_COUNT_EQUIPMENTTYPE_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                EquipmentType.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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
     * Caches the equipment type in the entity cache if it is enabled.
     *
     * @param equipmentType the equipment type
     */
    @Override
    public void cacheResult(EquipmentType equipmentType) {
        EntityCacheUtil.putResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeImpl.class, equipmentType.getPrimaryKey(),
            equipmentType);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { equipmentType.getUuid(), equipmentType.getGroupId() },
            equipmentType);

        equipmentType.resetOriginalValues();
    }

    /**
     * Caches the equipment types in the entity cache if it is enabled.
     *
     * @param equipmentTypes the equipment types
     */
    @Override
    public void cacheResult(List<EquipmentType> equipmentTypes) {
        for (EquipmentType equipmentType : equipmentTypes) {
            if (EntityCacheUtil.getResult(
                        EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
                        EquipmentTypeImpl.class, equipmentType.getPrimaryKey()) == null) {
                cacheResult(equipmentType);
            } else {
                equipmentType.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all equipment types.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EquipmentTypeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EquipmentTypeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the equipment type.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(EquipmentType equipmentType) {
        EntityCacheUtil.removeResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeImpl.class, equipmentType.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(equipmentType);
    }

    @Override
    public void clearCache(List<EquipmentType> equipmentTypes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (EquipmentType equipmentType : equipmentTypes) {
            EntityCacheUtil.removeResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
                EquipmentTypeImpl.class, equipmentType.getPrimaryKey());

            clearUniqueFindersCache(equipmentType);
        }
    }

    protected void cacheUniqueFindersCache(EquipmentType equipmentType) {
        if (equipmentType.isNew()) {
            Object[] args = new Object[] {
                    equipmentType.getUuid(), equipmentType.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                equipmentType);
        } else {
            EquipmentTypeModelImpl equipmentTypeModelImpl = (EquipmentTypeModelImpl) equipmentType;

            if ((equipmentTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentType.getUuid(), equipmentType.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    equipmentType);
            }
        }
    }

    protected void clearUniqueFindersCache(EquipmentType equipmentType) {
        EquipmentTypeModelImpl equipmentTypeModelImpl = (EquipmentTypeModelImpl) equipmentType;

        Object[] args = new Object[] {
                equipmentType.getUuid(), equipmentType.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((equipmentTypeModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    equipmentTypeModelImpl.getOriginalUuid(),
                    equipmentTypeModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new equipment type with the primary key. Does not add the equipment type to the database.
     *
     * @param equipmentTypeId the primary key for the new equipment type
     * @return the new equipment type
     */
    @Override
    public EquipmentType create(long equipmentTypeId) {
        EquipmentType equipmentType = new EquipmentTypeImpl();

        equipmentType.setNew(true);
        equipmentType.setPrimaryKey(equipmentTypeId);

        String uuid = PortalUUIDUtil.generate();

        equipmentType.setUuid(uuid);

        return equipmentType;
    }

    /**
     * Removes the equipment type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param equipmentTypeId the primary key of the equipment type
     * @return the equipment type that was removed
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType remove(long equipmentTypeId)
        throws NoSuchEquipmentTypeException, SystemException {
        return remove((Serializable) equipmentTypeId);
    }

    /**
     * Removes the equipment type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the equipment type
     * @return the equipment type that was removed
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType remove(Serializable primaryKey)
        throws NoSuchEquipmentTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            EquipmentType equipmentType = (EquipmentType) session.get(EquipmentTypeImpl.class,
                    primaryKey);

            if (equipmentType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEquipmentTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(equipmentType);
        } catch (NoSuchEquipmentTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected EquipmentType removeImpl(EquipmentType equipmentType)
        throws SystemException {
        equipmentType = toUnwrappedModel(equipmentType);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(equipmentType)) {
                equipmentType = (EquipmentType) session.get(EquipmentTypeImpl.class,
                        equipmentType.getPrimaryKeyObj());
            }

            if (equipmentType != null) {
                session.delete(equipmentType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (equipmentType != null) {
            clearCache(equipmentType);
        }

        return equipmentType;
    }

    @Override
    public EquipmentType updateImpl(
        com.zenixia.plugins.model.EquipmentType equipmentType)
        throws SystemException {
        equipmentType = toUnwrappedModel(equipmentType);

        boolean isNew = equipmentType.isNew();

        EquipmentTypeModelImpl equipmentTypeModelImpl = (EquipmentTypeModelImpl) equipmentType;

        if (Validator.isNull(equipmentType.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            equipmentType.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (equipmentType.isNew()) {
                session.save(equipmentType);

                equipmentType.setNew(false);
            } else {
                session.merge(equipmentType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EquipmentTypeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((equipmentTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentTypeModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { equipmentTypeModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((equipmentTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentTypeModelImpl.getOriginalUuid(),
                        equipmentTypeModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        equipmentTypeModelImpl.getUuid(),
                        equipmentTypeModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((equipmentTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentTypeModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { equipmentTypeModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentTypeImpl.class, equipmentType.getPrimaryKey(),
            equipmentType);

        clearUniqueFindersCache(equipmentType);
        cacheUniqueFindersCache(equipmentType);

        return equipmentType;
    }

    protected EquipmentType toUnwrappedModel(EquipmentType equipmentType) {
        if (equipmentType instanceof EquipmentTypeImpl) {
            return equipmentType;
        }

        EquipmentTypeImpl equipmentTypeImpl = new EquipmentTypeImpl();

        equipmentTypeImpl.setNew(equipmentType.isNew());
        equipmentTypeImpl.setPrimaryKey(equipmentType.getPrimaryKey());

        equipmentTypeImpl.setUuid(equipmentType.getUuid());
        equipmentTypeImpl.setEquipmentTypeId(equipmentType.getEquipmentTypeId());
        equipmentTypeImpl.setCompanyId(equipmentType.getCompanyId());
        equipmentTypeImpl.setGroupId(equipmentType.getGroupId());
        equipmentTypeImpl.setUserId(equipmentType.getUserId());
        equipmentTypeImpl.setUserName(equipmentType.getUserName());
        equipmentTypeImpl.setCreateDate(equipmentType.getCreateDate());
        equipmentTypeImpl.setModifiedDate(equipmentType.getModifiedDate());
        equipmentTypeImpl.setName(equipmentType.getName());

        return equipmentTypeImpl;
    }

    /**
     * Returns the equipment type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the equipment type
     * @return the equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEquipmentTypeException, SystemException {
        EquipmentType equipmentType = fetchByPrimaryKey(primaryKey);

        if (equipmentType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEquipmentTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return equipmentType;
    }

    /**
     * Returns the equipment type with the primary key or throws a {@link com.zenixia.plugins.NoSuchEquipmentTypeException} if it could not be found.
     *
     * @param equipmentTypeId the primary key of the equipment type
     * @return the equipment type
     * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType findByPrimaryKey(long equipmentTypeId)
        throws NoSuchEquipmentTypeException, SystemException {
        return findByPrimaryKey((Serializable) equipmentTypeId);
    }

    /**
     * Returns the equipment type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the equipment type
     * @return the equipment type, or <code>null</code> if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        EquipmentType equipmentType = (EquipmentType) EntityCacheUtil.getResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
                EquipmentTypeImpl.class, primaryKey);

        if (equipmentType == _nullEquipmentType) {
            return null;
        }

        if (equipmentType == null) {
            Session session = null;

            try {
                session = openSession();

                equipmentType = (EquipmentType) session.get(EquipmentTypeImpl.class,
                        primaryKey);

                if (equipmentType != null) {
                    cacheResult(equipmentType);
                } else {
                    EntityCacheUtil.putResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
                        EquipmentTypeImpl.class, primaryKey, _nullEquipmentType);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EquipmentTypeModelImpl.ENTITY_CACHE_ENABLED,
                    EquipmentTypeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return equipmentType;
    }

    /**
     * Returns the equipment type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param equipmentTypeId the primary key of the equipment type
     * @return the equipment type, or <code>null</code> if a equipment type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EquipmentType fetchByPrimaryKey(long equipmentTypeId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) equipmentTypeId);
    }

    /**
     * Returns all the equipment types.
     *
     * @return the equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipment types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @return the range of equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the equipment types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of equipment types
     * @param end the upper bound of the range of equipment types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of equipment types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EquipmentType> findAll(int start, int end,
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

        List<EquipmentType> list = (List<EquipmentType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EQUIPMENTTYPE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EQUIPMENTTYPE;

                if (pagination) {
                    sql = sql.concat(EquipmentTypeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EquipmentType>(list);
                } else {
                    list = (List<EquipmentType>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the equipment types from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (EquipmentType equipmentType : findAll()) {
            remove(equipmentType);
        }
    }

    /**
     * Returns the number of equipment types.
     *
     * @return the number of equipment types
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

                Query q = session.createQuery(_SQL_COUNT_EQUIPMENTTYPE);

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
     * Initializes the equipment type persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.zenixia.plugins.model.EquipmentType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<EquipmentType>> listenersList = new ArrayList<ModelListener<EquipmentType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<EquipmentType>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EquipmentTypeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
