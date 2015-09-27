
package com.zenixia.plugins.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.service.base.RoomLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the room local service. <p> All custom service methods
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the
 * {@link com.zenixia.plugins.service.RoomLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 * 
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.base.RoomLocalServiceBaseImpl
 * @see com.zenixia.plugins.service.RoomLocalServiceUtil
 */
public class RoomLocalServiceImpl extends RoomLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.zenixia.plugins.service.RoomLocalServiceUtil} to access the
	 * room local service.
	 */
	
	/**
	 * Add room
	 * 
	 * @param room
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Room addRoom(Room room, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long roomId = CounterLocalServiceUtil.increment(Room.class.getName());
		room.setRoomId(roomId);

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		room.setCompanyId(companyId);
		room.setGroupId(groupId);
		room.setRoomId(roomId);
		room.setUserId(userId);

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		room.setUuid(serviceContext.getUuid());
		room.setModifiedDate(now);
		room.setCreateDate(now);
		room.setUserName(user.getFullName());

		// Persistence

		roomPersistence.update(room);
		
		// Update Rooms
		long[] currentEquipementIds = room.getCurrentEquipementIds();
		
		for (long equipmentId : currentEquipementIds) {
			if (Validator.isNotNull(equipmentId)) {
				Equipment equipment = equipmentPersistence.findByPrimaryKey(equipmentId);
				if (Validator.isNull(equipment.getRoomId())) {
					equipment.setRoomId(roomId);
					equipmentLocalService.updateEquipment(equipment);
				}	
			}
		}
		
		// Resources
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {
			resourceLocalService.addResources(companyId, groupId, userId, Room.class.getName(), roomId, false, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			resourceLocalService.addModelResources(companyId, groupId, userId, Room.class.getName(), roomId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		return room;
	}

	/**
	 * Update room
	 * 
	 * @param room
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 * @throws PortalException
	 */
	public Room updateRoom(Room room, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		long roomId = room.getRoomId();

		room.setCompanyId(companyId);
		room.setGroupId(groupId);
		room.setUserId(userId);

		// Set modified Date
		Date now = new Date();
		room.setModifiedDate(now);
		User user = userPersistence.findByPrimaryKey(userId);
		room.setModifiedDate(now);
		room.setUserName(user.getFullName());
		
		// Update Rooms

		List<Equipment> equipments = equipmentLocalService.getEquipmentByRoomId(roomId);
		
		// Remove
		for (Equipment equipment : equipments) {
			equipment.setRoomId(0);
			equipmentLocalService.updateEquipment(equipment);
		}
		
		long[] currentEquipementIds = room.getCurrentEquipementIds();
		
		// Update
		for (long equipmentId : currentEquipementIds) {
			if (Validator.isNotNull(equipmentId)) {
				Equipment equipment = equipmentLocalService.getEquipment(equipmentId);
				if (Validator.isNull(equipment.getRoomId())) {
					equipment.setRoomId(roomId);
					equipmentLocalService.updateEquipment(equipment);
				}
			}
		}
		
		return super.updateRoom(room);
	}

	/**
	 * Delete room
	 * 
	 * @param roomId
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 * @throws PortalException
	 */
	public Room deleteRoom(long roomId)
		throws SystemException, PrincipalException, PortalException {

		List<Equipment> equipments = equipmentPersistence.findByRoomId(roomId);
		Room room = roomPersistence.findByPrimaryKey(roomId);

		for (Equipment equipment : equipments) {
			equipment.setRoomId(0);
			equipmentLocalService.updateEquipment(equipment);
		}
		
		// Resources
		resourceLocalService.deleteResource(room.getCompanyId(), Room.class.getName(), ResourceConstants.SCOPE_COMPANY, room.getPrimaryKey());

		return super.deleteRoom(roomId);
	}
}
