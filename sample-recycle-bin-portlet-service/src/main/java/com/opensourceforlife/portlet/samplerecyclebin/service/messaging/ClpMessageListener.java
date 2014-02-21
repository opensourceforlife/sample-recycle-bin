package com.opensourceforlife.portlet.samplerecyclebin.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.opensourceforlife.portlet.samplerecyclebin.service.ClpSerializer;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil;


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
            EventLocalServiceUtil.clearService();

            EventServiceUtil.clearService();
        }
    }
}
