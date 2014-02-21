package com.opensourceforlife.portlet.samplerecyclebin.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;

/**
 * @author Opensourceforlife
 * @generated
 */
public abstract class EventActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EventActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EventLocalServiceUtil.getService());
        setClass(Event.class);

        setClassLoader(com.opensourceforlife.portlet.samplerecyclebin.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("eventId");
    }
}
