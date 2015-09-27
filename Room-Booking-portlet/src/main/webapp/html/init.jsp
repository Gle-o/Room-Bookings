<%@page import="com.zenixia.plugins.util.WebKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@page import="com.liferay.portal.kernel.util.FastDateFormatConstants"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.util.RSSUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.util.SessionClicks"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.zenixia.plugins.model.RoomBooking"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
	String currentURL = PortalUtil.getCurrentURL(request);
	
	RoomBooking calendarBooking = (RoomBooking)request.getAttribute(WebKeys.ROOM_BOOKING);
	
	int defaultDuration = GetterUtil.getInteger(portletPreferences.getValue("defaultDuration", null), 60);
	String defaultView = portletPreferences.getValue("defaultView", "week");
	boolean isoTimeFormat = GetterUtil.getBoolean(portletPreferences.getValue("isoTimeFormat", null), !DateUtil.isFormatAmPm(locale));
	String timeZoneId = portletPreferences.getValue("timeZoneId", user.getTimeZoneId());
	boolean usePortalTimeZone = GetterUtil.getBoolean(portletPreferences.getValue("usePortalTimeZone", Boolean.TRUE.toString()));
	int weekStartsOn = GetterUtil.getInteger(portletPreferences.getValue("weekStartsOn", null), 0);
	
	String sessionClicksDefaultView = SessionClicks.get(request, "calendar-portlet-default-view", defaultView);
	
	if (usePortalTimeZone) {
		timeZoneId = user.getTimeZoneId();
	}
	
	boolean enableRSS = !PortalUtil.isRSSFeedsEnabled() ? false : GetterUtil.getBoolean(portletPreferences.getValue("enableRss", null), true);
	int rssDelta = GetterUtil.getInteger(portletPreferences.getValue("rssDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
	String rssDisplayStyle = portletPreferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_DEFAULT);
	String rssFeedType = portletPreferences.getValue("rssFeedType", RSSUtil.FEED_TYPE_DEFAULT);
	long rssTimeInterval = GetterUtil.getLong(portletPreferences.getValue("rssTimeInterval", StringPool.BLANK), Time.WEEK);
	
	// Take care
	TimeZone userTimeZone =  TimeZone.getTimeZone(timeZoneId);
	TimeZone utcTimeZone = TimeZone.getTimeZone(StringPool.UTC);
	
	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, userTimeZone);
	Format dateFormatLongDate = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, userTimeZone);
	
	Format dateFormatTime = null;
	
	if (isoTimeFormat) {
		dateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("HH:mm", locale, userTimeZone);
	}
	else {
		dateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("hh:mm a", locale, userTimeZone);
	}
%>
