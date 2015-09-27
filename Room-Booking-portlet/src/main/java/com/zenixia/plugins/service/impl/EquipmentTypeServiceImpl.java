
package com.zenixia.plugins.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.permissions.BookingPermission;
import com.zenixia.plugins.permissions.EquipmentTypePermission;
import com.zenixia.plugins.service.base.EquipmentTypeServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the equipment type remote service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.zenixia.plugins.service.EquipmentTypeService} interface. <p> This
 * is a remote service. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely. </p>
 * 
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.base.EquipmentTypeServiceBaseImpl
 * @see com.zenixia.plugins.service.EquipmentTypeServiceUtil
 */
public class EquipmentTypeServiceImpl extends EquipmentTypeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.zenixia.plugins.service.EquipmentTypeServiceUtil} to access
	 * the equipment type remote service.
	 */

	public EquipmentType addEquipmentType(EquipmentType equipmentType, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		BookingPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_EQUIPMENT_TYPE");

		return equipmentTypeLocalService.addEquipmentType(equipmentType, serviceContext);
	}

	public EquipmentType updateEquipmentType(EquipmentType equipmentType, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		EquipmentTypePermission.check(getPermissionChecker(), equipmentType.getEquipmentTypeId(), ActionKeys.UPDATE);

		return equipmentTypeLocalService.updateEquipmentType(equipmentType, serviceContext);
	}

	public EquipmentType deleteEquipmentType(long equipmentTypeId)
		throws SystemException, PrincipalException, PortalException {

		EquipmentTypePermission.check(getPermissionChecker(), equipmentTypeId, ActionKeys.DELETE);

		return equipmentTypeLocalService.deleteEquipmentType(equipmentTypeId);
	}

	public EquipmentType getEquipmentType(long equipmentTypeId)
		throws SystemException, PortalException {

		EquipmentTypePermission.check(getPermissionChecker(), equipmentTypeId, ActionKeys.VIEW);
		return equipmentTypeLocalService.getEquipmentType(equipmentTypeId);
	}
	
	public List<EquipmentType> getEquipmentTypeByGroupId(long groupId)
					throws SystemException, PortalException {
		return equipmentTypePersistence.filterFindByGroupId(groupId);
	}
	
	public List<EquipmentType> getEquipmentTypeByGroupId(long groupId, int start, int end)
					throws SystemException, PortalException {
		return equipmentTypePersistence.filterFindByGroupId(groupId, start, end);
	}
	
	public int getEquipmentCountTypeByGroupId(long groupId)
					throws SystemException, PortalException {
		return equipmentTypePersistence.filterCountByGroupId(groupId);
	}
}
