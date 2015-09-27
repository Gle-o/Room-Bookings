<%@page import="com.zenixia.plugins.constants.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@include file="/html/init.jsp" %>

<portlet:renderURL var="viewManagementURL" />

<aui:nav-bar cssClass="label-info">
	<aui:nav>
		<liferay-portlet:renderURL portletName="EquipmentType_WAR_RoomBookingportlet" var="addBookingURL">
			
		</liferay-portlet:renderURL>
	    
		<aui:nav-item href="${addBookingURL}" iconCssClass="icon-plus" label="com.zenixia.plugin.room.management.tab.add.booking" useDialog="true" />
		
		<aui:nav-item cssClass="divider" />
		
		<c:if test="${addRoom}">
			<liferay-portlet:renderURL portletName="<%= PortletKeys.ROOM_PORTLETID %>"
										var="addRoomUrl"
										plid="<%= PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()) %>" 
										windowState="<%= LiferayWindowState.POP_UP.toString() %>"/>
		    
		    <aui:nav-item href="${addRoomUrl}" iconCssClass="icon-plus" label="com.zenixia.plugin.room.management.tab.add.room" title="com.zenixia.plugin.room.management.tab.add.room" useDialog="true" />
		    
		    <aui:nav-item cssClass="divider" />
	    </c:if>
	    
	   	<c:if test="${addEquipment}">
		    <liferay-portlet:renderURL portletName="<%= PortletKeys.EQUIPMENT_PORTLETID %>"
										var="addEquipmentlURL"
										plid="<%= PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()) %>" 
										windowState="<%= LiferayWindowState.POP_UP.toString() %>"/>
		    
		    <aui:nav-item href="${addEquipmentlURL}" iconCssClass="icon-plus" label="com.zenixia.plugin.room.management.tab.add.equipment" title="com.zenixia.plugin.room.management.tab.add.equipment" useDialog="true" />
		    
		    <aui:nav-item cssClass="divider" />
	    </c:if>
	    
	   	<c:if test="${addEquipmentType}">
			<liferay-portlet:renderURL portletName="<%= PortletKeys.EQUIPMENT_TYPE_PORTLETID %>"
										var="addEquipmentTypelURL"
										plid="<%= PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()) %>" 
										windowState="<%= LiferayWindowState.POP_UP.toString() %>"/>
										
		    <aui:nav-item href="${addEquipmentTypelURL}" iconCssClass="icon-plus" label="com.zenixia.plugin.room.management.tab.add.equipmentType" title="com.zenixia.plugin.room.management.tab.add.equipmentType" useDialog="true"/>
		</c:if>
	</aui:nav>
</aui:nav-bar>

<br>

<liferay-ui:tabs
	names="com.zenixia.plugin.room.management.tab.view,com.zenixia.plugin.room.management.tab.booking,com.zenixia.plugin.room.management.tab.room,com.zenixia.plugin.room.management.tab.equipment,com.zenixia.plugin.room.management.tab.equipmentType"
	url="<%= viewManagementURL %>"
	param="action"
	value="${action}"
	tabsValues="1,2,3,4,5"
/>

<jsp:include page="${result_jsp}" />

