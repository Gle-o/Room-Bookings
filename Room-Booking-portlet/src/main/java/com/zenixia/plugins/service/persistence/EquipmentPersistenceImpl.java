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

import com.zenixia.plugins.NoSuchEquipmentException;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.model.impl.EquipmentImpl;
import com.zenixia.plugins.model.impl.EquipmentModelImpl;
import com.zenixia.plugins.service.persistence.EquipmentPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the equipment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see EquipmentPersistence
 * @see EquipmentUtil
 * @generated
 */
public class EquipmentPersistenceImpl extends BasePersistenceImpl<Equipment>
    implements EquipmentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EquipmentUtil} to access the equipment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EquipmentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            EquipmentModelImpl.UUID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "equipment.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "equipment.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(equipment.uuid IS NULL OR equipment.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            EquipmentModelImpl.UUID_COLUMN_BITMASK |
            EquipmentModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "equipment.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "equipment.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(equipment.uuid IS NULL OR equipment.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "equipment.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            EquipmentModelImpl.UUID_COLUMN_BITMASK |
            EquipmentModelImpl.COMPANYID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "equipment.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "equipment.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(equipment.uuid IS NULL OR equipment.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "equipment.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            EquipmentModelImpl.GROUPID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "equipment.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EQUIPMENTTYPEID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEquipmentTypeId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EQUIPMENTTYPEID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEquipmentTypeId",
            new String[] { Long.class.getName() },
            EquipmentModelImpl.EQUIPMENTTYPEID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EQUIPMENTTYPEID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEquipmentTypeId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_EQUIPMENTTYPEID_EQUIPMENTTYPEID_2 =
        "equipment.equipmentTypeId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoomId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoomId",
            new String[] { Long.class.getName() },
            EquipmentModelImpl.ROOMID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ROOMID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoomId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ROOMID_ROOMID_2 = "equipment.roomId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByGroupIdEquipmentTypeId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByGroupIdEquipmentTypeId",
            new String[] { Long.class.getName(), Long.class.getName() },
            EquipmentModelImpl.GROUPID_COLUMN_BITMASK |
            EquipmentModelImpl.EQUIPMENTTYPEID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByGroupIdEquipmentTypeId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2 = "equipment.groupId = ? AND ";
    private static final String _FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2 =
        "equipment.equipmentTypeId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByGroupIdEquipmentTypeIdRoomId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByGroupIdEquipmentTypeIdRoomId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            EquipmentModelImpl.GROUPID_COLUMN_BITMASK |
            EquipmentModelImpl.EQUIPMENTTYPEID_COLUMN_BITMASK |
            EquipmentModelImpl.ROOMID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEIDROOMID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByGroupIdEquipmentTypeIdRoomId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2 =
        "equipment.groupId = ? AND ";
    private static final String _FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2 =
        "equipment.equipmentTypeId = ? AND ";
    private static final String _FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2 =
        "equipment.roomId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByRoomIdEquipmentTypeId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByRoomIdEquipmentTypeId",
            new String[] { Long.class.getName(), Long.class.getName() },
            EquipmentModelImpl.ROOMID_COLUMN_BITMASK |
            EquipmentModelImpl.EQUIPMENTTYPEID_COLUMN_BITMASK |
            EquipmentModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ROOMIDEQUIPMENTTYPEID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByRoomIdEquipmentTypeId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_ROOMID_2 = "equipment.roomId = ? AND ";
    private static final String _FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2 =
        "equipment.equipmentTypeId = ?";
    private static final String _SQL_SELECT_EQUIPMENT = "SELECT equipment FROM Equipment equipment";
    private static final String _SQL_SELECT_EQUIPMENT_WHERE = "SELECT equipment FROM Equipment equipment WHERE ";
    private static final String _SQL_COUNT_EQUIPMENT = "SELECT COUNT(equipment) FROM Equipment equipment";
    private static final String _SQL_COUNT_EQUIPMENT_WHERE = "SELECT COUNT(equipment) FROM Equipment equipment WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "equipment.equipmentId";
    private static final String _FILTER_SQL_SELECT_EQUIPMENT_WHERE = "SELECT DISTINCT {equipment.*} FROM RoomBooking_Equipment equipment WHERE ";
    private static final String _FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {RoomBooking_Equipment.*} FROM (SELECT DISTINCT equipment.equipmentId FROM RoomBooking_Equipment equipment WHERE ";
    private static final String _FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN RoomBooking_Equipment ON TEMP_TABLE.equipmentId = RoomBooking_Equipment.equipmentId";
    private static final String _FILTER_SQL_COUNT_EQUIPMENT_WHERE = "SELECT COUNT(DISTINCT equipment.equipmentId) AS COUNT_VALUE FROM RoomBooking_Equipment equipment WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "equipment";
    private static final String _FILTER_ENTITY_TABLE = "RoomBooking_Equipment";
    private static final String _ORDER_BY_ENTITY_ALIAS = "equipment.";
    private static final String _ORDER_BY_ENTITY_TABLE = "RoomBooking_Equipment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Equipment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Equipment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EquipmentPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Equipment _nullEquipment = new EquipmentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Equipment> toCacheModel() {
                return _nullEquipmentCacheModel;
            }
        };

    private static CacheModel<Equipment> _nullEquipmentCacheModel = new CacheModel<Equipment>() {
            @Override
            public Equipment toEntityModel() {
                return _nullEquipment;
            }
        };

    public EquipmentPersistenceImpl() {
        setModelClass(Equipment.class);
    }

    /**
     * Returns all the equipments where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByUuid(String uuid, int start, int end,
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

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if (!Validator.equals(uuid, equipment.getUuid())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByUuid_First(uuid, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByUuid_Last(uuid, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where uuid = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByUuid_PrevAndNext(long equipmentId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByUuid_PrevAndNext(session, equipment, uuid,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getByUuid_PrevAndNext(session, equipment, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByUuid_PrevAndNext(Session session,
        Equipment equipment, String uuid, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Equipment equipment : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching equipments
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

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

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
     * Returns the equipment where uuid = &#63; and groupId = &#63; or throws a {@link com.zenixia.plugins.NoSuchEquipmentException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByUUID_G(String uuid, long groupId)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByUUID_G(uuid, groupId);

        if (equipment == null) {
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

            throw new NoSuchEquipmentException(msg.toString());
        }

        return equipment;
    }

    /**
     * Returns the equipment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the equipment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Equipment) {
            Equipment equipment = (Equipment) result;

            if (!Validator.equals(uuid, equipment.getUuid()) ||
                    (groupId != equipment.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

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

                List<Equipment> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Equipment equipment = list.get(0);

                    result = equipment;

                    cacheResult(equipment);

                    if ((equipment.getUuid() == null) ||
                            !equipment.getUuid().equals(uuid) ||
                            (equipment.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, equipment);
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
            return (Equipment) result;
        }
    }

    /**
     * Removes the equipment where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the equipment that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment removeByUUID_G(String uuid, long groupId)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByUUID_G(uuid, groupId);

        return remove(equipment);
    }

    /**
     * Returns the number of equipments where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching equipments
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

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

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
     * Returns all the equipments where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByUuid_C(String uuid, long companyId, int start,
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

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if (!Validator.equals(uuid, equipment.getUuid()) ||
                        (companyId != equipment.getCompanyId())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByUuid_C_PrevAndNext(long equipmentId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, equipment, uuid,
                    companyId, orderByComparator, true);

            array[1] = equipment;

            array[2] = getByUuid_C_PrevAndNext(session, equipment, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByUuid_C_PrevAndNext(Session session,
        Equipment equipment, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Equipment equipment : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching equipments
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

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

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
     * Returns all the equipments where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupId(long groupId, int start, int end,
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

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((groupId != equipment.getGroupId())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByGroupId_First(groupId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByGroupId_Last(groupId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where groupId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByGroupId_PrevAndNext(long equipmentId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, equipment, groupId,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getByGroupId_PrevAndNext(session, equipment, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByGroupId_PrevAndNext(Session session,
        Equipment equipment, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the equipments that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupId(long groupId)
        throws SystemException {
        return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments that the user has permission to view where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupId(long groupId, int start, int end)
        throws SystemException {
        return filterFindByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments that the user has permissions to view where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupId(long groupId, int start,
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
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EquipmentImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            return (List<Equipment>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set of equipments that the user has permission to view where groupId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] filterFindByGroupId_PrevAndNext(long equipmentId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId_PrevAndNext(equipmentId, groupId,
                orderByComparator);
        }

        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = filterGetByGroupId_PrevAndNext(session, equipment,
                    groupId, orderByComparator, true);

            array[1] = equipment;

            array[2] = filterGetByGroupId_PrevAndNext(session, equipment,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment filterGetByGroupId_PrevAndNext(Session session,
        Equipment equipment, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EquipmentImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Equipment equipment : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching equipments
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

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

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
     * Returns the number of equipments that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupId(long groupId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupId(groupId);
        }

        StringBundler query = new StringBundler(2);

        query.append(_FILTER_SQL_COUNT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
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
     * Returns all the equipments where equipmentTypeId = &#63;.
     *
     * @param equipmentTypeId the equipment type ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByEquipmentTypeId(long equipmentTypeId)
        throws SystemException {
        return findByEquipmentTypeId(equipmentTypeId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByEquipmentTypeId(long equipmentTypeId,
        int start, int end) throws SystemException {
        return findByEquipmentTypeId(equipmentTypeId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments where equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByEquipmentTypeId(long equipmentTypeId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EQUIPMENTTYPEID;
            finderArgs = new Object[] { equipmentTypeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EQUIPMENTTYPEID;
            finderArgs = new Object[] {
                    equipmentTypeId,
                    
                    start, end, orderByComparator
                };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((equipmentTypeId != equipment.getEquipmentTypeId())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_EQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(equipmentTypeId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where equipmentTypeId = &#63;.
     *
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByEquipmentTypeId_First(long equipmentTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByEquipmentTypeId_First(equipmentTypeId,
                orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where equipmentTypeId = &#63;.
     *
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByEquipmentTypeId_First(long equipmentTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByEquipmentTypeId(equipmentTypeId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where equipmentTypeId = &#63;.
     *
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByEquipmentTypeId_Last(long equipmentTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByEquipmentTypeId_Last(equipmentTypeId,
                orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where equipmentTypeId = &#63;.
     *
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByEquipmentTypeId_Last(long equipmentTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEquipmentTypeId(equipmentTypeId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByEquipmentTypeId(equipmentTypeId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where equipmentTypeId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByEquipmentTypeId_PrevAndNext(long equipmentId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByEquipmentTypeId_PrevAndNext(session, equipment,
                    equipmentTypeId, orderByComparator, true);

            array[1] = equipment;

            array[2] = getByEquipmentTypeId_PrevAndNext(session, equipment,
                    equipmentTypeId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByEquipmentTypeId_PrevAndNext(Session session,
        Equipment equipment, long equipmentTypeId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_EQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(equipmentTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where equipmentTypeId = &#63; from the database.
     *
     * @param equipmentTypeId the equipment type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEquipmentTypeId(long equipmentTypeId)
        throws SystemException {
        for (Equipment equipment : findByEquipmentTypeId(equipmentTypeId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where equipmentTypeId = &#63;.
     *
     * @param equipmentTypeId the equipment type ID
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEquipmentTypeId(long equipmentTypeId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EQUIPMENTTYPEID;

        Object[] finderArgs = new Object[] { equipmentTypeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_EQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(equipmentTypeId);

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
     * Returns all the equipments where roomId = &#63;.
     *
     * @param roomId the room ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByRoomId(long roomId) throws SystemException {
        return findByRoomId(roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where roomId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param roomId the room ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByRoomId(long roomId, int start, int end)
        throws SystemException {
        return findByRoomId(roomId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments where roomId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param roomId the room ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByRoomId(long roomId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID;
            finderArgs = new Object[] { roomId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMID;
            finderArgs = new Object[] { roomId, start, end, orderByComparator };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((roomId != equipment.getRoomId())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roomId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where roomId = &#63;.
     *
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByRoomId_First(long roomId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByRoomId_First(roomId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("roomId=");
        msg.append(roomId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where roomId = &#63;.
     *
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByRoomId_First(long roomId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByRoomId(roomId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where roomId = &#63;.
     *
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByRoomId_Last(long roomId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByRoomId_Last(roomId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("roomId=");
        msg.append(roomId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where roomId = &#63;.
     *
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByRoomId_Last(long roomId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByRoomId(roomId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByRoomId(roomId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where roomId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByRoomId_PrevAndNext(long equipmentId, long roomId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByRoomId_PrevAndNext(session, equipment, roomId,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getByRoomId_PrevAndNext(session, equipment, roomId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByRoomId_PrevAndNext(Session session,
        Equipment equipment, long roomId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(roomId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where roomId = &#63; from the database.
     *
     * @param roomId the room ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByRoomId(long roomId) throws SystemException {
        for (Equipment equipment : findByRoomId(roomId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where roomId = &#63;.
     *
     * @param roomId the room ID
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRoomId(long roomId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOMID;

        Object[] finderArgs = new Object[] { roomId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roomId);

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
     * Returns all the equipments where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId) throws SystemException {
        return findByGroupIdEquipmentTypeId(groupId, equipmentTypeId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId, int start, int end) throws SystemException {
        return findByGroupIdEquipmentTypeId(groupId, equipmentTypeId, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the equipments where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID;
            finderArgs = new Object[] { groupId, equipmentTypeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID;
            finderArgs = new Object[] {
                    groupId, equipmentTypeId,
                    
                    start, end, orderByComparator
                };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((groupId != equipment.getGroupId()) ||
                        (equipmentTypeId != equipment.getEquipmentTypeId())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(equipmentTypeId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByGroupIdEquipmentTypeId_First(long groupId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByGroupIdEquipmentTypeId_First(groupId,
                equipmentTypeId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByGroupIdEquipmentTypeId_First(long groupId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Equipment> list = findByGroupIdEquipmentTypeId(groupId,
                equipmentTypeId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByGroupIdEquipmentTypeId_Last(long groupId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByGroupIdEquipmentTypeId_Last(groupId,
                equipmentTypeId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByGroupIdEquipmentTypeId_Last(long groupId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByGroupIdEquipmentTypeId(groupId, equipmentTypeId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByGroupIdEquipmentTypeId(groupId,
                equipmentTypeId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByGroupIdEquipmentTypeId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByGroupIdEquipmentTypeId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, orderByComparator, true);

            array[1] = equipment;

            array[2] = getByGroupIdEquipmentTypeId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByGroupIdEquipmentTypeId_PrevAndNext(
        Session session, Equipment equipment, long groupId,
        long equipmentTypeId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(equipmentTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @return the matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId) throws SystemException {
        return filterFindByGroupIdEquipmentTypeId(groupId, equipmentTypeId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId, int start, int end) throws SystemException {
        return filterFindByGroupIdEquipmentTypeId(groupId, equipmentTypeId,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments that the user has permissions to view where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupIdEquipmentTypeId(groupId, equipmentTypeId,
                start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(4 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(4);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EquipmentImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(equipmentTypeId);

            return (List<Equipment>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set of equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] filterFindByGroupIdEquipmentTypeId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupIdEquipmentTypeId_PrevAndNext(equipmentId,
                groupId, equipmentTypeId, orderByComparator);
        }

        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = filterGetByGroupIdEquipmentTypeId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, orderByComparator, true);

            array[1] = equipment;

            array[2] = filterGetByGroupIdEquipmentTypeId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment filterGetByGroupIdEquipmentTypeId_PrevAndNext(
        Session session, Equipment equipment, long groupId,
        long equipmentTypeId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EquipmentImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(equipmentTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where groupId = &#63; and equipmentTypeId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId) throws SystemException {
        for (Equipment equipment : findByGroupIdEquipmentTypeId(groupId,
                equipmentTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupIdEquipmentTypeId(long groupId, long equipmentTypeId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEID;

        Object[] finderArgs = new Object[] { groupId, equipmentTypeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(equipmentTypeId);

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
     * Returns the number of equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @return the number of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
        }

        StringBundler query = new StringBundler(3);

        query.append(_FILTER_SQL_COUNT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(equipmentTypeId);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns all the equipments where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId) throws SystemException {
        return findByGroupIdEquipmentTypeIdRoomId(groupId, equipmentTypeId,
            roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId, int start, int end)
        throws SystemException {
        return findByGroupIdEquipmentTypeIdRoomId(groupId, equipmentTypeId,
            roomId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID;
            finderArgs = new Object[] { groupId, equipmentTypeId, roomId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID;
            finderArgs = new Object[] {
                    groupId, equipmentTypeId, roomId,
                    
                    start, end, orderByComparator
                };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((groupId != equipment.getGroupId()) ||
                        (equipmentTypeId != equipment.getEquipmentTypeId()) ||
                        (roomId != equipment.getRoomId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(equipmentTypeId);

                qPos.add(roomId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByGroupIdEquipmentTypeIdRoomId_First(long groupId,
        long equipmentTypeId, long roomId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByGroupIdEquipmentTypeIdRoomId_First(groupId,
                equipmentTypeId, roomId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(", roomId=");
        msg.append(roomId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByGroupIdEquipmentTypeIdRoomId_First(long groupId,
        long equipmentTypeId, long roomId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Equipment> list = findByGroupIdEquipmentTypeIdRoomId(groupId,
                equipmentTypeId, roomId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByGroupIdEquipmentTypeIdRoomId_Last(long groupId,
        long equipmentTypeId, long roomId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByGroupIdEquipmentTypeIdRoomId_Last(groupId,
                equipmentTypeId, roomId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(", roomId=");
        msg.append(roomId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByGroupIdEquipmentTypeIdRoomId_Last(long groupId,
        long equipmentTypeId, long roomId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByGroupIdEquipmentTypeIdRoomId(groupId,
                equipmentTypeId, roomId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByGroupIdEquipmentTypeIdRoomId(groupId,
                equipmentTypeId, roomId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByGroupIdEquipmentTypeIdRoomId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId, long roomId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByGroupIdEquipmentTypeIdRoomId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, roomId,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getByGroupIdEquipmentTypeIdRoomId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, roomId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByGroupIdEquipmentTypeIdRoomId_PrevAndNext(
        Session session, Equipment equipment, long groupId,
        long equipmentTypeId, long roomId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(equipmentTypeId);

        qPos.add(roomId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @return the matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId)
        throws SystemException {
        return filterFindByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId, int start, int end)
        throws SystemException {
        return filterFindByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId, start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments that the user has permissions to view where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> filterFindByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupIdEquipmentTypeIdRoomId(groupId, equipmentTypeId,
                roomId, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(5 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(5);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EquipmentImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(equipmentTypeId);

            qPos.add(roomId);

            return (List<Equipment>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set of equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] filterFindByGroupIdEquipmentTypeIdRoomId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId, long roomId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupIdEquipmentTypeIdRoomId_PrevAndNext(equipmentId,
                groupId, equipmentTypeId, roomId, orderByComparator);
        }

        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = filterGetByGroupIdEquipmentTypeIdRoomId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, roomId,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = filterGetByGroupIdEquipmentTypeIdRoomId_PrevAndNext(session,
                    equipment, groupId, equipmentTypeId, roomId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment filterGetByGroupIdEquipmentTypeIdRoomId_PrevAndNext(
        Session session, Equipment equipment, long groupId,
        long equipmentTypeId, long roomId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EQUIPMENT_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EquipmentModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EquipmentImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EquipmentImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(equipmentTypeId);

        qPos.add(roomId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId) throws SystemException {
        for (Equipment equipment : findByGroupIdEquipmentTypeIdRoomId(groupId,
                equipmentTypeId, roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEIDROOMID;

        Object[] finderArgs = new Object[] { groupId, equipmentTypeId, roomId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2);

            query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(equipmentTypeId);

                qPos.add(roomId);

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
     * Returns the number of equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63;.
     *
     * @param groupId the group ID
     * @param equipmentTypeId the equipment type ID
     * @param roomId the room ID
     * @return the number of matching equipments that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupIdEquipmentTypeIdRoomId(groupId,
                equipmentTypeId, roomId);
        }

        StringBundler query = new StringBundler(4);

        query.append(_FILTER_SQL_COUNT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_EQUIPMENTTYPEID_2);

        query.append(_FINDER_COLUMN_GROUPIDEQUIPMENTTYPEIDROOMID_ROOMID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Equipment.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(equipmentTypeId);

            qPos.add(roomId);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns all the equipments where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByRoomIdEquipmentTypeId(long roomId,
        long equipmentTypeId) throws SystemException {
        return findByRoomIdEquipmentTypeId(roomId, equipmentTypeId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByRoomIdEquipmentTypeId(long roomId,
        long equipmentTypeId, int start, int end) throws SystemException {
        return findByRoomIdEquipmentTypeId(roomId, equipmentTypeId, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the equipments where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByRoomIdEquipmentTypeId(long roomId,
        long equipmentTypeId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID;
            finderArgs = new Object[] { roomId, equipmentTypeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID;
            finderArgs = new Object[] {
                    roomId, equipmentTypeId,
                    
                    start, end, orderByComparator
                };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((roomId != equipment.getRoomId()) ||
                        (equipmentTypeId != equipment.getEquipmentTypeId())) {
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

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_ROOMID_2);

            query.append(_FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roomId);

                qPos.add(equipmentTypeId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first equipment in the ordered set where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByRoomIdEquipmentTypeId_First(long roomId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByRoomIdEquipmentTypeId_First(roomId,
                equipmentTypeId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("roomId=");
        msg.append(roomId);

        msg.append(", equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByRoomIdEquipmentTypeId_First(long roomId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Equipment> list = findByRoomIdEquipmentTypeId(roomId,
                equipmentTypeId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last equipment in the ordered set where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByRoomIdEquipmentTypeId_Last(long roomId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByRoomIdEquipmentTypeId_Last(roomId,
                equipmentTypeId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("roomId=");
        msg.append(roomId);

        msg.append(", equipmentTypeId=");
        msg.append(equipmentTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByRoomIdEquipmentTypeId_Last(long roomId,
        long equipmentTypeId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByRoomIdEquipmentTypeId(roomId, equipmentTypeId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByRoomIdEquipmentTypeId(roomId,
                equipmentTypeId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the equipments before and after the current equipment in the ordered set where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param equipmentId the primary key of the current equipment
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment[] findByRoomIdEquipmentTypeId_PrevAndNext(
        long equipmentId, long roomId, long equipmentTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByRoomIdEquipmentTypeId_PrevAndNext(session,
                    equipment, roomId, equipmentTypeId, orderByComparator, true);

            array[1] = equipment;

            array[2] = getByRoomIdEquipmentTypeId_PrevAndNext(session,
                    equipment, roomId, equipmentTypeId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByRoomIdEquipmentTypeId_PrevAndNext(
        Session session, Equipment equipment, long roomId,
        long equipmentTypeId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_ROOMID_2);

        query.append(_FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

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
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(roomId);

        qPos.add(equipmentTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where roomId = &#63; and equipmentTypeId = &#63; from the database.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByRoomIdEquipmentTypeId(long roomId, long equipmentTypeId)
        throws SystemException {
        for (Equipment equipment : findByRoomIdEquipmentTypeId(roomId,
                equipmentTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where roomId = &#63; and equipmentTypeId = &#63;.
     *
     * @param roomId the room ID
     * @param equipmentTypeId the equipment type ID
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRoomIdEquipmentTypeId(long roomId, long equipmentTypeId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOMIDEQUIPMENTTYPEID;

        Object[] finderArgs = new Object[] { roomId, equipmentTypeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_ROOMID_2);

            query.append(_FINDER_COLUMN_ROOMIDEQUIPMENTTYPEID_EQUIPMENTTYPEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roomId);

                qPos.add(equipmentTypeId);

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
     * Caches the equipment in the entity cache if it is enabled.
     *
     * @param equipment the equipment
     */
    @Override
    public void cacheResult(Equipment equipment) {
        EntityCacheUtil.putResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentImpl.class, equipment.getPrimaryKey(), equipment);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { equipment.getUuid(), equipment.getGroupId() },
            equipment);

        equipment.resetOriginalValues();
    }

    /**
     * Caches the equipments in the entity cache if it is enabled.
     *
     * @param equipments the equipments
     */
    @Override
    public void cacheResult(List<Equipment> equipments) {
        for (Equipment equipment : equipments) {
            if (EntityCacheUtil.getResult(
                        EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                        EquipmentImpl.class, equipment.getPrimaryKey()) == null) {
                cacheResult(equipment);
            } else {
                equipment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all equipments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EquipmentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EquipmentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the equipment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Equipment equipment) {
        EntityCacheUtil.removeResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentImpl.class, equipment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(equipment);
    }

    @Override
    public void clearCache(List<Equipment> equipments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Equipment equipment : equipments) {
            EntityCacheUtil.removeResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                EquipmentImpl.class, equipment.getPrimaryKey());

            clearUniqueFindersCache(equipment);
        }
    }

    protected void cacheUniqueFindersCache(Equipment equipment) {
        if (equipment.isNew()) {
            Object[] args = new Object[] {
                    equipment.getUuid(), equipment.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                equipment);
        } else {
            EquipmentModelImpl equipmentModelImpl = (EquipmentModelImpl) equipment;

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipment.getUuid(), equipment.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    equipment);
            }
        }
    }

    protected void clearUniqueFindersCache(Equipment equipment) {
        EquipmentModelImpl equipmentModelImpl = (EquipmentModelImpl) equipment;

        Object[] args = new Object[] { equipment.getUuid(), equipment.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((equipmentModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    equipmentModelImpl.getOriginalUuid(),
                    equipmentModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new equipment with the primary key. Does not add the equipment to the database.
     *
     * @param equipmentId the primary key for the new equipment
     * @return the new equipment
     */
    @Override
    public Equipment create(long equipmentId) {
        Equipment equipment = new EquipmentImpl();

        equipment.setNew(true);
        equipment.setPrimaryKey(equipmentId);

        String uuid = PortalUUIDUtil.generate();

        equipment.setUuid(uuid);

        return equipment;
    }

    /**
     * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param equipmentId the primary key of the equipment
     * @return the equipment that was removed
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment remove(long equipmentId)
        throws NoSuchEquipmentException, SystemException {
        return remove((Serializable) equipmentId);
    }

    /**
     * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the equipment
     * @return the equipment that was removed
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment remove(Serializable primaryKey)
        throws NoSuchEquipmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Equipment equipment = (Equipment) session.get(EquipmentImpl.class,
                    primaryKey);

            if (equipment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEquipmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(equipment);
        } catch (NoSuchEquipmentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Equipment removeImpl(Equipment equipment)
        throws SystemException {
        equipment = toUnwrappedModel(equipment);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(equipment)) {
                equipment = (Equipment) session.get(EquipmentImpl.class,
                        equipment.getPrimaryKeyObj());
            }

            if (equipment != null) {
                session.delete(equipment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (equipment != null) {
            clearCache(equipment);
        }

        return equipment;
    }

    @Override
    public Equipment updateImpl(com.zenixia.plugins.model.Equipment equipment)
        throws SystemException {
        equipment = toUnwrappedModel(equipment);

        boolean isNew = equipment.isNew();

        EquipmentModelImpl equipmentModelImpl = (EquipmentModelImpl) equipment;

        if (Validator.isNull(equipment.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            equipment.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (equipment.isNew()) {
                session.save(equipment);

                equipment.setNew(false);
            } else {
                session.merge(equipment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EquipmentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { equipmentModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalUuid(),
                        equipmentModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        equipmentModelImpl.getUuid(),
                        equipmentModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { equipmentModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EQUIPMENTTYPEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalEquipmentTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EQUIPMENTTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EQUIPMENTTYPEID,
                    args);

                args = new Object[] { equipmentModelImpl.getEquipmentTypeId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EQUIPMENTTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EQUIPMENTTYPEID,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalRoomId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID,
                    args);

                args = new Object[] { equipmentModelImpl.getRoomId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMID,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalGroupId(),
                        equipmentModelImpl.getOriginalEquipmentTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID,
                    args);

                args = new Object[] {
                        equipmentModelImpl.getGroupId(),
                        equipmentModelImpl.getEquipmentTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEID,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalGroupId(),
                        equipmentModelImpl.getOriginalEquipmentTypeId(),
                        equipmentModelImpl.getOriginalRoomId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEIDROOMID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID,
                    args);

                args = new Object[] {
                        equipmentModelImpl.getGroupId(),
                        equipmentModelImpl.getEquipmentTypeId(),
                        equipmentModelImpl.getRoomId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDEQUIPMENTTYPEIDROOMID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDEQUIPMENTTYPEIDROOMID,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalRoomId(),
                        equipmentModelImpl.getOriginalEquipmentTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMIDEQUIPMENTTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID,
                    args);

                args = new Object[] {
                        equipmentModelImpl.getRoomId(),
                        equipmentModelImpl.getEquipmentTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOMIDEQUIPMENTTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOMIDEQUIPMENTTYPEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentImpl.class, equipment.getPrimaryKey(), equipment);

        clearUniqueFindersCache(equipment);
        cacheUniqueFindersCache(equipment);

        return equipment;
    }

    protected Equipment toUnwrappedModel(Equipment equipment) {
        if (equipment instanceof EquipmentImpl) {
            return equipment;
        }

        EquipmentImpl equipmentImpl = new EquipmentImpl();

        equipmentImpl.setNew(equipment.isNew());
        equipmentImpl.setPrimaryKey(equipment.getPrimaryKey());

        equipmentImpl.setUuid(equipment.getUuid());
        equipmentImpl.setEquipmentId(equipment.getEquipmentId());
        equipmentImpl.setCompanyId(equipment.getCompanyId());
        equipmentImpl.setGroupId(equipment.getGroupId());
        equipmentImpl.setUserId(equipment.getUserId());
        equipmentImpl.setUserName(equipment.getUserName());
        equipmentImpl.setCreateDate(equipment.getCreateDate());
        equipmentImpl.setModifiedDate(equipment.getModifiedDate());
        equipmentImpl.setName(equipment.getName());
        equipmentImpl.setReference(equipment.getReference());
        equipmentImpl.setEquipmentTypeId(equipment.getEquipmentTypeId());
        equipmentImpl.setRoomId(equipment.getRoomId());

        return equipmentImpl;
    }

    /**
     * Returns the equipment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the equipment
     * @return the equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByPrimaryKey(primaryKey);

        if (equipment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEquipmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return equipment;
    }

    /**
     * Returns the equipment with the primary key or throws a {@link com.zenixia.plugins.NoSuchEquipmentException} if it could not be found.
     *
     * @param equipmentId the primary key of the equipment
     * @return the equipment
     * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByPrimaryKey(long equipmentId)
        throws NoSuchEquipmentException, SystemException {
        return findByPrimaryKey((Serializable) equipmentId);
    }

    /**
     * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the equipment
     * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Equipment equipment = (Equipment) EntityCacheUtil.getResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                EquipmentImpl.class, primaryKey);

        if (equipment == _nullEquipment) {
            return null;
        }

        if (equipment == null) {
            Session session = null;

            try {
                session = openSession();

                equipment = (Equipment) session.get(EquipmentImpl.class,
                        primaryKey);

                if (equipment != null) {
                    cacheResult(equipment);
                } else {
                    EntityCacheUtil.putResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                        EquipmentImpl.class, primaryKey, _nullEquipment);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                    EquipmentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return equipment;
    }

    /**
     * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param equipmentId the primary key of the equipment
     * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByPrimaryKey(long equipmentId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) equipmentId);
    }

    /**
     * Returns all the equipments.
     *
     * @return the equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the equipments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @return the range of equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the equipments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of equipments
     * @param end the upper bound of the range of equipments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findAll(int start, int end,
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

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EQUIPMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EQUIPMENT;

                if (pagination) {
                    sql = sql.concat(EquipmentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
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
     * Removes all the equipments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Equipment equipment : findAll()) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments.
     *
     * @return the number of equipments
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

                Query q = session.createQuery(_SQL_COUNT_EQUIPMENT);

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
     * Initializes the equipment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.zenixia.plugins.model.Equipment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Equipment>> listenersList = new ArrayList<ModelListener<Equipment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Equipment>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EquipmentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
