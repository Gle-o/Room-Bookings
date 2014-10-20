package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.model.Equipment;
import com.glenoir.plugins.service.EquipmentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author guillaume Lenoir
 * @generated
 */
public abstract class EquipmentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EquipmentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EquipmentLocalServiceUtil.getService());
        setClass(Equipment.class);

        setClassLoader(com.glenoir.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("equipmentId");
    }
}
