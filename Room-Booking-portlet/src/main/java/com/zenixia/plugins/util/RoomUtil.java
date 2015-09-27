/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.zenixia.plugins.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.model.RoomBooking;
import com.zenixia.plugins.permissions.RoomPermission;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

/**
 * @author Eduardo Lundgren
 * @author Peter Shin
 * @author Fabio Pezzutto
 */
public class RoomUtil {

	public static TimeZone getRoomBookingDisplayTimeZone(
		RoomBooking roomBooking, TimeZone defaultTimeZone) {

		if ((roomBooking != null) && roomBooking.isAllDay()) {
			return TimeZone.getTimeZone(StringPool.UTC);
		}

		return defaultTimeZone;
	}

//	public static JSONObject getCalendarRenderingRules(
//			ThemeDisplay themeDisplay, long[] calendarIds, int[] statuses,
//			long startTime, long endTime, String ruleName, TimeZone timeZone)
//		throws SystemException {
//
//		List<RoomBooking> roomBookings =
//			RoomBookingLocalServiceUtil.search(
//				themeDisplay.getCompanyId(), null, calendarIds, new long[0], -1,
//				null, startTime, endTime, true, statuses, QueryUtil.ALL_POS,
//				QueryUtil.ALL_POS, null);
//
//		Map<Integer, Map<Integer, List<Integer>>> rulesMap =
//			new HashMap<Integer, Map<Integer, List<Integer>>>();
//
//		for (RoomBooking roomBooking : roomBookings) {
//			TimeZone displayTimeZone = timeZone;
//
//			if (roomBooking.isAllDay()) {
//				displayTimeZone = _utcTimeZone;
//			}
//
//			java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(
//				roomBooking.getStartTime(), displayTimeZone);
//			java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(
//				roomBooking.getEndTime(), displayTimeZone);
//
//			long days = JCalendarUtil.getDaysBetween(
//				startTimeJCalendar, endTimeJCalendar);
//
//			for (int i = 0; i <= days; i++) {
//				int year = startTimeJCalendar.get(java.util.Calendar.YEAR);
//
//				Map<Integer, List<Integer>> rulesMonth = rulesMap.get(year);
//
//				if (rulesMonth == null) {
//					rulesMonth = new HashMap<Integer, List<Integer>>();
//
//					rulesMap.put(year, rulesMonth);
//				}
//
//				int month = startTimeJCalendar.get(java.util.Calendar.MONTH);
//
//				List<Integer> rulesDay = rulesMonth.get(month);
//
//				if (rulesDay == null) {
//					rulesDay = new ArrayList<Integer>();
//
//					rulesMonth.put(month, rulesDay);
//				}
//
//				int day = startTimeJCalendar.get(
//					java.util.Calendar.DAY_OF_MONTH);
//
//				if (!rulesDay.contains(day)) {
//					rulesDay.add(day);
//				}
//
//				startTimeJCalendar.add(java.util.Calendar.DATE, 1);
//			}
//		}
//
//		Set<Integer> years = rulesMap.keySet();
//
//		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
//
//		for (Integer year : years) {
//			Map<Integer, List<Integer>> monthsMap = rulesMap.get(year);
//
//			Set<Integer> months = monthsMap.keySet();
//
//			JSONObject jsonObjectMonth = JSONFactoryUtil.createJSONObject();
//
//			jsonObject.put(String.valueOf(year), jsonObjectMonth);
//
//			for (Integer month : months) {
//				List<Integer> days = monthsMap.get(month);
//
//				JSONObject jsonObjectDay = JSONFactoryUtil.createJSONObject();
//
//				jsonObjectDay.put(StringUtil.merge(days), ruleName);
//
//				jsonObjectMonth.put(String.valueOf(month), jsonObjectDay);
//			}
//		}
//
//		return jsonObject;
//	}

	public static RoomBooking getNewDurationRoomBooking(
		RoomBooking roomBooking, long duration) {

		roomBooking.setEndTime(roomBooking.getStartTime() + duration);

		return roomBooking;
	}

	public static RoomBooking getNewStartTimeRoomBooking(
		RoomBooking roomBooking, long offset) {

		roomBooking.setStartTime(roomBooking.getStartTime() + offset);
		roomBooking.setEndTime(roomBooking.getEndTime() + offset);

		return roomBooking;
	}

//	public static OrderByComparator getOrderByComparator(
//		String orderByCol, String orderByType) {
//
//		boolean orderByAsc = false;
//
//		if (orderByType.equals("asc")) {
//			orderByAsc = true;
//		}
//
//		OrderByComparator orderByComparator = new CalendarNameComparator(
//			orderByAsc);
//
//		return orderByComparator;
//	}

	public static String[] splitKeywords(String keywords) {
		Set<String> keywordsSet = new LinkedHashSet<String>();

		StringBundler sb = new StringBundler();

		for (char c : keywords.toCharArray()) {
			if (Character.isWhitespace(c)) {
				if (sb.length() > 0) {
					keywordsSet.add(sb.toString());

					sb = new StringBundler();
				}
			}
			else if (Character.isLetterOrDigit(c)) {
				sb.append(c);
			}
			else {
				return new String[] {keywords};
			}
		}

		if (sb.length() > 0) {
			keywordsSet.add(sb.toString());
		}

		return StringUtil.split(StringUtil.merge(keywordsSet));
	}

	public static JSONObject toRoomBookingJSONObject(
			ThemeDisplay themeDisplay, RoomBooking roomBooking,
			TimeZone timeZone)
		throws SystemException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("allDay", roomBooking.isAllDay());
		jsonObject.put(
			"roomBookingId", roomBooking.getRoomBookingId());
		jsonObject.put("roomId", roomBooking.getRoomId());
		jsonObject.put(
			"description",
			roomBooking.getDescription(themeDisplay.getLocale()));

		if (roomBooking.isAllDay()) {
			timeZone = TimeZone.getTimeZone(StringPool.UTC);
		}

		java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(
			roomBooking.getEndTime(), timeZone);

		_addTimeProperties(jsonObject, "endTime", endTimeJCalendar);

		jsonObject.put("firstReminder", roomBooking.getFirstReminder());
		jsonObject.put(
			"firstReminderType", roomBooking.getFirstReminderType());

//		jsonObject.put("instanceIndex", roomBooking.getInstanceIndex());
//		jsonObject.put("location", roomBooking.getLocation());
//		jsonObject.put(
//			"parentRoomBookingId",
//			roomBooking.getParentRoomBookingId());
		jsonObject.put("recurrence", roomBooking.getRecurrence());
		jsonObject.put("secondReminder", roomBooking.getSecondReminder());
		jsonObject.put(
			"secondReminderType", roomBooking.getSecondReminder());

		java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(
			roomBooking.getStartTime(), timeZone);

		_addTimeProperties(jsonObject, "startTime", startTimeJCalendar);

		jsonObject.put("status", roomBooking.getStatus());
		jsonObject.put(
			"title", roomBooking.getTitle(themeDisplay.getLocale()));

		return jsonObject;
	}

	public static JSONArray toRoomBookingsJSONArray(
			ThemeDisplay themeDisplay, List<RoomBooking> roomBookings)
		throws PortalException, SystemException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (roomBookings == null) {
			return jsonArray;
		}

		for (RoomBooking roomBooking : roomBookings) {
			JSONObject jsonObject = toRoomJSONObject(
				themeDisplay, roomBooking.getRoom());

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	public static JSONArray toRoomBookingsJSONArray(
			ThemeDisplay themeDisplay, List<RoomBooking> roomBookings,
			TimeZone timeZone)
		throws PortalException, SystemException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (RoomBooking roomBooking : roomBookings) {
			JSONObject jsonObject = toRoomBookingJSONObject(
				themeDisplay, roomBooking, timeZone);

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	public static JSONObject toRoomJSONObject(
			ThemeDisplay themeDisplay, Room room)
		throws SystemException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("roomId", room.getRoomId());

//		jsonObject.put(
//			"calendarResourceId", calendarResource.getCalendarResourceId());
//		jsonObject.put(
//			"calendarResourceName",
//			calendarResource.getName(themeDisplay.getLocale()));
//		jsonObject.put("color", ColorUtil.toHexString(room.getColor()));
		jsonObject.put("color","red");
		jsonObject.put("classNameId", PortalUtil.getClassNameId(Room.class));
		jsonObject.put("classPK", room.getRoomId());
		jsonObject.put("groupId", room.getGroupId());
		jsonObject.put("name", room.getName(themeDisplay.getLocale()));
		jsonObject.put(
			"permissions",
			_getPermissionsJSONObject(
				themeDisplay.getPermissionChecker(), room));
		jsonObject.put("userId", room.getUserId());

		return jsonObject;
	}

//	public static JSONObject toCalendarResourceJSONObject(
//		ThemeDisplay themeDisplay, CalendarResource calendarResource) {
//
//		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
//
//		jsonObject.put(
//			"calendarResourceId", calendarResource.getCalendarResourceId());
//		jsonObject.put("classNameId", calendarResource.getClassNameId());
//		jsonObject.put("classPK", calendarResource.getClassPK());
//		jsonObject.put("classUuid", calendarResource.getClassUuid());
//		jsonObject.put("code", calendarResource.getCode());
//		jsonObject.put("groupId", calendarResource.getGroupId());
//		jsonObject.put(
//			"name", calendarResource.getName(themeDisplay.getLocale()));
//		jsonObject.put("userId", calendarResource.getUserId());
//
//		return jsonObject;
//	}

	public static JSONArray toRoomsJSONArray(
			ThemeDisplay themeDisplay, List<Room> rooms)
		throws SystemException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (rooms == null) {
			return jsonArray;
		}

		for (Room room : rooms) {
			JSONObject jsonObject = toRoomJSONObject(
				themeDisplay, room);

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	private static void _addTimeProperties(
		JSONObject jsonObject, String prefix, java.util.Calendar jCalendar) {

		jsonObject.put(prefix, jCalendar.getTimeInMillis());
		jsonObject.put(
			prefix + "Day", jCalendar.get(java.util.Calendar.DAY_OF_MONTH));
		jsonObject.put(
			prefix + "Hour", jCalendar.get(java.util.Calendar.HOUR_OF_DAY));
		jsonObject.put(
			prefix + "Minute", jCalendar.get(java.util.Calendar.MINUTE));
		jsonObject.put(
			prefix + "Month", jCalendar.get(java.util.Calendar.MONTH));
		jsonObject.put(prefix + "Year", jCalendar.get(java.util.Calendar.YEAR));
	}

	private static JSONObject _getPermissionsJSONObject(
		PermissionChecker permissionChecker, Room room) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put(
			ActionKeys.DELETE,
			RoomPermission.contains(
				permissionChecker, room, ActionKeys.DELETE));

		jsonObject.put(
			ActionKeys.UPDATE,
			RoomPermission.contains(
				permissionChecker, room, ActionKeys.UPDATE));

		jsonObject.put(
			ActionKeys.PERMISSIONS,
			RoomPermission.contains(
				permissionChecker, room, ActionKeys.PERMISSIONS));

		jsonObject.put(
			ActionKeys.VIEW,
			RoomPermission.contains(
				permissionChecker, room, ActionKeys.VIEW));

//		jsonObject.put(
//			ActionKeys.VIEW_BOOKING_DETAILS,
//			RoomPermission.contains(
//				permissionChecker, room, ActionKeys.VIEW_BOOKING_DETAILS));

		return jsonObject;
	}

	private static TimeZone _utcTimeZone = TimeZone.getTimeZone(StringPool.UTC);

}