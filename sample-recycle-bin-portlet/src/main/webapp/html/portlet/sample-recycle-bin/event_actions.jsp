<%@page import="com.liferay.portlet.trash.util.TrashUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file="./../init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Event event = (Event) row.getObject();

	long groupId = event.getGroupId();
	String name = Event.class.getName();
	long eventId = event.getEventId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/portlet/sample-recycle-bin/edit_event.jsp" />
		<portlet:param name="eventId" value="<%= String.valueOf(eventId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteEvent" var="deleteURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
		<portlet:param name="eventId" value="<%= String.valueOf(eventId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	
	<liferay-ui:icon-delete
		label="<%= true %>"
		trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
		url="<%= deleteURL.toString() %>"
	/>
</liferay-ui:icon-menu>