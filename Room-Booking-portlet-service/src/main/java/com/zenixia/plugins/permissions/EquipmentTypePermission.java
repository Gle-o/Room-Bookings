
package com.zenixia.plugins.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.zenixia.plugins.constants.PortletKeys;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil;

public class EquipmentTypePermission {

	public static void check(PermissionChecker permissionChecker, EquipmentType equipmentType, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, equipmentType, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long equipmentTypeId, String actionId)
		throws PortalException, SystemException {

		EquipmentType equipmentType = EquipmentTypeLocalServiceUtil.getEquipmentType(equipmentTypeId);

		check(permissionChecker, equipmentType, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, EquipmentType equipmentType, String actionId)
		throws PortalException, SystemException {

		Boolean hasPermission =
			StagingPermissionUtil.hasPermission(
				permissionChecker, equipmentType.getGroupId(), EquipmentType.class.getName(), equipmentType.getEquipmentTypeId(), PortletKeys.EQUIPMENT_TYPE_PORTLETID, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(equipmentType.getGroupId(), EquipmentType.class.getName(), equipmentType.getEquipmentTypeId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long equipmentTypeId, String actionId)
		throws PortalException, SystemException {

		EquipmentType equipmentType = EquipmentTypeLocalServiceUtil.getEquipmentType(equipmentTypeId);

		return contains(permissionChecker, equipmentType, actionId);
	}
}
