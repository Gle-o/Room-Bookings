package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.model.Equipment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the equipment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaume Lenoir
 * @see EquipmentPersistenceImpl
 * @see EquipmentUtil
 * @generated
 */
public interface EquipmentPersistence extends BasePersistence<Equipment> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EquipmentUtil} to access the equipment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the equipments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the equipments where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the equipments where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipments before and after the current equipment in the ordered set where uuid = &#63;.
    *
    * @param equipmentId the primary key of the current equipment
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment[] findByUuid_PrevAndNext(
        long equipmentId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the equipments where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of equipments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the equipments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the equipments where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the equipments where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.glenoir.plugins.model.Equipment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipments before and after the current equipment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param equipmentId the primary key of the current equipment
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment[] findByUuid_C_PrevAndNext(
        long equipmentId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the equipments where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of equipments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the equipment in the entity cache if it is enabled.
    *
    * @param equipment the equipment
    */
    public void cacheResult(com.glenoir.plugins.model.Equipment equipment);

    /**
    * Caches the equipments in the entity cache if it is enabled.
    *
    * @param equipments the equipments
    */
    public void cacheResult(
        java.util.List<com.glenoir.plugins.model.Equipment> equipments);

    /**
    * Creates a new equipment with the primary key. Does not add the equipment to the database.
    *
    * @param equipmentId the primary key for the new equipment
    * @return the new equipment
    */
    public com.glenoir.plugins.model.Equipment create(long equipmentId);

    /**
    * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment that was removed
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment remove(long equipmentId)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.glenoir.plugins.model.Equipment updateImpl(
        com.glenoir.plugins.model.Equipment equipment)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipment with the primary key or throws a {@link com.glenoir.plugins.NoSuchEquipmentException} if it could not be found.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment
    * @throws com.glenoir.plugins.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment findByPrimaryKey(
        long equipmentId)
        throws com.glenoir.plugins.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.Equipment fetchByPrimaryKey(
        long equipmentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the equipments.
    *
    * @return the equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the equipments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the equipments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of equipments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.Equipment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the equipments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of equipments.
    *
    * @return the number of equipments
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
