<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.zenixia.plugins.util.RoomUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.zenixia.plugins.model.Room"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.util.ColorUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.zenixia.plugins.service.RoomServiceUtil"%>
<%@page import="com.zenixia.plugins.util.ActionKeys"%>
<%@page import="com.zenixia.plugins.permissions.BookingPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/html/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String activeView = ParamUtil.getString(request, "activeView", sessionClicksDefaultView);
long date = ParamUtil.getLong(request, "date", System.currentTimeMillis());


List<Room> rooms = RoomServiceUtil.getRoomByGroupId(scopeGroupId);


JSONArray roomsJSONArray = RoomUtil.toRoomsJSONArray(themeDisplay, rooms);

boolean columnOptionsVisible = GetterUtil.getBoolean(SessionClicks.get(request, "calendar-portlet-column-options-visible", "true"));
%>

<aui:container cssClass="calendar-portlet-column-parent">
	<aui:row>
		<aui:col cssClass='<%= "room-portlet-column-options " + (columnOptionsVisible ? StringPool.BLANK : "hide") %>' id="columnOptions" span="<%= 3 %>">
			<div class="room-portlet-mini-room" id="<portlet:namespace />miniRoomContainer"></div>

			<div id="<portlet:namespace />roomListContainer">
				<c:if test="<%= themeDisplay.isSignedIn() %>">
					<div class="room-portlet-list-header toggler-header-expanded">
						<span class="room-portlet-list-arrow"></span>

						<span class="room-portlet-list-text"><liferay-ui:message key="com.zenixia.plugin.rooms" /></span>


<%-- 					<c:if test="<%= userRoomResource != null %>">
							<span class="room-list-item-arrow" data-roomResourceId="<%= userRoomResource.getRoomResourceId() %>" tabindex="0"><i class="icon-caret-down"></i></span>
						</c:if>
--%>
					</div>

					<div class="room-portlet-room-list" id="<portlet:namespace />myRoomList"></div>
				</c:if>
<%-- 
				<c:if test="<%= groupRoomResource != null %>">
					<div class="room-portlet-list-header toggler-header-expanded">
						<span class="room-portlet-list-arrow"></span>

						<span class="room-portlet-list-text"><liferay-ui:message key="current-site-rooms" /></span>

						<c:if test="<%= RoomResourcePermission.contains(permissionChecker, groupRoomResource, ActionKeys.ADD_CALENDAR) %>">
							<span class="room-list-item-arrow" data-roomResourceId="<%= groupRoomResource.getRoomResourceId() %>" tabindex="0"><i class="icon-caret-down"></i></span>
						</c:if>
					</div>

					<div class="room-portlet-room-list" id="<portlet:namespace />siteRoomList"></div>
				</c:if>

--%>
				<c:if test="<%= themeDisplay.isSignedIn() %>">
					<div class="room-portlet-list-header toggler-header-expanded">
						<span class="room-portlet-list-arrow"></span>

						<span class="room-portlet-list-text"><liferay-ui:message key="other-rooms" /></span>
					</div>

					<div class="room-portlet-room-list" id="<portlet:namespace />otherRoomList">
						<input class="room-portlet-add-rooms-input" id="<portlet:namespace />addOtherRoom" placeholder="<liferay-ui:message key="add-other-rooms" />" type="text" />
					</div>
				</c:if>
			</div>

			<div id="<portlet:namespace />message"></div>
		</aui:col>

		<aui:col cssClass="calendar-portlet-column-grid" id="columnGrid" span="<%= columnOptionsVisible ? 9 : 12 %>">
			<div class="calendar-portlet-column-toggler" id="<portlet:namespace />columnToggler">
				<i class="<%= columnOptionsVisible ? "icon-caret-left" : "icon-caret-right" %>" id="<portlet:namespace />columnTogglerIcon"></i>
			</div>

			<liferay-util:include page="/html/booking/scheduler.jsp" servletContext="<%= application %>">
				<liferay-util:param name="activeView" value="<%= activeView %>" />
				<liferay-util:param name="date" value="<%= String.valueOf(date) %>" />

				<portlet:renderURL var="editRoomBookingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="mvcPath" value="/edit_room_booking.jsp" />
					<portlet:param name="activeView" value="{activeView}" />
					<portlet:param name="allDay" value="{allDay}" />
					<portlet:param name="roomBookingId" value="{roomBookingId}" />
					<portlet:param name="roomId" value="{roomId}" />
					<portlet:param name="date" value="{date}" />
					<portlet:param name="endTimeDay" value="{endTimeDay}" />
					<portlet:param name="endTimeHour" value="{endTimeHour}" />
					<portlet:param name="endTimeMinute" value="{endTimeMinute}" />
					<portlet:param name="endTimeMonth" value="{endTimeMonth}" />
					<portlet:param name="endTimeYear" value="{endTimeYear}" />
					<portlet:param name="instanceIndex" value="{instanceIndex}" />
					<portlet:param name="startTimeDay" value="{startTimeDay}" />
					<portlet:param name="startTimeHour" value="{startTimeHour}" />
					<portlet:param name="startTimeMinute" value="{startTimeMinute}" />
					<portlet:param name="startTimeMonth" value="{startTimeMonth}" />
					<portlet:param name="startTimeYear" value="{startTimeYear}" />
					<portlet:param name="titleCurrentValue" value="{titleCurrentValue}" />
				</portlet:renderURL>

				<liferay-util:param name="editRoomBookingURL" value="<%= editRoomBookingURL %>" />

				<liferay-util:param name="readOnly" value="<%= String.valueOf(false) %>" />

				<liferay-security:permissionsURL
					modelResource="<%= RoomBooking.class.getName() %>"
					modelResourceDescription="{modelResourceDescription}"
					resourceGroupId="{resourceGroupId}"
					resourcePrimKey="{resourcePrimKey}"
					var="permissionsRoomBookingURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>

				<liferay-util:param name="permissionsRoomBookingURL" value="<%= permissionsRoomBookingURL %>" />

				<liferay-util:param name="showAddRoomBookingBtn" value="<%= String.valueOf(BookingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ROOM_BOOKING)) %>" />

				<portlet:renderURL var="viewRoomBookingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="mvcPath" value="/view_room_booking.jsp" />
					<portlet:param name="roomBookingId" value="{roomBookingId}" />
					<portlet:param name="instanceIndex" value="{instanceIndex}" />
				</portlet:renderURL>

				<liferay-util:param name="viewRoomBookingURL" value="<%= viewRoomBookingURL %>" />
			</liferay-util:include>
		</aui:col>
	</aui:row>
</aui:container>

	<%@ include file="view_room_menus.jspf" %>

<aui:script use="aui-toggler,liferay-room-list,liferay-scheduler,liferay-store,json">
	Liferay.RoomUtil.USER_CLASS_NAME_ID = <%= PortalUtil.getClassNameId(User.class) %>;

	var syncRoomsMap = function() {
		var roomLists = [];
		
		<c:if test="<%= themeDisplay.isSignedIn() %>">
			roomLists.push(window.<portlet:namespace />myRoomList);
		</c:if>
<%--
		<c:if test="<%= themeDisplay.isSignedIn() || (rooms != null) %>">
			roomLists.push(window.<portlet:namespace />myRoomList);
		</c:if>

		<c:if test="<%= themeDisplay.isSignedIn() %>">
			roomLists.push(window.<portlet:namespace />otherRoomList);
		</c:if>

		<c:if test="<%= groupRoomResource != null %>">
			roomLists.push(window.<portlet:namespace />siteRoomList);
		</c:if>
--%>
		Liferay.RoomUtil.syncRoomsMap(roomLists);
	}

	window.<portlet:namespace />syncRoomsMap = syncRoomsMap;

	window.<portlet:namespace />roomLists = {};

	<c:if test="<%= themeDisplay.isSignedIn() %>">
		window.<portlet:namespace />myRoomList = new Liferay.RoomList(
			{
				after: {
					roomsChange: syncRoomsMap,
					'scheduler-room:visibleChange': function(event) {
						syncRoomsMap();

						<portlet:namespace />refreshVisibleRoomRenderingRules();
					}
				},
				boundingBox: '#<portlet:namespace />myRoomList',

				<%
				updateRoomsJSONArray(request, roomsJSONArray);
				%>

				rooms: <%= roomsJSONArray %>,
				scheduler: <portlet:namespace />scheduler,
				simpleMenu: window.<portlet:namespace />roomsMenu,
				visible: <%= themeDisplay.isSignedIn() %>
			}
		).render();

		<%-- window.<portlet:namespace />roomLists['<%= userRoomResource.getRoomResourceId() %>'] = window.<portlet:namespace />myRoomList;--%> 
	</c:if>
<%-- 
	<c:if test="<%= themeDisplay.isSignedIn() %>">
		window.<portlet:namespace />otherRoomList = new Liferay.RoomList(
			{
				after: {
					roomsChange: function(event) {
					console.log("roomsChange");
						syncRoomsMap();

						<portlet:namespace />scheduler.load();

						var roomIds = A.Array.invoke(event.newVal, 'get', 'roomId');

						Liferay.Store('room-portlet-other-rooms', roomIds.join());
					},
					'scheduler-room:visibleChange': function(event) {
						console.log("scheduler-room");
						syncRoomsMap();

						<portlet:namespace />refreshVisibleRoomRenderingRules();
					}
				},
				boundingBox: '#<portlet:namespace />otherRoomList',

				<%
				updateRoomsJSONArray(request, roomsJSONArray);
				%>

				rooms: <%= roomsJSONArray %>,
				scheduler: <portlet:namespace />scheduler,
				simpleMenu: window.<portlet:namespace />roomsMenu
			}
		).render();
	</c:if>
--%>
	syncRoomsMap();

	A.each(
		Liferay.RoomUtil.availableRooms,
		function(item, index) {
			item.on(
				{
					'visibleChange': function(event) {
						console.log("visibleChange");
						var instance = this;

						var room = event.currentTarget;
						console.log(room);
						Liferay.Store('room-portlet-room-' + room.get('roomId') + '-visible', event.newVal);
					}
				}
			);
		}
	);

	window.<portlet:namespace />toggler = new A.TogglerDelegate(
		{
			animated: true,
			container: '#<portlet:namespace />roomListContainer',
			content: '.room-portlet-room-list',
			header: '.room-portlet-list-header'
		}
	);

	<c:if test="<%= themeDisplay.isSignedIn() %>">
		var addOtherRoomInput = A.one('#<portlet:namespace />addOtherRoom');

		<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="roomResources" var="roomResourcesURL" />

		Liferay.RoomUtil.createRoomsAutoComplete(
			'<%= roomResourcesURL %>',
			addOtherRoomInput,
			function(event) {
				window.<portlet:namespace />otherRoomList.add(event.result.raw);

				<portlet:namespace />refreshVisibleRoomRenderingRules();

				addOtherRoomInput.val('');
			}
		);
	</c:if>

	A.one('#<portlet:namespace />columnToggler').on(
		'click',
		function(event) {
			var columnGrid = A.one('#<portlet:namespace />columnGrid');
			var columnOptions = A.one('#<portlet:namespace />columnOptions');
			var columnTogglerIcon = A.one('#<portlet:namespace />columnTogglerIcon');

			Liferay.Store('calendar-portlet-column-options-visible', columnOptions.hasClass('hide'));

			columnGrid.toggleClass('span9').toggleClass('span12');

			columnOptions.toggleClass('hide');

			columnTogglerIcon.toggleClass('icon-caret-left').toggleClass('icon-caret-right');
		}
	);
</aui:script>

<aui:script use="aui-base,aui-datatype,calendar">
	var DateMath = A.DataType.DateMath;

	window.<portlet:namespace />refreshMiniRoomSelectedDates = function() {
		<portlet:namespace />miniRoom._clearSelection();

		var activeView = <portlet:namespace />scheduler.get('activeView');
		var viewDate = <portlet:namespace />scheduler.get('viewDate');

		var viewName = activeView.get('name');

		var total = 1;

		if (viewName == 'month') {
			total = A.Date.daysInMonth(viewDate);
		}
		else if (viewName == 'week') {
			total = 7;
		}

		var selectedDates = Liferay.RoomUtil.getDatesList(viewDate, total);

		<portlet:namespace />miniRoom.selectDates(selectedDates);

		<portlet:namespace />miniRoom.set('date', viewDate);
	};

	window.<portlet:namespace />refreshVisibleRoomRenderingRules = function() {
		var miniRoomStartDate = DateMath.subtract(DateMath.toMidnight(window.<portlet:namespace />miniRoom.get('date')), DateMath.WEEK, 1);

		var miniRoomEndDate = DateMath.add(DateMath.add(miniRoomStartDate, DateMath.MONTH, 1), DateMath.WEEK, 1);

		miniRoomEndDate.setHours(23, 59, 59, 999);

		Liferay.RoomUtil.getRoomRenderingRules(
			A.Object.keys(Liferay.RoomUtil.visibleRooms),
			Liferay.RoomUtil.toUTC(miniRoomStartDate),
			Liferay.RoomUtil.toUTC(miniRoomEndDate),
			'busy',
			function(rulesDefinition) {
				window.<portlet:namespace />miniRoom.set(
					'customRenderer',
					{
						filterFunction: function(date, node, rules) {
							node.addClass('lfr-busy-day');

							var selectedDates = this._getSelectedDatesList();

							DateMath.toMidnight(date);

							var selected = (selectedDates.length > 0) && A.Date.isInRange(date, selectedDates[0], selectedDates[selectedDates.length - 1]);

							if (A.DataType.DateMath.isToday(date)) {
								node.addClass('lfr-current-day');
							}

							node.toggleClass('yui3-room-day-selected', selected);
						},
						rules: rulesDefinition
					}
				);
			}
		);
	};

	window.<portlet:namespace />miniRoom = new A.Calendar(
		{
			after: {
				dateChange: <portlet:namespace />refreshVisibleRoomRenderingRules,
				dateClick: function(event) {
					<portlet:namespace />scheduler.setAttrs(
						{
							activeView: <portlet:namespace />dayView,
							date: event.date
						}
					);
				}
			},
			date: new Date(<%= String.valueOf(date) %>),
			locale: 'en',
			'strings.first_weekday': <%= weekStartsOn %>
		}
	).render('#<portlet:namespace />miniRoomContainer');

	<portlet:namespace />scheduler.after(
		['*:add', '*:change', '*:load', '*:remove', '*:reset'],
		A.debounce(<portlet:namespace />refreshVisibleRoomRenderingRules, 100)
	);

	<portlet:namespace />scheduler.after(
		['activeViewChange', 'dateChange'],
		<portlet:namespace />refreshMiniRoomSelectedDates
	);

	<portlet:namespace />refreshVisibleRoomRenderingRules();
	<portlet:namespace />refreshMiniRoomSelectedDates();

	<portlet:namespace />scheduler.load();
</aui:script>

<%!
protected void updateRoomsJSONArray(HttpServletRequest request, JSONArray roomsJSONArray) {
	for (int i = 0; i < roomsJSONArray.length(); i++) {
		JSONObject jsonObject = roomsJSONArray.getJSONObject(i);

		long roomId = jsonObject.getLong("roomId");

		System.out.println(roomId);
		jsonObject.put("color", GetterUtil.getString(SessionClicks.get(request, "room-portlet-room-" + roomId + "-color", jsonObject.getString("color"))));
		jsonObject.put("visible", GetterUtil.getBoolean(SessionClicks.get(request, "room-portlet-room-" + roomId + "-visible", "true")));
	}
}
%>