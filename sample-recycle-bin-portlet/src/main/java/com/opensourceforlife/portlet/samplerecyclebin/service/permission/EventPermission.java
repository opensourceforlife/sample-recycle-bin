
package com.opensourceforlife.portlet.samplerecyclebin.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;

/**
 * @author Opensourceforlife
 */
public class EventPermission {

	public static void check(
		final PermissionChecker permissionChecker, final Event event,
		final String actionId)
		throws PortalException {

		if (!contains(permissionChecker, event, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
		final PermissionChecker permissionChecker, final long eventId,
		final String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, eventId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		final PermissionChecker permissionChecker, final Event event,
		final String actionId) {

		if (permissionChecker.hasOwnerPermission(
			event.getCompanyId(), Event.class.getName(), event.getEventId(),
			event.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			event.getGroupId(), Event.class.getName(), event.getEventId(),
			actionId);
	}

	public static boolean contains(
		final PermissionChecker permissionChecker, final long eventId,
		final String actionId)
		throws PortalException, SystemException {

		Event event = EventLocalServiceUtil.getEvent(eventId);

		return contains(permissionChecker, event, actionId);
	}

}
