package com.glenoir.plugins.service.persistence;

import com.glenoir.plugins.model.RoomBooking;
import com.glenoir.plugins.service.RoomBookingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author guillaume Lenoir
 * @generated
 */
public abstract class RoomBookingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RoomBookingActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RoomBookingLocalServiceUtil.getService());
        setClass(RoomBooking.class);

        setClassLoader(com.glenoir.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("roomBookingId");
    }
}
