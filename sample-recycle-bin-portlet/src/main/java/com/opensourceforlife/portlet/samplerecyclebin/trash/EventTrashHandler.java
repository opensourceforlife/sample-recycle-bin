/**
 * 
 */

package com.opensourceforlife.portlet.samplerecyclebin.trash;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.security.permission.PermissionChecker;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;

/**
 * @author Opensourceforlife
 */
public class EventTrashHandler extends BaseTrashHandler {

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashHandler#deleteTrashEntry(long)
	 */
	@Override
	public void deleteTrashEntry(final long classPK)
		throws PortalException, SystemException {

		EventLocalServiceUtil.deleteEvent(classPK);
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashHandler#getClassName()
	 */
	@Override
	public String getClassName() {

		return Event.class.getName();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashHandler#isInTrash(long)
	 */
	@Override
	public boolean isInTrash(final long classPK)
		throws PortalException, SystemException {

		Event event = EventLocalServiceUtil.getEvent(classPK);
		return event.isInTrash();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashHandler#restoreTrashEntry(long,
	 * long)
	 */
	@Override
	public void restoreTrashEntry(final long userId, final long classPK)
		throws PortalException, SystemException {

		EventLocalServiceUtil.restoreEntryFromTrash(userId, classPK);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portal.kernel.trash.BaseTrashHandler#hasPermission(com.liferay
	 * .portal.security.permission.PermissionChecker, long, java.lang.String)
	 */
	@Override
	protected boolean hasPermission(
		final PermissionChecker permissionChecker, final long classPK,
		final String actionId)
		throws PortalException, SystemException {

		return true;
	}

}
