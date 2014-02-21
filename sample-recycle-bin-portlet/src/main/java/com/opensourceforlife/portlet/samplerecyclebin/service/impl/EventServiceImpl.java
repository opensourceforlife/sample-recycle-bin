
package com.opensourceforlife.portlet.samplerecyclebin.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;
import com.opensourceforlife.portlet.samplerecyclebin.service.base.EventServiceBaseImpl;
import com.opensourceforlife.portlet.samplerecyclebin.service.permission.EventPermission;
import com.opensourceforlife.portlet.samplerecyclebin.service.permission.SampleRecycleBinPermission;
import com.opensourceforlife.portlet.samplerecyclebin.util.SampleRecycleBinActionKeys;

/**
 * The implementation of the event remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.opensourceforlife.portlet.samplerecyclebin.service.EventService}
 * interface. <p> This is a remote service. Methods of this service are expected
 * to have security checks based on the propagated JAAS credentials because this
 * service can be accessed remotely. </p>
 * 
 * @author Opensourceforlife
 * @see com.opensourceforlife.portlet.samplerecyclebin.service.base.EventServiceBaseImpl
 * @see com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil
 */
public class EventServiceImpl extends EventServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil}
	 * to access the event remote service.
	 */

	@Override
	public Event addEvent(
		final long groupId, final String name, final String description,
		final int month, final int day, final int year, final int hour,
		final int minute, final ServiceContext serviceContext)
		throws PortalException, SystemException {

		SampleRecycleBinPermission.check(
			getPermissionChecker(), groupId,
			SampleRecycleBinActionKeys.ADD_EVENT);

		return EventLocalServiceUtil.addEvent(
			getUserId(), groupId, name, description, month, day, year, hour,
			minute, serviceContext);
	}

	@Override
	public Event deleteEvent(final long eventId)
		throws PortalException, SystemException {

		EventPermission.check(
			getPermissionChecker(), eventId,
			SampleRecycleBinActionKeys.DELETE_EVENT);

		return eventLocalService.deleteEvent(eventId);
	}

	@Override
	public Event getEvent(final long eventId)
		throws PortalException, SystemException {

		EventPermission.check(
			getPermissionChecker(), eventId, SampleRecycleBinActionKeys.VIEW);

		return EventLocalServiceUtil.getEvent(eventId);
	}

	@Override
	public Event updateEvent(
		final long userId, final long eventId, final String name,
		final String description, final int month, final int day,
		final int year, final int hour, final int minute,
		final ServiceContext serviceContext)
		throws PortalException, SystemException {

		EventPermission.check(
			getPermissionChecker(), eventId,
			SampleRecycleBinActionKeys.UPDATE_EVENT);

		return EventLocalServiceUtil.updateEvent(
			userId, eventId, name, description, month, day, year, hour, minute,
			serviceContext);
	}
}
