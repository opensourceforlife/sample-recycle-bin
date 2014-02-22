
package com.opensourceforlife.portlet.samplerecyclebin.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.trash.model.TrashEntry;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.base.EventLocalServiceBaseImpl;

/**
 * The implementation of the event local service. <p> All custom service methods
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the
 * {@link com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author Opensourceforlife
 * @see com.opensourceforlife.portlet.samplerecyclebin.service.base.EventLocalServiceBaseImpl
 * @see com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil
	 * } to access the event local service.
	 */

	@Override
	public Event addEvent(
		final long userId, final long groupId, final String name,
		final String description, final int month, final int day,
		final int year, final int hour, final int minute,
		final ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long eventId = counterLocalService.increment(Event.class.getName());

		Event event = eventPersistence.create(eventId);

		event.setName(name);
		event.setDescription(description);

		Calendar dateCal = CalendarFactoryUtil.getCalendar(user.getTimeZone());
		dateCal.set(year, month, day, hour, minute);
		Date date = dateCal.getTime();
		event.setDate(date);

		event.setGroupId(groupId);
		event.setCompanyId(user.getCompanyId());
		event.setUserId(user.getUserId());
		event.setCreateDate(serviceContext.getCreateDate(now));
		event.setModifiedDate(serviceContext.getModifiedDate(now));

		super.addEvent(event);

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addEventResources(
				event, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addEventResources(
				event, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		return event;
	}

	@Override
	public void addEventResources(
		final Event event, final boolean addGroupPermissions,
		final boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			event.getCompanyId(), event.getGroupId(), event.getUserId(),
			Event.class.getName(), event.getEventId(), false,
			addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEventResources(
		final Event event, final String[] groupPermissions,
		final String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			event.getCompanyId(), event.getGroupId(), event.getUserId(),
			Event.class.getName(), event.getEventId(), groupPermissions,
			guestPermissions);
	}

	@Override
	public void addEventResources(
		final long eventId, final boolean addGroupPermissions,
		final boolean addGuestPermissions)
		throws PortalException, SystemException {

		Event event = eventPersistence.findByPrimaryKey(eventId);

		addEventResources(event, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEventResources(
		final long eventId, final String[] groupPermissions,
		final String[] guestPermissions)
		throws PortalException, SystemException {

		Event event = eventPersistence.findByPrimaryKey(eventId);

		addEventResources(event, groupPermissions, guestPermissions);
	}

	@Override
	public Event deleteEvent(final Event event)
		throws SystemException {

		// Trash
		try {
			trashEntryLocalService.deleteEntry(
				Event.class.getName(), event.getEventId());
		}
		catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		return eventPersistence.remove(event);
	}

	@Override
	public Event deleteEvent(final long eventId)
		throws PortalException, SystemException {

		Event event = eventPersistence.findByPrimaryKey(eventId);

		return deleteEvent(event);
	}

	@Override
	public Event getEvent(final long eventId)
		throws SystemException, PortalException {

		return eventPersistence.findByPrimaryKey(eventId);
	}

	@Override
	public List<Event> getEventsByGroupId(final long groupId)
		throws SystemException {

		return eventPersistence.findByGroupId(groupId);
	}

	@Override
	public List<Event> getEventsByGroupId(
		final long groupId, final int start, final int end)
		throws SystemException {

		return getEventsByGroupId(
			groupId, WorkflowConstants.STATUS_IN_TRASH, start, end);
	}

	@Override
	public List<Event> getEventsByGroupId(
		final long groupId, final int status, final int start, final int end)
		throws SystemException {

		return eventPersistence.findByG_NotS(groupId, status, start, end);
	}

	@Override
	public int getEventsCountByGroupId(final long groupId)
		throws SystemException {

		return getEventsCountByGroupId(
			groupId, WorkflowConstants.STATUS_IN_TRASH);
	}

	@Override
	public int getEventsCountByGroupId(final long groupId, final int status)
		throws SystemException {

		return eventPersistence.countByG_NotS(groupId, status);
	}

	@Override
	public Event moveEntryToTrash(final long userId, final long eventId)
		throws PortalException, SystemException {

		Event event = eventPersistence.findByPrimaryKey(eventId);

		updateStatus(
			event.getEventId(), WorkflowConstants.STATUS_IN_TRASH, userId);

		return event;
	}

	@Override
	public void restoreEntryFromTrash(final long userId, final long eventId)
		throws PortalException, SystemException {

		// Entry
		TrashEntry trashEntry =
			trashEntryLocalService.getEntry(Event.class.getName(), eventId);

		updateStatus(eventId, trashEntry.getStatus(), userId);

	}

	@Override
	public Event updateEvent(
		final long userId, final long eventId, final String name,
		final String description, final int month, final int day,
		final int year, final int hour, final int minute,
		final ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		Event event = eventPersistence.findByPrimaryKey(eventId);

		event.setModifiedDate(serviceContext.getModifiedDate(now));
		event.setName(name);
		event.setDescription(description);

		Calendar dateCal = CalendarFactoryUtil.getCalendar(user.getTimeZone());
		dateCal.set(year, month, day, hour, minute);
		Date date = dateCal.getTime();
		event.setDate(date);

		eventPersistence.update(event);

		return event;
	}

	@Override
	public Event updateStatus(
		final long eventId, final int status, final long userId)
		throws SystemException, PortalException {

		Event event = eventPersistence.findByPrimaryKey(eventId);
		int oldStatus = event.getStatus();

		event.setStatus(status);
		eventPersistence.update(event);

		// Trash
		if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
			trashEntryLocalService.deleteEntry(Event.class.getName(), eventId);
		}
		else if (status == WorkflowConstants.STATUS_IN_TRASH) {
			trashEntryLocalService.addTrashEntry(
				userId, event.getGroupId(), Event.class.getName(),
				event.getEventId(), event.getUuid(), null, oldStatus, null,
				null);
		}

		return event;
	}

	private static Log _log =
		LogFactoryUtil.getLog(EventLocalServiceImpl.class);
}
