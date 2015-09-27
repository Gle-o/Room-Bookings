package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.service.RoomLocalServiceUtil;

/**
 * @author Guillaume Lenoir
 * @generated
 */
public abstract class RoomActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RoomActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RoomLocalServiceUtil.getService());
        setClass(Room.class);

        setClassLoader(com.zenixia.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("roomId");
    }
}
