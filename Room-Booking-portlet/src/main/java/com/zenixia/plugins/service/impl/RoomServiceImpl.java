
package com.zenixia.plugins.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.permissions.BookingPermission;
import com.zenixia.plugins.permissions.RoomPermission;
import com.zenixia.plugins.service.base.RoomServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the room remote service. <p> All custom service methods
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the
 * {@link com.zenixia.plugins.service.RoomService} interface. <p> This is a
 * remote service. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be accessed
 * remotely. </p>
 * 
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.base.RoomServiceBaseImpl
 * @see com.zenixia.plugins.service.RoomServiceUtil
 */
public class RoomServiceImpl extends RoomServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.zenixia.plugins.service.RoomServiceUtil} to access the room
	 * remote service.
	 */

	public Room addRoom(Room room, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		BookingPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_ROOM");

		return roomLocalService.addRoom(room, serviceContext);
	}

	public Room updateRoom(Room room, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		RoomPermission.check(getPermissionChecker(), room.getRoomId(), ActionKeys.UPDATE);

		return roomLocalService.updateRoom(room, serviceContext);
	}

	public Room deleteRoom(long roomId)
		throws SystemException, PrincipalException, PortalException {

		RoomPermission.check(getPermissionChecker(), roomId, ActionKeys.DELETE);

		return roomLocalService.deleteRoom(roomId);
	}

	public Room getRoom(long roomId)
		throws SystemException, PortalException {

		RoomPermission.check(getPermissionChecker(), roomId, ActionKeys.VIEW);
		return roomLocalService.getRoom(roomId);
	}

	public List<Room> getRoomByGroupId(long groupId)
		throws SystemException, PortalException {

		return roomPersistence.filterFindByGroupId(groupId);
	}

	public List<Room> getRoomByGroupId(long groupId, int start, int end)
		throws SystemException, PortalException {

		return roomPersistence.filterFindByGroupId(groupId, start, end);
	}

	public int getRoomCountByGroupId(long groupId)
		throws SystemException, PortalException {

		return roomPersistence.filterCountByGroupId(groupId);
	}
}
