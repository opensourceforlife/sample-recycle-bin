
package com.opensourceforlife.portlet.samplerecyclebin;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.trash.util.TrashUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil;

/**
 * @author Opensourceforlife
 */
public class SampleRecycleBinPortlet extends MVCPortlet {

	public void addEvent(
		final ActionRequest request, final ActionResponse response)
		throws Exception {

		_updateEvent(request);

		sendRedirect(request, response);
	}

	public void deleteEvent(
		final ActionRequest request, final ActionResponse response)
		throws Exception {

		long eventId = ParamUtil.getLong(request, "eventId");
		String cmd = ParamUtil.getString(request, Constants.CMD);

		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		if (cmd.equals(Constants.MOVE_TO_TRASH)) {
			Event event =
				EventLocalServiceUtil.moveEntryToTrash(
					themeDisplay.getUserId(), eventId);

			Map<String, String[]> data = new HashMap<String, String[]>();

			data.put("deleteEntryClassName", new String[] {
				Event.class.getName()
			});
			data.put("deleteEntryTitle", new String[] {
				TrashUtil.getOriginalTitle(event.getName())
			});
			data.put("restoreEntryIds", new String[] {
				String.valueOf(eventId)
			});

			SessionMessages.add(request, PortalUtil.getPortletId(request) +
				SessionMessages.KEY_SUFFIX_DELETE_SUCCESS_DATA, data);

			SessionMessages.add(request, PortalUtil.getPortletId(request) +
				SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		}
		else if (cmd.equals(Constants.DELETE)) {
			EventLocalServiceUtil.deleteEvent(eventId);
		}

		sendRedirect(request, response);
	}

	public void updateEvent(
		final ActionRequest request, final ActionResponse response)
		throws Exception {

		_updateEvent(request);

		sendRedirect(request, response);
	}

	private Event _updateEvent(final ActionRequest request)
		throws PortalException, SystemException {

		long eventId = ParamUtil.getLong(request, "eventId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");

		int year = ParamUtil.getInteger(request, "dateYear");
		int month = ParamUtil.getInteger(request, "dateMonth");
		int day = ParamUtil.getInteger(request, "dateDay");
		int hour = ParamUtil.getInteger(request, "dateHour");
		int minute = ParamUtil.getInteger(request, "dateMinute");
		int amPm = ParamUtil.getInteger(request, "dateAmPm");

		if (amPm == Calendar.PM) {
			hour += 12;
		}

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(Event.class.getName(), request);

		Event event = null;

		if (eventId <= 0) {
			event =
				EventServiceUtil.addEvent(
					serviceContext.getScopeGroupId(), name, description, month,
					day, year, hour, minute, serviceContext);
		}
		else {
			event = EventServiceUtil.getEvent(eventId);

			event =
				EventServiceUtil.updateEvent(
					serviceContext.getUserId(), eventId, name, description,
					month, day, year, hour, minute, serviceContext);
		}

		return event;
	}

	public void restoreEvent(
		final ActionRequest request, final ActionResponse response)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long[] restoreEntryIds =
			StringUtil.split(
				ParamUtil.getString(request, "restoreEntryIds"), 0L);

		for (long restoreEntryId : restoreEntryIds) {
			EventLocalServiceUtil.restoreEntryFromTrash(
				themeDisplay.getUserId(), restoreEntryId);
		}
	}

	private static Log _log =
		LogFactoryUtil.getLog(SampleRecycleBinPortlet.class);
}
