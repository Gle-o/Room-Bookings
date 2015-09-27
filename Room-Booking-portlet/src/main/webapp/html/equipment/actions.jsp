<%@page import="com.zenixia.plugins.constants.PortletKeys"%>
<%@page import="com.zenixia.plugins.model.Equipment"%>
<%@page import="com.zenixia.plugins.permissions.EquipmentPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Equipment equipment = (Equipment)row.getObject();

long groupId = equipment.getGroupId();
long equipmentId = equipment.getEquipmentId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>

	<c:if test="<%= EquipmentPermission.contains(permissionChecker, equipmentId, ActionKeys.UPDATE) %>">
		
		<liferay-portlet:renderURL var="updateEquipmentURL"
				portletName="<%= PortletKeys.EQUIPMENT_PORTLETID %>"
			    varImpl="updateEquipmentURL" 
			    plid="<%= themeDisplay.getPlid() %>"
				portletMode="<%= PortletMode.VIEW.toString() %>"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="equipmentId" value="<%= String.valueOf(equipmentId) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="${updateEquipmentURL}" useDialog="true"/>
	</c:if>

	<c:if test="<%= EquipmentPermission.contains(permissionChecker, equipmentId, ActionKeys.DELETE) %>">
		
		<liferay-portlet:actionURL var="deleteURL" name="deleteEquipment" portletName="<%= PortletKeys.EQUIPMENT_PORTLETID %>">
			<portlet:param name="equipmentId" value="<%= String.valueOf(equipmentId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%=  EquipmentPermission.contains(permissionChecker, equipmentId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Equipment.class.getName() %>"
			modelResourceDescription="<%= equipment.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(equipmentId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>