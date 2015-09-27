package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.zenixia.plugins.model.EquipmentType;

import java.util.List;

/**
 * The persistence utility for the equipment type service. This utility wraps {@link EquipmentTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see EquipmentTypePersistence
 * @see EquipmentTypePersistenceImpl
 * @generated
 */
public class EquipmentTypeUtil {
    private static EquipmentTypePersistence _persistence;

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
    public static void clearCache(EquipmentType equipmentType) {
        getPersistence().clearCache(equipmentType);
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
    public static List<EquipmentType> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<EquipmentType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<EquipmentType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static EquipmentType update(EquipmentType equipmentType)
        throws SystemException {
        return getPersistence().update(equipmentType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static EquipmentType update(EquipmentType equipmentType,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(equipmentType, serviceContext);
    }

    /**
    * Returns all the equipment types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first equipment type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last equipment type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType[] findByUuid_PrevAndNext(
        long equipmentTypeId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence()
                   .findByUuid_PrevAndNext(equipmentTypeId, uuid,
            orderByComparator);
    }

    /**
    * Removes all the equipment types where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of equipment types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
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
    public static com.zenixia.plugins.model.EquipmentType findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the equipment type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
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
    public static com.zenixia.plugins.model.EquipmentType fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the equipment type where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the equipment type that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of equipment types where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the equipment types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType[] findByUuid_C_PrevAndNext(
        long equipmentTypeId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(equipmentTypeId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the equipment types where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of equipment types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the equipment types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first equipment type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last equipment type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType[] findByGroupId_PrevAndNext(
        long equipmentTypeId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(equipmentTypeId, groupId,
            orderByComparator);
    }

    /**
    * Returns all the equipment types that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching equipment types that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupId(groupId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.EquipmentType[] filterFindByGroupId_PrevAndNext(
        long equipmentTypeId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence()
                   .filterFindByGroupId_PrevAndNext(equipmentTypeId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the equipment types where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of equipment types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of equipment types that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching equipment types that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByGroupId(groupId);
    }

    /**
    * Caches the equipment type in the entity cache if it is enabled.
    *
    * @param equipmentType the equipment type
    */
    public static void cacheResult(
        com.zenixia.plugins.model.EquipmentType equipmentType) {
        getPersistence().cacheResult(equipmentType);
    }

    /**
    * Caches the equipment types in the entity cache if it is enabled.
    *
    * @param equipmentTypes the equipment types
    */
    public static void cacheResult(
        java.util.List<com.zenixia.plugins.model.EquipmentType> equipmentTypes) {
        getPersistence().cacheResult(equipmentTypes);
    }

    /**
    * Creates a new equipment type with the primary key. Does not add the equipment type to the database.
    *
    * @param equipmentTypeId the primary key for the new equipment type
    * @return the new equipment type
    */
    public static com.zenixia.plugins.model.EquipmentType create(
        long equipmentTypeId) {
        return getPersistence().create(equipmentTypeId);
    }

    /**
    * Removes the equipment type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type that was removed
    * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType remove(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().remove(equipmentTypeId);
    }

    public static com.zenixia.plugins.model.EquipmentType updateImpl(
        com.zenixia.plugins.model.EquipmentType equipmentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(equipmentType);
    }

    /**
    * Returns the equipment type with the primary key or throws a {@link com.zenixia.plugins.NoSuchEquipmentTypeException} if it could not be found.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type
    * @throws com.zenixia.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType findByPrimaryKey(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentTypeException {
        return getPersistence().findByPrimaryKey(equipmentTypeId);
    }

    /**
    * Returns the equipment type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type, or <code>null</code> if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.EquipmentType fetchByPrimaryKey(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(equipmentTypeId);
    }

    /**
    * Returns all the equipment types.
    *
    * @return the equipment types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.zenixia.plugins.model.EquipmentType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the equipment types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of equipment types.
    *
    * @return the number of equipment types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EquipmentTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EquipmentTypePersistence) PortletBeanLocatorUtil.locate(com.zenixia.plugins.service.ClpSerializer.getServletContextName(),
                    EquipmentTypePersistence.class.getName());

            ReferenceRegistry.registerReference(EquipmentTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EquipmentTypePersistence persistence) {
    }
}
