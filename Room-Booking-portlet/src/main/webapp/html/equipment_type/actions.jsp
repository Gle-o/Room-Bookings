<%@page import="com.zenixia.plugins.constants.PortletKeys"%>
<%@page import="com.zenixia.plugins.model.EquipmentType"%>
<%@page import="com.zenixia.plugins.permissions.EquipmentTypePermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
EquipmentType equipmentType = (EquipmentType)row.getObject();

long groupId = equipmentType.getGroupId();
long equipmentTypeId = equipmentType.getEquipmentTypeId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>

	<c:if test="<%= EquipmentTypePermission.contains(permissionChecker, equipmentTypeId, ActionKeys.UPDATE) %>">
		
		<liferay-portlet:renderURL var="updateEquipmentTypeURL"
				portletName="<%= PortletKeys.EQUIPMENT_TYPE_PORTLETID %>"
			    varImpl="updateEquipmentTypeURL" 
			    plid="<%= themeDisplay.getPlid() %>"
				portletMode="<%= PortletMode.VIEW.toString() %>"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="equipmentTypeId" value="<%= String.valueOf(equipmentTypeId) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="${updateEquipmentTypeURL}" useDialog="true"/>
	</c:if>

	<c:if test="<%= EquipmentTypePermission.contains(permissionChecker, equipmentTypeId, ActionKeys.DELETE) %>">
		
		<liferay-portlet:actionURL var="deleteURL" name="deleteEquipmentType" portletName="<%= PortletKeys.EQUIPMENT_TYPE_PORTLETID %>">
			<portlet:param name="equipmentTypeId" value="<%= String.valueOf(equipmentTypeId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%=  EquipmentTypePermission.contains(permissionChecker, equipmentTypeId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= EquipmentType.class.getName() %>"
			modelResourceDescription="<%= equipmentType.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(equipmentTypeId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>