package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.zenixia.plugins.model.Equipment;

import java.util.List;

/**
 * The persistence utility for the equipment service. This utility wraps {@link EquipmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see EquipmentPersistence
 * @see EquipmentPersistenceImpl
 * @generated
 */
public class EquipmentUtil {
    private static EquipmentPersistence _persistence;

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
    public static void clearCache(Equipment equipment) {
        getPersistence().clearCache(equipment);
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
    public static List<Equipment> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Equipment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Equipment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Equipment update(Equipment equipment)
        throws SystemException {
        return getPersistence().update(equipment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Equipment update(Equipment equipment,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(equipment, serviceContext);
    }

    /**
    * Returns all the equipments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByUuid_PrevAndNext(
        long equipmentId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByUuid_PrevAndNext(equipmentId, uuid, orderByComparator);
    }

    /**
    * Removes all the equipments where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of equipments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
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
    public static com.zenixia.plugins.model.Equipment findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the equipment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
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
    public static com.zenixia.plugins.model.Equipment fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the equipment where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the equipment that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of equipments where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the equipments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByUuid_C_PrevAndNext(
        long equipmentId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(equipmentId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the equipments where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of equipments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the equipments where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByGroupId_PrevAndNext(
        long equipmentId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(equipmentId, groupId,
            orderByComparator);
    }

    /**
    * Returns all the equipments that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching equipments that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupId(groupId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] filterFindByGroupId_PrevAndNext(
        long equipmentId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .filterFindByGroupId_PrevAndNext(equipmentId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the equipments where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of equipments where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of equipments that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching equipments that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByGroupId(groupId);
    }

    /**
    * Returns all the equipments where equipmentTypeId = &#63;.
    *
    * @param equipmentTypeId the equipment type ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByEquipmentTypeId(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEquipmentTypeId(equipmentTypeId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByEquipmentTypeId(
        long equipmentTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEquipmentTypeId(equipmentTypeId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByEquipmentTypeId(
        long equipmentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEquipmentTypeId(equipmentTypeId, start, end,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByEquipmentTypeId_First(
        long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByEquipmentTypeId_First(equipmentTypeId,
            orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where equipmentTypeId = &#63;.
    *
    * @param equipmentTypeId the equipment type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByEquipmentTypeId_First(
        long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEquipmentTypeId_First(equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByEquipmentTypeId_Last(
        long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByEquipmentTypeId_Last(equipmentTypeId,
            orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where equipmentTypeId = &#63;.
    *
    * @param equipmentTypeId the equipment type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByEquipmentTypeId_Last(
        long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEquipmentTypeId_Last(equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByEquipmentTypeId_PrevAndNext(
        long equipmentId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByEquipmentTypeId_PrevAndNext(equipmentId,
            equipmentTypeId, orderByComparator);
    }

    /**
    * Removes all the equipments where equipmentTypeId = &#63; from the database.
    *
    * @param equipmentTypeId the equipment type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEquipmentTypeId(long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEquipmentTypeId(equipmentTypeId);
    }

    /**
    * Returns the number of equipments where equipmentTypeId = &#63;.
    *
    * @param equipmentTypeId the equipment type ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByEquipmentTypeId(long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEquipmentTypeId(equipmentTypeId);
    }

    /**
    * Returns all the equipments where roomId = &#63;.
    *
    * @param roomId the room ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByRoomId(
        long roomId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRoomId(roomId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByRoomId(
        long roomId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRoomId(roomId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByRoomId(
        long roomId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoomId(roomId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByRoomId_First(
        long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByRoomId_First(roomId, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where roomId = &#63;.
    *
    * @param roomId the room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByRoomId_First(
        long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByRoomId_First(roomId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByRoomId_Last(
        long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByRoomId_Last(roomId, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where roomId = &#63;.
    *
    * @param roomId the room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByRoomId_Last(
        long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByRoomId_Last(roomId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByRoomId_PrevAndNext(
        long equipmentId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByRoomId_PrevAndNext(equipmentId, roomId,
            orderByComparator);
    }

    /**
    * Removes all the equipments where roomId = &#63; from the database.
    *
    * @param roomId the room ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByRoomId(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByRoomId(roomId);
    }

    /**
    * Returns the number of equipments where roomId = &#63;.
    *
    * @param roomId the room ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByRoomId(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByRoomId(roomId);
    }

    /**
    * Returns all the equipments where groupId = &#63; and equipmentTypeId = &#63;.
    *
    * @param groupId the group ID
    * @param equipmentTypeId the equipment type ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupIdEquipmentTypeId(
        long groupId, long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupIdEquipmentTypeId(
        long groupId, long equipmentTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeId(groupId, equipmentTypeId,
            start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupIdEquipmentTypeId(
        long groupId, long equipmentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeId(groupId, equipmentTypeId,
            start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByGroupIdEquipmentTypeId_First(
        long groupId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeId_First(groupId,
            equipmentTypeId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByGroupIdEquipmentTypeId_First(
        long groupId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdEquipmentTypeId_First(groupId,
            equipmentTypeId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByGroupIdEquipmentTypeId_Last(
        long groupId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeId_Last(groupId, equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByGroupIdEquipmentTypeId_Last(
        long groupId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdEquipmentTypeId_Last(groupId,
            equipmentTypeId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByGroupIdEquipmentTypeId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeId_PrevAndNext(equipmentId,
            groupId, equipmentTypeId, orderByComparator);
    }

    /**
    * Returns all the equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63;.
    *
    * @param groupId the group ID
    * @param equipmentTypeId the equipment type ID
    * @return the matching equipments that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupIdEquipmentTypeId(
        long groupId, long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupIdEquipmentTypeId(
        long groupId, long equipmentTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeId(groupId,
            equipmentTypeId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupIdEquipmentTypeId(
        long groupId, long equipmentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeId(groupId,
            equipmentTypeId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] filterFindByGroupIdEquipmentTypeId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeId_PrevAndNext(equipmentId,
            groupId, equipmentTypeId, orderByComparator);
    }

    /**
    * Removes all the equipments where groupId = &#63; and equipmentTypeId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param equipmentTypeId the equipment type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
    }

    /**
    * Returns the number of equipments where groupId = &#63; and equipmentTypeId = &#63;.
    *
    * @param groupId the group ID
    * @param equipmentTypeId the equipment type ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
    }

    /**
    * Returns the number of equipments that the user has permission to view where groupId = &#63; and equipmentTypeId = &#63;.
    *
    * @param groupId the group ID
    * @param equipmentTypeId the equipment type ID
    * @return the number of matching equipments that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByGroupIdEquipmentTypeId(long groupId,
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterCountByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByGroupIdEquipmentTypeIdRoomId_First(
        long groupId, long equipmentTypeId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeIdRoomId_First(groupId,
            equipmentTypeId, roomId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByGroupIdEquipmentTypeIdRoomId_First(
        long groupId, long equipmentTypeId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdEquipmentTypeIdRoomId_First(groupId,
            equipmentTypeId, roomId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByGroupIdEquipmentTypeIdRoomId_Last(
        long groupId, long equipmentTypeId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeIdRoomId_Last(groupId,
            equipmentTypeId, roomId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByGroupIdEquipmentTypeIdRoomId_Last(
        long groupId, long equipmentTypeId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdEquipmentTypeIdRoomId_Last(groupId,
            equipmentTypeId, roomId, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByGroupIdEquipmentTypeIdRoomId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByGroupIdEquipmentTypeIdRoomId_PrevAndNext(equipmentId,
            groupId, equipmentTypeId, roomId, orderByComparator);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId, start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> filterFindByGroupIdEquipmentTypeIdRoomId(
        long groupId, long equipmentTypeId, long roomId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId, start, end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] filterFindByGroupIdEquipmentTypeIdRoomId_PrevAndNext(
        long equipmentId, long groupId, long equipmentTypeId, long roomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .filterFindByGroupIdEquipmentTypeIdRoomId_PrevAndNext(equipmentId,
            groupId, equipmentTypeId, roomId, orderByComparator);
    }

    /**
    * Removes all the equipments where groupId = &#63; and equipmentTypeId = &#63; and roomId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param equipmentTypeId the equipment type ID
    * @param roomId the room ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByGroupIdEquipmentTypeIdRoomId(groupId, equipmentTypeId,
            roomId);
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
    public static int countByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId);
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
    public static int filterCountByGroupIdEquipmentTypeIdRoomId(long groupId,
        long equipmentTypeId, long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterCountByGroupIdEquipmentTypeIdRoomId(groupId,
            equipmentTypeId, roomId);
    }

    /**
    * Returns all the equipments where roomId = &#63; and equipmentTypeId = &#63;.
    *
    * @param roomId the room ID
    * @param equipmentTypeId the equipment type ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByRoomIdEquipmentTypeId(
        long roomId, long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoomIdEquipmentTypeId(roomId, equipmentTypeId);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByRoomIdEquipmentTypeId(
        long roomId, long equipmentTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoomIdEquipmentTypeId(roomId, equipmentTypeId, start,
            end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findByRoomIdEquipmentTypeId(
        long roomId, long equipmentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoomIdEquipmentTypeId(roomId, equipmentTypeId, start,
            end, orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByRoomIdEquipmentTypeId_First(
        long roomId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByRoomIdEquipmentTypeId_First(roomId, equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByRoomIdEquipmentTypeId_First(
        long roomId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRoomIdEquipmentTypeId_First(roomId, equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment findByRoomIdEquipmentTypeId_Last(
        long roomId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByRoomIdEquipmentTypeId_Last(roomId, equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment fetchByRoomIdEquipmentTypeId_Last(
        long roomId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRoomIdEquipmentTypeId_Last(roomId, equipmentTypeId,
            orderByComparator);
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
    public static com.zenixia.plugins.model.Equipment[] findByRoomIdEquipmentTypeId_PrevAndNext(
        long equipmentId, long roomId, long equipmentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence()
                   .findByRoomIdEquipmentTypeId_PrevAndNext(equipmentId,
            roomId, equipmentTypeId, orderByComparator);
    }

    /**
    * Removes all the equipments where roomId = &#63; and equipmentTypeId = &#63; from the database.
    *
    * @param roomId the room ID
    * @param equipmentTypeId the equipment type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByRoomIdEquipmentTypeId(long roomId,
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByRoomIdEquipmentTypeId(roomId, equipmentTypeId);
    }

    /**
    * Returns the number of equipments where roomId = &#63; and equipmentTypeId = &#63;.
    *
    * @param roomId the room ID
    * @param equipmentTypeId the equipment type ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByRoomIdEquipmentTypeId(long roomId,
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByRoomIdEquipmentTypeId(roomId, equipmentTypeId);
    }

    /**
    * Caches the equipment in the entity cache if it is enabled.
    *
    * @param equipment the equipment
    */
    public static void cacheResult(
        com.zenixia.plugins.model.Equipment equipment) {
        getPersistence().cacheResult(equipment);
    }

    /**
    * Caches the equipments in the entity cache if it is enabled.
    *
    * @param equipments the equipments
    */
    public static void cacheResult(
        java.util.List<com.zenixia.plugins.model.Equipment> equipments) {
        getPersistence().cacheResult(equipments);
    }

    /**
    * Creates a new equipment with the primary key. Does not add the equipment to the database.
    *
    * @param equipmentId the primary key for the new equipment
    * @return the new equipment
    */
    public static com.zenixia.plugins.model.Equipment create(long equipmentId) {
        return getPersistence().create(equipmentId);
    }

    /**
    * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment that was removed
    * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment remove(long equipmentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().remove(equipmentId);
    }

    public static com.zenixia.plugins.model.Equipment updateImpl(
        com.zenixia.plugins.model.Equipment equipment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(equipment);
    }

    /**
    * Returns the equipment with the primary key or throws a {@link com.zenixia.plugins.NoSuchEquipmentException} if it could not be found.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment
    * @throws com.zenixia.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment findByPrimaryKey(
        long equipmentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.zenixia.plugins.NoSuchEquipmentException {
        return getPersistence().findByPrimaryKey(equipmentId);
    }

    /**
    * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.zenixia.plugins.model.Equipment fetchByPrimaryKey(
        long equipmentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(equipmentId);
    }

    /**
    * Returns all the equipments.
    *
    * @return the equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.zenixia.plugins.model.Equipment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.zenixia.plugins.model.Equipment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the equipments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of equipments.
    *
    * @return the number of equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EquipmentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EquipmentPersistence) PortletBeanLocatorUtil.locate(com.zenixia.plugins.service.ClpSerializer.getServletContextName(),
                    EquipmentPersistence.class.getName());

            ReferenceRegistry.registerReference(EquipmentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EquipmentPersistence persistence) {
    }
}
