
<%@page import="com.liferay.util.ColorUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/init.jsp" %>

<%
String activeView = ParamUtil.getString(request, "activeView", sessionClicksDefaultView);
long date = ParamUtil.getLong(request, "date", System.currentTimeMillis());
String editRoomBookingURL = ParamUtil.getString(request, "editRoomBookingURL");
String filterRoomBookings = ParamUtil.getString(request, "filterRoomBookings", null);
boolean hideAgendaView = ParamUtil.getBoolean(request, "hideAgendaView");
boolean hideDayView = ParamUtil.getBoolean(request, "hideDayView");
boolean hideMonthView = ParamUtil.getBoolean(request, "hideMonthView");
boolean hideWeekView = ParamUtil.getBoolean(request, "hideWeekView");
String permissionsRoomBookingURL = ParamUtil.getString(request, "permissionsRoomBookingURL");
boolean preventPersistence = ParamUtil.getBoolean(request, "preventPersistence");
boolean readOnly = ParamUtil.getBoolean(request, "readOnly");
boolean showAddRoomBookingBtn = ParamUtil.getBoolean(request, "showAddRoomBookingBtn");
String viewRoomBookingURL = ParamUtil.getString(request, "viewRoomBookingURL");
%>

<div class="room-portlet-wrapper" id="<portlet:namespace />scheduler"></div>

<%@ include file="/html/booking/event_recorder.jspf" %>

<aui:script use="aui-toggler,liferay-room-list,liferay-scheduler,liferay-store,json">
	Liferay.RoomUtil.PORTLET_NAMESPACE = '<portlet:namespace />';
	Liferay.RoomUtil.USER_TIME_ZONE = '<%= HtmlUtil.escapeJS(userTimeZone.getID()) %>';

	<c:if test="<%= !hideDayView %>">
		window.<portlet:namespace />dayView = new A.SchedulerDayView(
			{
				height: 700,
				isoTime: <%= isoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					allDay: '<liferay-ui:message key="all-day" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !hideWeekView %>">
		window.<portlet:namespace />weekView = new A.SchedulerWeekView(
			{
				height: 700,
				isoTime: <%= isoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					allDay: '<liferay-ui:message key="all-day" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !hideMonthView %>">
		window.<portlet:namespace />monthView = new A.SchedulerMonthView(
			{
				height: 700,
				isoTime: <%= isoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					close: '<liferay-ui:message key="close" />',
					more: '<%= StringUtil.toLowerCase(LanguageUtil.get(pageContext, "more")) %>',
					show: '<liferay-ui:message key="show" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !hideAgendaView %>">
		window.<portlet:namespace />agendaView = new A.SchedulerAgendaView(
			{
				height: 700,
				isoTime: <%= isoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					noEvents: '<liferay-ui:message key="no-events" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !readOnly %>">
		var width = Math.min(Liferay.Util.getWindowWidth(), 550);

		window.<portlet:namespace />eventRecorder = new Liferay.SchedulerEventRecorder(
			{
				bodyTemplate: new A.Template(A.one('#<portlet:namespace />eventRecorderBodyTpl').html()),
				roomId: '',
				color: 'red',
				duration: <%= defaultDuration %>,
				editRoomBookingURL: '<%= HtmlUtil.escapeJS(editRoomBookingURL) %>',
				headerTemplate: new A.Template(A.one('#<portlet:namespace />eventRecorderHeaderTpl').html()),
				permissionsRoomBookingURL: '<%= HtmlUtil.escapeJS(permissionsRoomBookingURL) %>',
				popover: {
					width: width
				},
				portletNamespace: '<portlet:namespace />',
				viewRoomBookingURL: '<%= HtmlUtil.escapeJS(viewRoomBookingURL) %>'
			}
		);
	</c:if>

	var views = [];

	<c:if test="<%= !hideDayView %>">
		views.push(window.<portlet:namespace />dayView);
	</c:if>

	<c:if test="<%= !hideWeekView %>">
		views.push(window.<portlet:namespace />weekView);
	</c:if>

	<c:if test="<%= !hideMonthView %>">
		views.push(window.<portlet:namespace />monthView);
	</c:if>

	<c:if test="<%= !hideAgendaView %>">
		views.push(window.<portlet:namespace />agendaView);
	</c:if>

	window.<portlet:namespace />scheduler = new Liferay.Scheduler(
		{
			activeView: window['<portlet:namespace /><%= HtmlUtil.escapeJS(activeView) %>View'],
			boundingBox: '#<portlet:namespace />scheduler',

			<%
			Calendar dateJCalendar = CalendarFactoryUtil.getCalendar(userTimeZone);

			dateJCalendar.setTimeInMillis(date);

			int dateYear = dateJCalendar.get(java.util.Calendar.YEAR);
			int dateMonth = dateJCalendar.get(java.util.Calendar.MONTH);
			int dateDay = dateJCalendar.get(java.util.Calendar.DAY_OF_MONTH);
			%>

			date: new Date(<%= dateYear %>, <%= dateMonth %>, <%= dateDay %>),

			<c:if test="<%= !themeDisplay.isSignedIn() %>">
				disabled: true,
			</c:if>

			eventRecorder: window.<portlet:namespace />eventRecorder,
			filterRoomBookings: window['<%= HtmlUtil.escapeJS(filterRoomBookings) %>'],
			firstDayOfWeek: <%= weekStartsOn %>,
			items: A.Object.values(Liferay.RoomUtil.availableRooms),
			portletNamespace: '<portlet:namespace />',
			preventPersistence: <%= preventPersistence %>,
			render: true,
			showAddRoomBookingBtn: <%= showAddRoomBookingBtn %>,
			strings: {
				agenda: '<liferay-ui:message key="agenda" />',
				day: '<liferay-ui:message key="day" />',
				month: '<liferay-ui:message key="month" />',
				today: '<liferay-ui:message key="today" />',
				week: '<liferay-ui:message key="week" />',
				year: '<liferay-ui:message key="year" />'
			},

			<%
			java.util.Calendar todayJCalendar = CalendarFactoryUtil.getCalendar(userTimeZone);

			int todayYear = todayJCalendar.get(java.util.Calendar.YEAR);
			int todayMonth = todayJCalendar.get(java.util.Calendar.MONTH);
			int todayDay = todayJCalendar.get(java.util.Calendar.DAY_OF_MONTH);
			%>

			todayDate: new Date(<%= todayYear %>, <%= todayMonth %>, <%= todayDay %>),
			views: views
		}
	);
</aui:script>