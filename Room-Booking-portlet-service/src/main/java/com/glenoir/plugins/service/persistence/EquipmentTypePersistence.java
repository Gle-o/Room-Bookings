package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.model.EquipmentType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the equipment type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaume Lenoir
 * @see EquipmentTypePersistenceImpl
 * @see EquipmentTypeUtil
 * @generated
 */
public interface EquipmentTypePersistence extends BasePersistence<EquipmentType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EquipmentTypeUtil} to access the equipment type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the equipment types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the equipment types where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of equipment types
    * @param end the upper bound of the range of equipment types (not inclusive)
    * @return the range of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the equipment types where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of equipment types
    * @param end the upper bound of the range of equipment types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipment types before and after the current equipment type in the ordered set where uuid = &#63;.
    *
    * @param equipmentTypeId the primary key of the current equipment type
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType[] findByUuid_PrevAndNext(
        long equipmentTypeId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the equipment types where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of equipment types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the equipment types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the equipment types where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of equipment types
    * @param end the upper bound of the range of equipment types (not inclusive)
    * @return the range of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the equipment types where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipment types before and after the current equipment type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param equipmentTypeId the primary key of the current equipment type
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType[] findByUuid_C_PrevAndNext(
        long equipmentTypeId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the equipment types where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of equipment types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching equipment types
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the equipment type in the entity cache if it is enabled.
    *
    * @param equipmentType the equipment type
    */
    public void cacheResult(
        com.glenoir.plugins.model.EquipmentType equipmentType);

    /**
    * Caches the equipment types in the entity cache if it is enabled.
    *
    * @param equipmentTypes the equipment types
    */
    public void cacheResult(
        java.util.List<com.glenoir.plugins.model.EquipmentType> equipmentTypes);

    /**
    * Creates a new equipment type with the primary key. Does not add the equipment type to the database.
    *
    * @param equipmentTypeId the primary key for the new equipment type
    * @return the new equipment type
    */
    public com.glenoir.plugins.model.EquipmentType create(long equipmentTypeId);

    /**
    * Removes the equipment type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type that was removed
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType remove(long equipmentTypeId)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.glenoir.plugins.model.EquipmentType updateImpl(
        com.glenoir.plugins.model.EquipmentType equipmentType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipment type with the primary key or throws a {@link com.glenoir.plugins.NoSuchEquipmentTypeException} if it could not be found.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type
    * @throws com.glenoir.plugins.NoSuchEquipmentTypeException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType findByPrimaryKey(
        long equipmentTypeId)
        throws com.glenoir.plugins.NoSuchEquipmentTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the equipment type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type, or <code>null</code> if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.glenoir.plugins.model.EquipmentType fetchByPrimaryKey(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the equipment types.
    *
    * @return the equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the equipment types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of equipment types
    * @param end the upper bound of the range of equipment types (not inclusive)
    * @return the range of equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the equipment types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.glenoir.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of equipment types
    * @param end the upper bound of the range of equipment types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of equipment types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.glenoir.plugins.model.EquipmentType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the equipment types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of equipment types.
    *
    * @return the number of equipment types
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
