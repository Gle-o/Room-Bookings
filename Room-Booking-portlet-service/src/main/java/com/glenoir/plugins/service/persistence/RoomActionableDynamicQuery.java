package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.model.Room;
import com.glenoir.plugins.service.RoomLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author guillaume Lenoir
 * @generated
 */
public abstract class RoomActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RoomActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RoomLocalServiceUtil.getService());
        setClass(Room.class);

        setClassLoader(com.glenoir.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("roomId");
    }
}
