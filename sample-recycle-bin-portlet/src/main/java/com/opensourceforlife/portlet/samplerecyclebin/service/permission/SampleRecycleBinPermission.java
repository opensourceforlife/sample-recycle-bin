
package com.opensourceforlife.portlet.samplerecyclebin.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Opensourceforlife
 */
public class SampleRecycleBinPermission {

	public static void check(
		final PermissionChecker permissionChecker, final long groupId,
		final String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		final PermissionChecker permissionChecker, final long groupId,
		final String actionId) {

		return permissionChecker.hasPermission(
			groupId, _CLASS_NAME, groupId, actionId);
	}

	private static final String _CLASS_NAME =
		"com.opensourceforlife.portlet.samplerecyclebin";

}
