<%@page import="com.zenixia.plugins.constants.PortletKeys"%>
<%@page import="com.zenixia.plugins.model.Room"%>
<%@page import="com.zenixia.plugins.permissions.RoomPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Room room = (Room)row.getObject();

long groupId = room.getGroupId();
long roomId = room.getRoomId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>

	<c:if test="<%= RoomPermission.contains(permissionChecker, roomId, ActionKeys.UPDATE) %>">
		
		<liferay-portlet:renderURL var="updateRoomURL"
				portletName="<%= PortletKeys.ROOM_PORTLETID %>"
			    varImpl="updateRoomURL" 
			    plid="<%= themeDisplay.getPlid() %>"
				portletMode="<%= PortletMode.VIEW.toString() %>"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="roomId" value="<%= String.valueOf(roomId) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="${updateRoomURL}" useDialog="true"/>
	</c:if>

	<c:if test="<%= RoomPermission.contains(permissionChecker, roomId, ActionKeys.DELETE) %>">
		
		<liferay-portlet:actionURL var="deleteURL" name="deleteRoom" portletName="<%= PortletKeys.ROOM_PORTLETID %>">
			<portlet:param name="roomId" value="<%= String.valueOf(roomId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%=  RoomPermission.contains(permissionChecker, roomId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Room.class.getName() %>"
			modelResourceDescription="<%= room.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(roomId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>