package com.glenoir.plugins.service.messaging;

import com.glenoir.plugins.service.ClpSerializer;
import com.glenoir.plugins.service.EquipmentLocalServiceUtil;
import com.glenoir.plugins.service.EquipmentServiceUtil;
import com.glenoir.plugins.service.EquipmentTypeLocalServiceUtil;
import com.glenoir.plugins.service.EquipmentTypeServiceUtil;
import com.glenoir.plugins.service.RoomBookingLocalServiceUtil;
import com.glenoir.plugins.service.RoomBookingServiceUtil;
import com.glenoir.plugins.service.RoomLocalServiceUtil;
import com.glenoir.plugins.service.RoomServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            EquipmentLocalServiceUtil.clearService();

            EquipmentServiceUtil.clearService();
            EquipmentTypeLocalServiceUtil.clearService();

            EquipmentTypeServiceUtil.clearService();
            RoomLocalServiceUtil.clearService();

            RoomServiceUtil.clearService();
            RoomBookingLocalServiceUtil.clearService();

            RoomBookingServiceUtil.clearService();
        }
    }
}
