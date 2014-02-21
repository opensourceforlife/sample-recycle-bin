
package com.opensourceforlife.portlet.samplerecyclebin.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.service.EventLocalServiceUtil;

/**
 * @author Opensourcesforlife
 */
public class EventAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String TYPE = "event";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portlet.asset.model.AssetRendererFactory#getAssetRenderer
	 * (long, int)
	 */
	@Override
	public AssetRenderer getAssetRenderer(final long classPK, final int type)
		throws PortalException, SystemException {

		Event event = EventLocalServiceUtil.getEvent(classPK);

		EventAssetRenderer eventAssetRenderer = new EventAssetRenderer(event);

		eventAssetRenderer.setAssetRendererType(type);

		return eventAssetRenderer;
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRendererFactory#getClassName()
	 */
	@Override
	public String getClassName() {

		return Event.class.getName();
	}

	/*
	 * (non-Javadoc)
	 * @see com.liferay.portlet.asset.model.AssetRendererFactory#getType()
	 */
	@Override
	public String getType() {

		return TYPE;
	}

}
