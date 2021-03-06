package com.zenixia.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EquipmentLocalService}.
 *
 * @author Guillaume Lenoir
 * @see EquipmentLocalService
 * @generated
 */
public class EquipmentLocalServiceWrapper implements EquipmentLocalService,
    ServiceWrapper<EquipmentLocalService> {
    private EquipmentLocalService _equipmentLocalService;

    public EquipmentLocalServiceWrapper(
        EquipmentLocalService equipmentLocalService) {
        _equipmentLocalService = equipmentLocalService;
    }

    /**
    * Adds the equipment to the database. Also notifies the appropriate model listeners.
    *
    * @param equipment the equipment
    * @return the equipment that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment addEquipment(
        com.zenixia.plugins.model.Equipment equipment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.addEquipment(equipment);
    }

    /**
    * Creates a new equipment with the primary key. Does not add the equipment to the database.
    *
    * @param equipmentId the primary key for the new equipment
    * @return the new equipment
    */
    @Override
    public com.zenixia.plugins.model.Equipment createEquipment(long equipmentId) {
        return _equipmentLocalService.createEquipment(equipmentId);
    }

    /**
    * Deletes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment that was removed
    * @throws PortalException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.liferay.portal.security.auth.PrincipalException
    */
    @Override
    public com.zenixia.plugins.model.Equipment deleteEquipment(long equipmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentLocalService.deleteEquipment(equipmentId);
    }

    /**
    * Deletes the equipment from the database. Also notifies the appropriate model listeners.
    *
    * @param equipment the equipment
    * @return the equipment that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment deleteEquipment(
        com.zenixia.plugins.model.Equipment equipment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.deleteEquipment(equipment);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _equipmentLocalService.dynamicQuery();
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
        return _equipmentLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _equipmentLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _equipmentLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _equipmentLocalService.dynamicQueryCount(dynamicQuery);
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
        return _equipmentLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.zenixia.plugins.model.Equipment fetchEquipment(long equipmentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.fetchEquipment(equipmentId);
    }

    /**
    * Returns the equipment with the matching UUID and company.
    *
    * @param uuid the equipment's UUID
    * @param companyId the primary key of the company
    * @return the matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment fetchEquipmentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.fetchEquipmentByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the equipment matching the UUID and group.
    *
    * @param uuid the equipment's UUID
    * @param groupId the primary key of the group
    * @return the matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment fetchEquipmentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.fetchEquipmentByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the equipment with the primary key.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment
    * @throws PortalException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment getEquipment(long equipmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipment(equipmentId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the equipment with the matching UUID and company.
    *
    * @param uuid the equipment's UUID
    * @param companyId the primary key of the company
    * @return the matching equipment
    * @throws PortalException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment getEquipmentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipmentByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the equipment matching the UUID and group.
    *
    * @param uuid the equipment's UUID
    * @param groupId the primary key of the group
    * @return the matching equipment
    * @throws PortalException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment getEquipmentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipmentByUuidAndGroupId(uuid, groupId);
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
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipments(start, end);
    }

    /**
    * Returns the number of equipments.
    *
    * @return the number of equipments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getEquipmentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipmentsCount();
    }

    /**
    * Updates the equipment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param equipment the equipment
    * @return the equipment that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.model.Equipment updateEquipment(
        com.zenixia.plugins.model.Equipment equipment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.updateEquipment(equipment);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _equipmentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _equipmentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _equipmentLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Add equipement
    *
    * @param equipment
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.zenixia.plugins.model.Equipment addEquipment(
        com.zenixia.plugins.model.Equipment equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.addEquipment(equipment, serviceContext);
    }

    /**
    * Update equipment type
    *
    * @param equipment
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PrincipalException
    * @throws PortalException
    */
    @Override
    public com.zenixia.plugins.model.Equipment updateEquipment(
        com.zenixia.plugins.model.Equipment equipment,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _equipmentLocalService.updateEquipment(equipment, serviceContext);
    }

    /**
    * Get equipment count by equipment typeId
    *
    * @param equipmentTypeIds
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public int getEquipmentCountByEquipmentTypeId(long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipmentCountByEquipmentTypeId(equipmentTypeId);
    }

    /**
    * Get Equipment By RoomId RoomId
    *
    * @param equipmentTypeId
    * @param roomId
    * @return
    * @throws SystemException
    */
    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByEquipmentTypeIdRoomId(
        long equipmentTypeId, long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipmentByEquipmentTypeIdRoomId(equipmentTypeId,
            roomId);
    }

    /**
    * Get available Equipments By GroupId EquipementTypeId
    *
    * @param groupId
    * @param equipmentTypeId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getAvailableEquipmentByGroupIdEquipementTypeId(
        long groupId, long equipmentTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getAvailableEquipmentByGroupIdEquipementTypeId(groupId,
            equipmentTypeId);
    }

    /**
    * Get equipment by roomId
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipmentByRoomId(
        long roomId) throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentLocalService.getEquipmentByRoomId(roomId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EquipmentLocalService getWrappedEquipmentLocalService() {
        return _equipmentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEquipmentLocalService(
        EquipmentLocalService equipmentLocalService) {
        _equipmentLocalService = equipmentLocalService;
    }

    @Override
    public EquipmentLocalService getWrappedService() {
        return _equipmentLocalService;
    }

    @Override
    public void setWrappedService(EquipmentLocalService equipmentLocalService) {
        _equipmentLocalService = equipmentLocalService;
    }
}
