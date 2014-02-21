/**
 * 
 */

package com.opensourceforlife.portlet.samplerecyclebin.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;

/**
 * @author Opensourceforlife
 */
public class EventAssetRenderer extends BaseAssetRenderer
	implements TrashRenderer {

	/**
	 * @param event
	 */
	public EventAssetRenderer(final Event event) {

		_event = event;
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashRenderer#getClassName()
	 */
	@Override
	public String getClassName() {

		return Event.class.getName();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashRenderer#getClassPK()
	 */
	@Override
	public long getClassPK() {

		return _event.getEventId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getGroupId()
	 */
	@Override
	public long getGroupId() {

		return _event.getGroupId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getUserId()
	 */
	@Override
	public long getUserId() {

		return _event.getUserId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getUserName()
	 */
	@Override
	public String getUserName() {

		String userName = String.valueOf(_event.getUserId());

		try {
			userName =
				UserLocalServiceUtil.getUser(_event.getUserId()).getFullName();
		}
		catch (PortalException e) {
		}
		catch (SystemException e) {
		}
		return userName;
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getUuid()
	 */
	@Override
	public String getUuid() {

		return _event.getUuid();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashRenderer#getPortletId()
	 */
	@Override
	public String getPortletId() {

		AssetRendererFactory assetRendererFactory = getAssetRendererFactory();
		return assetRendererFactory.getPortletId();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portlet.asset.model.AssetRenderer#getSummary(java.util.Locale
	 * )
	 */
	@Override
	public String getSummary(final Locale locale) {

		String summary = _event.getName();

		if (Validator.isNull(summary)) {
			summary =
				StringUtil.shorten(HtmlUtil.stripHtml(_event.getName()), 200);
		}

		return summary;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portlet.asset.model.AssetRenderer#getTitle(java.util.Locale)
	 */
	@Override
	public String getTitle(final Locale locale) {

		return _event.getName();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portal.kernel.trash.TrashRenderer#getType()
	 */
	@Override
	public String getType() {

		return EventAssetRendererFactory.TYPE;
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRenderer#render(javax.portlet.
	 * RenderRequest, javax.portlet.RenderResponse, java.lang.String)
	 */
	@Override
	public String render(
		final RenderRequest renderRequest, final RenderResponse renderResponse,
		final String template)
		throws Exception {

		return null;
	}

	private final Event _event;
}
