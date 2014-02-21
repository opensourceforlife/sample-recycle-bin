<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@include file="./../init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addEventURL">
		<portlet:param name="mvcPath" value="/html/portlet/sample-recycle-bin/edit_event.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addEventURL.toString() %>" value="add-event" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="event-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= EventLocalServiceUtil.getEventsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= EventLocalServiceUtil.getEventsCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.opensourceforlife.portlet.samplerecyclebin.model.Event"
		keyProperty="eventId"
		modelVar="event" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= event.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="description"
			property="description"
		/>

		<%
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		%>

		<liferay-ui:search-container-column-text
			name="date"
			value="<%= sdf.format(event.getDate()) %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/portlet/sample-recycle-bin/event_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>