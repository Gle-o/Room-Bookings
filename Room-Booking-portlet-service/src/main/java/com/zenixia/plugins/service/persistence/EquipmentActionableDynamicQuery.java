package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.service.EquipmentLocalServiceUtil;

/**
 * @author Guillaume Lenoir
 * @generated
 */
public abstract class EquipmentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EquipmentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EquipmentLocalServiceUtil.getService());
        setClass(Equipment.class);

        setClassLoader(com.zenixia.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("equipmentId");
    }
}
