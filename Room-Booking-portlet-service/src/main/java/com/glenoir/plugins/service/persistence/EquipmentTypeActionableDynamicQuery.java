package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.model.EquipmentType;
import com.glenoir.plugins.service.EquipmentTypeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author guillaume Lenoir
 * @generated
 */
public abstract class EquipmentTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EquipmentTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EquipmentTypeLocalServiceUtil.getService());
        setClass(EquipmentType.class);

        setClassLoader(com.glenoir.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("equipmentTypeId");
    }
}
