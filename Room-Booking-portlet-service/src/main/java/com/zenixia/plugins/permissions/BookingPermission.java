package com.zenixia.plugins.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.zenixia.plugins.constants.PortletKeys;

/**
 * @author guillaumelenoir
 *
 */
public class BookingPermission {

	/**
	 * Resource name
	 */
	public static final String RESOURCE_NAME = "com.zenixia.plugins.model";

	/**
	 * Check
	 * 
	 * @param permissionChecker
	 * @param groupId
	 * @param actionId
	 * @throws PortalException
	 */
	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	/**
	 * Contains
	 * 
	 * @param permissionChecker
	 * @param groupId
	 * @param actionId
	 * @return
	 */
	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, groupId, RESOURCE_NAME, groupId,
			PortletKeys.ROOM_BOOKING_PORTLETID, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(
			groupId, RESOURCE_NAME, groupId, actionId);
	}
}
