
package com.zenixia.plugins.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.permissions.BookingPermission;
import com.zenixia.plugins.permissions.EquipmentPermission;
import com.zenixia.plugins.service.base.EquipmentServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the equipment remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.zenixia.plugins.service.EquipmentService} interface. <p> This is a
 * remote service. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be accessed
 * remotely. </p>
 * 
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.base.EquipmentServiceBaseImpl
 * @see com.zenixia.plugins.service.EquipmentServiceUtil
 */
public class EquipmentServiceImpl extends EquipmentServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.zenixia.plugins.service.EquipmentServiceUtil} to access the
	 * equipment remote service.
	 */

	public Equipment addEquipment(Equipment equipment, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		BookingPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_EQUIPMENT");

		return equipmentLocalService.addEquipment(equipment, serviceContext);
	}

	public Equipment updateEquipment(Equipment equipment, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		EquipmentPermission.check(getPermissionChecker(), equipment.getEquipmentId(), ActionKeys.UPDATE);

		return equipmentLocalService.updateEquipment(equipment, serviceContext);
	}

	public Equipment deleteEquipment(long equipmentId)
		throws SystemException, PrincipalException, PortalException {

		EquipmentPermission.check(getPermissionChecker(), equipmentId, ActionKeys.DELETE);

		return equipmentLocalService.deleteEquipment(equipmentId);
	}

	public Equipment getEquipment(long equipmentId)
		throws SystemException, PortalException {

		EquipmentPermission.check(getPermissionChecker(), equipmentId, ActionKeys.VIEW);
		return equipmentLocalService.getEquipment(equipmentId);
	}

	public List<Equipment> getEquipmentByGroupId(long groupId)
		throws SystemException, PortalException {

		return equipmentPersistence.filterFindByGroupId(groupId);
	}

	public List<Equipment> getEquipmentByGroupId(long groupId, int start, int end)
		throws SystemException, PortalException {

		return equipmentPersistence.filterFindByGroupId(groupId, start, end);
	}

	public int getEquipmentCountByGroupId(long groupId)
		throws SystemException, PortalException {

		return equipmentPersistence.filterCountByGroupId(groupId);
	}

	public List<Equipment> getEquipmentByGroupIdEquipementTypeId(long groupId, long equipmentTypeId)
		throws SystemException, PortalException {

		return equipmentPersistence.filterFindByGroupIdEquipmentTypeId(groupId, equipmentTypeId);
	}
}
