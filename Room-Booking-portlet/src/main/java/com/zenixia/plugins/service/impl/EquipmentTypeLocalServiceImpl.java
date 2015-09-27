
package com.zenixia.plugins.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.service.base.EquipmentTypeLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the equipment type local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.zenixia.plugins.service.EquipmentTypeLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 * 
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.base.EquipmentTypeLocalServiceBaseImpl
 * @see com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil
 */
public class EquipmentTypeLocalServiceImpl extends EquipmentTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil} to
	 * access the equipment type local service.
	 */

	/**
	 * Add equipement type
	 * 
	 * @param equipmentType
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public EquipmentType addEquipmentType(EquipmentType equipmentType, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long equipmentTypeId = CounterLocalServiceUtil.increment(EquipmentType.class.getName());
		equipmentType.setEquipmentTypeId(equipmentTypeId);

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		equipmentType.setCompanyId(companyId);
		equipmentType.setGroupId(groupId);
		equipmentType.setEquipmentTypeId(equipmentTypeId);
		equipmentType.setUserId(userId);

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		equipmentType.setUuid(serviceContext.getUuid());
		equipmentType.setModifiedDate(now);
		equipmentType.setCreateDate(now);
		equipmentType.setUserName(user.getFullName());

		// Persistence

		equipmentTypePersistence.update(equipmentType);

		// Resources
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			resourceLocalService.addResources(
				companyId, groupId, userId, EquipmentType.class.getName(), equipmentTypeId, false, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			resourceLocalService.addModelResources(
				companyId, groupId, userId, EquipmentType.class.getName(), equipmentTypeId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		return equipmentType;
	}

	/**
	 * Update equipment type
	 * 
	 * @param equipmentType
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 * @throws PortalException
	 */
	public EquipmentType updateEquipmentType(EquipmentType equipmentType, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		equipmentType.setCompanyId(companyId);
		equipmentType.setGroupId(groupId);
		equipmentType.setUserId(userId);
		
		// Set modified Date
		Date now = new Date();
		equipmentType.setModifiedDate(now);
		User user = userPersistence.findByPrimaryKey(userId);
		equipmentType.setModifiedDate(now);
		equipmentType.setUserName(user.getFullName());
		
		return super.updateEquipmentType(equipmentType);
	}

	/**
	 * Delete equipment type
	 * 
	 * @param equipmentTypeId
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 * @throws PortalException
	 */
	public EquipmentType deleteEquipmentType(long equipmentTypeId)
		throws SystemException, PrincipalException, PortalException {

		EquipmentType equipmentType = equipmentTypePersistence.findByPrimaryKey(equipmentTypeId);
		
		int total = equipmentLocalService.getEquipmentCountByEquipmentTypeId(equipmentTypeId);

		if (total == 0) {
			// Resources
			resourceLocalService.deleteResource(equipmentType.getCompanyId(), EquipmentType.class.getName(), ResourceConstants.SCOPE_COMPANY, equipmentType.getPrimaryKey());
			equipmentType = super.deleteEquipmentType(equipmentTypeId);
		}
		else {
			throw new SystemException("Impossible to delete equipment type " + equipmentType + "total " + total);
		}

		return equipmentType;
	}
}
