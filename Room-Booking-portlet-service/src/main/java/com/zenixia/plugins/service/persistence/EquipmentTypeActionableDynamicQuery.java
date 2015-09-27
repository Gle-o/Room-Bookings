package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil;

/**
 * @author Guillaume Lenoir
 * @generated
 */
public abstract class EquipmentTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EquipmentTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EquipmentTypeLocalServiceUtil.getService());
        setClass(EquipmentType.class);

        setClassLoader(com.zenixia.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("equipmentTypeId");
    }
}
