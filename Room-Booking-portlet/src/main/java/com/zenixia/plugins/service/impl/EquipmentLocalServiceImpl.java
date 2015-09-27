package com.zenixia.plugins.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.service.base.EquipmentLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the equipment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.zenixia.plugins.service.EquipmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.base.EquipmentLocalServiceBaseImpl
 * @see com.zenixia.plugins.service.EquipmentLocalServiceUtil
 */
public class EquipmentLocalServiceImpl extends EquipmentLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.zenixia.plugins.service.EquipmentLocalServiceUtil} to access the equipment local service.
     */
	
	/**
	 * Add equipement
	 * 
	 * @param equipment
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Equipment addEquipment(Equipment equipment, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long equipmentId = CounterLocalServiceUtil.increment(Equipment.class.getName());
		equipment.setEquipmentId(equipmentId);

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		equipment.setCompanyId(companyId);
		equipment.setGroupId(groupId);
		equipment.setEquipmentId(equipmentId);
		equipment.setUserId(userId);

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		equipment.setUuid(serviceContext.getUuid());
		equipment.setModifiedDate(now);
		equipment.setCreateDate(now);
		equipment.setUserName(user.getFullName());

		// Persistence

		equipmentPersistence.update(equipment);

		// Resources
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			resourceLocalService.addResources(
				companyId, groupId, userId, Equipment.class.getName(), equipmentId, false, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			resourceLocalService.addModelResources(
				companyId, groupId, userId, Equipment.class.getName(), equipmentId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		return equipment;
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
	public Equipment updateEquipment(Equipment equipment, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		equipment.setCompanyId(companyId);
		equipment.setGroupId(groupId);
		equipment.setUserId(userId);
		
		// Set modified Date
		Date now = new Date();
		equipment.setModifiedDate(now);
		User user = userPersistence.findByPrimaryKey(userId);
		equipment.setModifiedDate(now);
		equipment.setUserName(user.getFullName());
		
		return super.updateEquipment(equipment);
	}

	/**
	 * Delete equipment type
	 * 
	 * @param equipmentId
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 * @throws PortalException
	 */
	public Equipment deleteEquipment(long equipmentId)
		throws SystemException, PrincipalException, PortalException {

		Equipment equipment = equipmentPersistence.findByPrimaryKey(equipmentId);
		
		// Resources
		resourceLocalService.deleteResource(equipment.getCompanyId(), Equipment.class.getName(), ResourceConstants.SCOPE_COMPANY, equipment.getPrimaryKey());
		
		return super.deleteEquipment(equipmentId);
	}
	
	/**
	 * Get equipment count by equipment typeId
	 * 
	 * @param equipmentTypeIds
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public int getEquipmentCountByEquipmentTypeId(long equipmentTypeId)
		throws SystemException, PortalException {

		return equipmentPersistence.countByEquipmentTypeId(equipmentTypeId);
	}
	
	
	/**
	 * Get Equipment By RoomId RoomId
	 * 
	 * @param equipmentTypeId
	 * @param roomId
	 * @return
	 * @throws SystemException
	 */
	public List<Equipment> getEquipmentByEquipmentTypeIdRoomId(long equipmentTypeId, long roomId) throws SystemException {
		
		return  equipmentPersistence.findByRoomIdEquipmentTypeId(roomId, equipmentTypeId);
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
	public List<Equipment> getAvailableEquipmentByGroupIdEquipementTypeId(long groupId, long equipmentTypeId)
		throws SystemException, PortalException {
		
//		DynamicQuery dynamicQuery = equipmentLocalService.dynamicQuery();
//		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)))
//					.add(PropertyFactoryUtil.forName("equipmentTypeId").eq(new Long(equipmentTypeId)))
//					.add(PropertyFactoryUtil.forName("roomId").eq(new Long(0)));
//		
//		return equipmentLocalService.dynamicQuery(dynamicQuery);
		return equipmentPersistence.findByGroupIdEquipmentTypeIdRoomId(groupId, equipmentTypeId, 0);
	}
	
	/**
	 * Get equipment by roomId
	 * 
	 * @param roomId
	 * @return
	 * @throws SystemException 
	 */
	public List<Equipment> getEquipmentByRoomId(long roomId) throws SystemException {
		
		return equipmentPersistence.findByRoomId(roomId);
	}
	
}
