package com.zenixia.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.zenixia.plugins.model.RoomBooking;
import com.zenixia.plugins.service.RoomBookingLocalServiceUtil;

/**
 * @author Guillaume Lenoir
 * @generated
 */
public abstract class RoomBookingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RoomBookingActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RoomBookingLocalServiceUtil.getService());
        setClass(RoomBooking.class);

        setClassLoader(com.zenixia.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("roomBookingId");
    }
}
