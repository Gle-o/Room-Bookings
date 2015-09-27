
package com.zenixia.plugins.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.zenixia.plugins.constants.PortletKeys;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.service.RoomLocalServiceUtil;

public class RoomPermission {

	public static void check(PermissionChecker permissionChecker, Room room, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, room, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long roomId, String actionId)
		throws PortalException, SystemException {

		Room room = RoomLocalServiceUtil.getRoom(roomId);

		check(permissionChecker, room, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Room room, String actionId) {

		Boolean hasPermission =
			StagingPermissionUtil.hasPermission(
				permissionChecker, room.getGroupId(), Room.class.getName(), room.getRoomId(), PortletKeys.ROOM_PORTLETID, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(room.getGroupId(), Room.class.getName(), room.getRoomId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long roomId, String actionId)
		throws PortalException, SystemException {

		Room room = RoomLocalServiceUtil.getRoom(roomId);

		return contains(permissionChecker, room, actionId);
	}
}
