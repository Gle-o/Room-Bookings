package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EquipmentTypeLocalService}.
 *
 * @author Guillaume Lenoir
 * @see EquipmentTypeLocalService
 * @generated
 */
public class EquipmentTypeLocalServiceWrapper
    implements EquipmentTypeLocalService,
        ServiceWrapper<EquipmentTypeLocalService> {
    private EquipmentTypeLocalService _equipmentTypeLocalService;

    public EquipmentTypeLocalServiceWrapper(
        EquipmentTypeLocalService equipmentTypeLocalService) {
        _equipmentTypeLocalService = equipmentTypeLocalService;
    }

    /**
    * Adds the equipment type to the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentType the equipment type
    * @return the equipment type that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType addEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.addEquipmentType(equipmentType);
    }

    /**
    * Creates a new equipment type with the primary key. Does not add the equipment type to the database.
    *
    * @param equipmentTypeId the primary key for the new equipment type
    * @return the new equipment type
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType createEquipmentType(
        long equipmentTypeId) {
        return _equipmentTypeLocalService.createEquipmentType(equipmentTypeId);
    }

    /**
    * Deletes the equipment type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type that was removed
    * @throws PortalException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.liferay.portal.security.auth.PrincipalException
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType deleteEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentTypeLocalService.deleteEquipmentType(equipmentTypeId);
    }

    /**
    * Deletes the equipment type from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentType the equipment type
    * @return the equipment type that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType deleteEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.deleteEquipmentType(equipmentType);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _equipmentTypeLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.zenixia.plugins.model.EquipmentType fetchEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.fetchEquipmentType(equipmentTypeId);
    }

    /**
    * Returns the equipment type with the matching UUID and company.
    *
    * @param uuid the equipment type's UUID
    * @param companyId the primary key of the company
    * @return the matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType fetchEquipmentTypeByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.fetchEquipmentTypeByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the equipment type matching the UUID and group.
    *
    * @param uuid the equipment type's UUID
    * @param groupId the primary key of the group
    * @return the matching equipment type, or <code>null</code> if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType fetchEquipmentTypeByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.fetchEquipmentTypeByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the equipment type with the primary key.
    *
    * @param equipmentTypeId the primary key of the equipment type
    * @return the equipment type
    * @throws PortalException if a equipment type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType getEquipmentType(
        long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.getEquipmentType(equipmentTypeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the equipment type with the matching UUID and company.
    *
    * @param uuid the equipment type's UUID
    * @param companyId the primary key of the company
    * @return the matching equipment type
    * @throws PortalException if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType getEquipmentTypeByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.getEquipmentTypeByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the equipment type matching the UUID and group.
    *
    * @param uuid the equipment type's UUID
    * @param groupId the primary key of the group
    * @return the matching equipment type
    * @throws PortalException if a matching equipment type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType getEquipmentTypeByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.getEquipmentTypeByUuidAndGroupId(uuid,
            groupId);
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
    public java.util.List<com.zenixia.plugins.model.EquipmentType> getEquipmentTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.getEquipmentTypes(start, end);
    }

    /**
    * Returns the number of equipment types.
    *
    * @return the number of equipment types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getEquipmentTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.getEquipmentTypesCount();
    }

    /**
    * Updates the equipment type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param equipmentType the equipment type
    * @return the equipment type that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType updateEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.updateEquipmentType(equipmentType);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _equipmentTypeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _equipmentTypeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _equipmentTypeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Add equipement type
    *
    * @param equipmentType
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType addEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentTypeLocalService.addEquipmentType(equipmentType,
            serviceContext);
    }

    /**
    * Update equipment type
    *
    * @param equipmentType
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PrincipalException
    * @throws PortalException
    */
    @Override
    public com.zenixia.plugins.model.EquipmentType updateEquipmentType(
        com.zenixia.plugins.model.EquipmentType equipmentType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentTypeLocalService.updateEquipmentType(equipmentType,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EquipmentTypeLocalService getWrappedEquipmentTypeLocalService() {
        return _equipmentTypeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEquipmentTypeLocalService(
        EquipmentTypeLocalService equipmentTypeLocalService) {
        _equipmentTypeLocalService = equipmentTypeLocalService;
    }

    @Override
    public EquipmentTypeLocalService getWrappedService() {
        return _equipmentTypeLocalService;
    }

    @Override
    public void setWrappedService(
        EquipmentTypeLocalService equipmentTypeLocalService) {
        _equipmentTypeLocalService = equipmentTypeLocalService;
    }
}
