package com.zenixia.plugins.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.zenixia.plugins.service.ClpSerializer;
import com.zenixia.plugins.service.EquipmentLocalServiceUtil;
import com.zenixia.plugins.service.EquipmentServiceUtil;
import com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil;
import com.zenixia.plugins.service.EquipmentTypeServiceUtil;
import com.zenixia.plugins.service.RoomBookingLocalServiceUtil;
import com.zenixia.plugins.service.RoomBookingServiceUtil;
import com.zenixia.plugins.service.RoomLocalServiceUtil;
import com.zenixia.plugins.service.RoomServiceUtil;


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
