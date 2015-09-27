
package com.zenixia.plugins.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.zenixia.plugins.constants.PortletKeys;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.service.EquipmentLocalServiceUtil;

public class EquipmentPermission {

	public static void check(PermissionChecker permissionChecker, Equipment equipment, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, equipment, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long equipmentId, String actionId)
		throws PortalException, SystemException {

		Equipment equipment = EquipmentLocalServiceUtil.getEquipment(equipmentId);

		check(permissionChecker, equipment, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Equipment equipment, String actionId)
		throws PortalException, SystemException {

		Boolean hasPermission =
			StagingPermissionUtil.hasPermission(
				permissionChecker, equipment.getGroupId(), Equipment.class.getName(), equipment.getEquipmentId(), PortletKeys.EQUIPMENT_PORTLETID, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(equipment.getGroupId(), Equipment.class.getName(), equipment.getEquipmentId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long equipmentId, String actionId)
		throws PortalException, SystemException {

		Equipment equipment = EquipmentLocalServiceUtil.getEquipment(equipmentId);

		return contains(permissionChecker, equipment, actionId);
	}
}
