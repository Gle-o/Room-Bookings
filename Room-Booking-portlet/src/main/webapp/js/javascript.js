AUI.add(
	'liferay-scheduler',
	function(A) {
		var AArray = A.Array;
		var AObject = A.Object;
		var DateMath = A.DataType.DateMath;
		var Lang = A.Lang;
		var LString = Lang.String;

		var RecurrenceUtil = Liferay.RecurrenceUtil;
		var Workflow = Liferay.Workflow;

		var isBoolean = Lang.isBoolean;
		var isDate = Lang.isDate;
		var isFunction = Lang.isFunction;
		var isObject = Lang.isObject;
		var isValue = Lang.isValue;

		var toInitialCap = A.cached(
			function(str) {
				return str.substring(0, 1).toUpperCase() + str.substring(1);
			}
		);

		var toInt = function(value) {
			return Lang.toInt(value, 10, 0);
		};

		var COMPANY_ID = toInt(themeDisplay.getCompanyId());

		var CONTROLS_NODE = 'controlsNode';

		var ICON_ADD_EVENT_NODE = 'iconAddEventNode';

		var STR_BLANK = '';

		var STR_COMMA_SPACE = ', ';

		var STR_DASH = '-';

		var STR_SPACE = ' ';

		var TPL_ICON_ADD_EVENT_NODE = '<div class="btn-group">' +
										'<button type="button" class="btn btn-primary room-add-event-btn">' +
											Liferay.Language.get('add-room-booking') +
										'</div>' +
									'</button>';

		var USER_ID = toInt(themeDisplay.getUserId());

		var Time = {
			DAY: 86400000,
			HOUR: 3600000,
			MINUTE: 60000,
			SECOND: 1000,
			WEEK: 604800000,

			TIME_DESC: ['weeks', 'days', 'hours', 'minutes'],

			getDescription: function(milliseconds) {
				var instance = this;

				var desc = 'minutes';
				var value = 0;

				if (milliseconds > 0) {
					AArray.some(
						[Time.WEEK, Time.DAY, Time.HOUR, Time.MINUTE],
						function(item, index) {
							value = milliseconds / item;
							desc = Time.TIME_DESC[index];

							return (milliseconds % item === 0);
						}
					);
				}

				return {
					desc: desc,
					value: value
				};
			}
		};

		Liferay.Time = Time;

		var RoomUtil = {
			INVOKER_URL: themeDisplay.getPathContext() + '/api/jsonws/invoke',
			NOTIFICATION_DEFAULT_TYPE: 'email',
			PORTLET_NAMESPACE: STR_BLANK,
			USER_TIME_ZONE: 'UTC',

			availableRooms: {},
			visibleRooms: {},

			addEvent: function(schedulerEvent, success) {
				var instance = this;

				var endDate = schedulerEvent.get('endDate');
				var startDate = schedulerEvent.get('startDate');

				instance.invokeService(
					{
						'/room-portlet.roombooking/add-room-booking': {
							allDay: schedulerEvent.get('allDay'),
							roomId: schedulerEvent.get('roomId'),
							childRoomIds: STR_BLANK,
							descriptionMap: instance.getLocalizationMap(schedulerEvent.get('description')),
							endTimeDay: endDate.getDate(),
							endTimeHour: endDate.getHours(),
							endTimeMinute: endDate.getMinutes(),
							endTimeMonth: endDate.getMonth(),
							endTimeYear: endDate.getFullYear(),
							firstReminder: schedulerEvent.get('firstReminder'),
							firstReminderType: schedulerEvent.get('firstReminderType'),
							location: schedulerEvent.get('location'),
							parentRoomBookingId: schedulerEvent.get('parentRoomBookingId'),
							recurrence: schedulerEvent.get('recurrence'),
							secondReminder: schedulerEvent.get('secondReminder'),
							secondReminderType: schedulerEvent.get('secondReminderType'),
							startTimeDay: startDate.getDate(),
							startTimeHour: startDate.getHours(),
							startTimeMinute: startDate.getMinutes(),
							startTimeMonth: startDate.getMonth(),
							startTimeYear: startDate.getFullYear(),
							timeZoneId: instance.USER_TIME_ZONE,
							titleMap: instance.getLocalizationMap(LString.unescapeHTML(schedulerEvent.get('content')))
						}
					},
					{
						failure: function() {
							instance.destroyEvent(schedulerEvent);
						},

						start: function() {
							schedulerEvent.set(
								'loading',
								true,
								{
									silent: true
								}
							);
						},

						success: function(data) {
							schedulerEvent.set(
								'loading',
								false,
								{
									silent: true
								}
							);

							if (data) {
								if (data.exception) {
									instance.destroyEvent(schedulerEvent);
								}
								else {
									instance.setEventAttrs(schedulerEvent, data);

									if (success) {
										success.call(instance, data);
									}
								}
							}
						}
					}
				);
			},

			adjustSchedulerEventDisplayTime: function(schedulerEvent) {
				var instance = this;

				var allDay = schedulerEvent.get('allDay');

				var timeAdjuster = instance.toLocalTime;

				if (allDay) {
					timeAdjuster = instance.toLocalTimeWithoutUserTimeZone;
				}

				var endDate = schedulerEvent.get('endDate');
				var startDate = schedulerEvent.get('startDate');

				schedulerEvent.setAttrs(
					{
						endDate: timeAdjuster.call(instance, endDate),
						startDate: timeAdjuster.call(instance, startDate)
					},
					{
						silent: true
					}
				);
			},

			createRoomsAutoComplete: function(resourceURL, input, afterSelectFn) {
				var instance = this;

				input.plug(
					A.Plugin.AutoComplete,
					{
						activateFirstItem: true,
						after: {
							select: afterSelectFn
						},
						maxResults: 20,
						requestTemplate: '&' + instance.PORTLET_NAMESPACE + 'keywords={query}',
						resultFilters: function(query, results) {
							return AArray.filter(
								results,
								function(item, index) {
									return !instance.availableRooms[item.raw.roomId];
								}
							);
						},
						resultFormatter: function(query, results) {
							return AArray.map(
								results,
								function(result) {
									var room = result.raw;
									var name = room.name;
									var roomResourceName = room.roomResourceName;

									if (name !== roomResourceName) {
										name = [roomResourceName, STR_DASH, name].join(STR_SPACE);
									}

									return A.Highlight.words(name, query);
								}
							);
						},
						resultHighlighter: 'wordMatch',
						resultTextLocator: 'roomResourceName',
						source: resourceURL
					}
				);
			},

			createSchedulerEvent: function(roomBooking) {
				var instance = this;

				var endDate = new Date(roomBooking.endTimeYear, roomBooking.endTimeMonth, roomBooking.endTimeDay, roomBooking.endTimeHour, roomBooking.endTimeMinute);
				var startDate = new Date(roomBooking.startTimeYear, roomBooking.startTimeMonth, roomBooking.startTimeDay, roomBooking.startTimeHour, roomBooking.startTimeMinute);

				var schedulerEvent = new Liferay.SchedulerEvent(
					{
						allDay: roomBooking.allDay,
						roomBookingId: roomBooking.roomBookingId,
						roomId: roomBooking.roomId,
						content: roomBooking.title,
						description: roomBooking.description,
						endDate: endDate.getTime(),
						firstReminder: roomBooking.firstReminder,
						firstReminderType: roomBooking.firstReminderType,
						hasChildRoomBookings: roomBooking.hasChildRoomBookings,
						instanceIndex: roomBooking.instanceIndex,
						location: roomBooking.location,
						parentRoomBookingId: roomBooking.parentRoomBookingId,
						recurrence: roomBooking.recurrence,
						secondReminder: roomBooking.secondReminder,
						secondReminderType: roomBooking.secondReminderType,
						startDate: startDate.getTime(),
						status: roomBooking.status
					}
				);

				return schedulerEvent;
			},

			deleteRoom: function(roomId, callback) {
				var instance = this;

				instance.invokeService(
						{
							'/room-portlet.room/delete-room': {
								roomId: roomId
							}
						},
						{
							success: function() {
								callback(this.get('responseData'));
							}
						}
				);
			},

			deleteEvent: function(schedulerEvent, success) {
				var instance = this;

				instance.invokeService(
					{
						'/room-portlet.roombooking/move-room-booking-to-trash': {
							roomBookingId: schedulerEvent.get('roomBookingId')
						}
					},
					{
						success: function(data) {
							if (success) {
								success.call(instance, data);
							}
						}
					}
				);
			},

			deleteEventInstance: function(schedulerEvent, allFollowing, success) {
				var instance = this;

				instance.invokeService(
					{
						'/room-portlet.roombooking/delete-room-booking-instance': {
							allFollowing: allFollowing,
							roomBookingId: schedulerEvent.get('roomBookingId'),
							startTime: RoomUtil.toUTC(schedulerEvent.get('startDate')).getTime()
						}
					},
					{
						success: function(data) {
							if (success) {
								success.call(instance, data);
							}
						}
					}
				);
			},

			destroyEvent: function(schedulerEvent) {
				var instance = this;

				var scheduler = schedulerEvent.get('scheduler');

				scheduler.removeEvents(schedulerEvent);

				scheduler.syncEventsUI();
			},

			getRoomBookingInvitees: function(roomBookingId, callback) {
				var instance = this;

				instance.invokeResourceURL(
					'roomBookingInvitees',
					{
						parentRoomBookingId: roomBookingId
					},
					callback
				);
			},

			getRoomName: function(name, roomResourceName) {
				var instance = this;

				if (name !== roomResourceName) {
					name = [roomResourceName, STR_DASH, name].join(STR_SPACE);
				}

				return name;
			},

			getRoomRenderingRules: function(roomIds, startDate, endDate, ruleName, callback) {
				var instance = this;

				instance.invokeResourceURL(
					'roomRenderingRules',
					{
						roomIds: roomIds.join(),
						endTime: endDate.getTime(),
						ruleName: ruleName,
						startTime: startDate.getTime()
					},
					callback
				);
			},

			getDatesList: function(startDate, total) {
				var instance = this;

				var ADate = A.Date;

				var output = [];

				if (ADate.isValidDate(startDate)) {
					for (var i = 0; i < total; i++) {
						output.push(ADate.addDays(startDate, i));
					}
				}

				return output;
			},

			getDefaultUserRoom: function() {
				var instance = this;

				return instance.availableRooms[RoomUtil.DEFAULT_USER_CALENDAR_ID];
			},

			getEvent: function(roomBookingId, success, failure) {
				var instance = this;

				instance.invokeService(
					{
						'/room-portlet.roombooking/get-room-booking': {
							roomBookingId: roomBookingId
						}
					},
					{
						failure: failure,
						success: success
					}
				);
			},

			getEvents: function(startDate, endDate, status, callback) {
				var instance = this;

				var roomIds = AObject.keys(instance.availableRooms);

				instance.invokeResourceURL(
					'roomBookings',
					{
						roomIds: roomIds.join(','),
						endTime: endDate.getTime(),
						startTime: startDate.getTime(),
						statuses: status.join(',')
					},
					callback
				);
			},

			getLocalizationMap: function(value) {
				var instance = this;

				var map = {};

				map[themeDisplay.getLanguageId()] = value;

				return A.JSON.stringify(map);
			},

			getResourceRooms: function(roomResourceId, callback) {
				var instance = this;

				instance.invokeResourceURL(
					'resourceRooms',
					{
						roomResourceId: roomResourceId
					},
					callback
				);
			},

			invokeResourceURL: function(resourceId, parameters, callback) {
				var instance = this;

				var url = Liferay.PortletURL.createResourceURL();

				url.setPortletId('1_WAR_roomportlet');
				url.setResourceId(resourceId);

				A.each(
					parameters,
					function(item, index, collection) {
						url.setParameter(index, item);
					}
				);

				A.io.request(
					url.toString(),
					{
						dataType: 'json',
						on: {
							success: function() {
								callback(this.get('responseData'));
							}
						}
					}
				);
			},

			invokeService: function(payload, callback) {
				var instance = this;

				callback = callback || {};

				A.io.request(
					instance.INVOKER_URL,
					{
						cache: false,
						data: {
							cmd: A.JSON.stringify(payload),
							p_auth: Liferay.authToken
						},
						dataType: 'JSON',
						on: {
							failure: callback.failure,
							start: callback.start,
							success: function(event) {
								if (callback.success) {
									var data = this.get('responseData');

									callback.success.apply(this, [data, event]);
								}
							}
						}
					}
				);
			},

			invokeTransition: function(schedulerEvent, status) {
				var instance = this;

				var scheduler = schedulerEvent.get('scheduler');

				instance.invokeService(
					{
						'/room-portlet.roombooking/invoke-transition': {
							roomBookingId: schedulerEvent.get('roomBookingId'),
							status: status,
							userId: USER_ID
						}
					},
					{
						start: function() {
							schedulerEvent.set(
								'loading',
								true,
								{
									silent: true
								}
							);
						},

						success: function(data) {
							schedulerEvent.set(
								'loading',
								false,
								{
									silent: true
								}
							);

							if (data && !data.exception && scheduler) {
								var eventRecorder = scheduler.get('eventRecorder');

								eventRecorder.hidePopover();

								scheduler.load();
							}
						}
					}
				);
			},

			message: function(msg) {
				var instance = this;

				A.oneNS(instance.PORTLET_NAMESPACE, '#message').html(msg);
			},

			setEventAttrs: function(schedulerEvent, data) {
				var instance = this;

				var scheduler = schedulerEvent.get('scheduler');

				var newRoomId = data.roomId;

				var oldRoomId = schedulerEvent.get('roomId');

				if (scheduler) {
					var oldRoom = instance.availableRooms[oldRoomId];
					var newRoom = instance.availableRooms[newRoomId];

					if (oldRoom !== newRoom) {
						oldRoom.remove(schedulerEvent);
					}

					if (newRoom) {
						newRoom.add(schedulerEvent);
					}

					schedulerEvent.setAttrs(
						{
							roomBookingId: data.roomBookingId,
							roomId: newRoomId,
							roomResourceId: data.roomResourceId,
							parentRoomBookingId: data.parentRoomBookingId,
							recurrence: data.recurrence,
							status: data.status
						},
						{
							silent: true
						}
					);

					scheduler.syncEventsUI();
				}
			},

			syncRoomsMap: function(roomLists) {
				var instance = this;

				var visibleRooms = instance.visibleRooms = {};
				var availableRooms = instance.availableRooms = {};

				AArray.each(
					roomLists,
					function(roomList) {
						var rooms = roomList.get('rooms');

						A.each(
							rooms,
							function(item, index) {
								var roomId = item.get('roomId');

								availableRooms[roomId] = item;

								if (item.get('visible')) {
									visibleRooms[roomId] = item;
								}
							}
						);
					}
				);

				return availableRooms;
			},

			toLocalTime: function(utc) {
				var instance = this;

				if (!isDate(utc)) {
					utc = new Date(utc);
				}

				return DateMath.add(utc, DateMath.MINUTES, utc.getTimezoneOffset());
			},

			toUTC: function(date) {
				var instance = this;

				if (!isDate(date)) {
					date = new Date(date);
				}

				return DateMath.subtract(date, DateMath.MINUTES, date.getTimezoneOffset());
			},

			updateEvent: function(schedulerEvent, offset, duration, success) {
				var instance = this;

				instance.invokeService(
					{
						'/room-portlet.roombooking/update-offset-and-duration': {
							allDay: schedulerEvent.get('allDay'),
							roomBookingId: schedulerEvent.get('roomBookingId'),
							roomId: schedulerEvent.get('roomId'),
							descriptionMap: instance.getLocalizationMap(schedulerEvent.get('description')),
							duration: duration,
							firstReminder: schedulerEvent.get('firstReminder'),
							firstReminderType: schedulerEvent.get('firstReminderType'),
							location: schedulerEvent.get('location'),
							offset: offset,
							recurrence: schedulerEvent.get('recurrence'),
							secondReminder: schedulerEvent.get('secondReminder'),
							secondReminderType: schedulerEvent.get('secondReminderType'),
							status: schedulerEvent.get('status'),
							titleMap: instance.getLocalizationMap(LString.unescapeHTML(schedulerEvent.get('content')))
						}
					},
					{
						start: function() {
							schedulerEvent.set(
								'loading',
								true,
								{
									silent: true
								}
							);
						},

						success: function(data) {
							schedulerEvent.set(
								'loading',
								false,
								{
									silent: true
								}
							);

							if (success) {
								success.call(instance, data);
							}
						}
					}
				);
			},

			updateEventInstance: function(schedulerEvent, allFollowing, success) {
				var instance = this;

				var startDate = schedulerEvent.get('startDate');
				var endDate = schedulerEvent.get('endDate');

				instance.invokeService(
					{
						'/room-portlet.roombooking/update-room-booking-instance': {
							allDay: schedulerEvent.get('allDay'),
							allFollowing: allFollowing,
							roomBookingId: schedulerEvent.get('roomBookingId'),
							roomId: schedulerEvent.get('roomId'),
							descriptionMap: instance.getLocalizationMap(schedulerEvent.get('description')),
							endTimeDay: endDate.getDate(),
							endTimeHour: endDate.getHours(),
							endTimeMinute: endDate.getMinutes(),
							endTimeMonth: endDate.getMonth(),
							endTimeYear: endDate.getFullYear(),
							firstReminder: schedulerEvent.get('firstReminder'),
							firstReminderType: schedulerEvent.get('firstReminderType'),
							instanceIndex: schedulerEvent.get('instanceIndex'),
							location: schedulerEvent.get('location'),
							recurrence: schedulerEvent.get('recurrence'),
							secondReminder: schedulerEvent.get('secondReminder'),
							secondReminderType: schedulerEvent.get('secondReminderType'),
							startTimeDay: startDate.getDate(),
							startTimeHour: startDate.getHours(),
							startTimeMinute: startDate.getMinutes(),
							startTimeMonth: startDate.getMonth(),
							startTimeYear: startDate.getFullYear(),
							status: schedulerEvent.get('status'),
							timeZoneId: instance.USER_TIME_ZONE,
							titleMap: instance.getLocalizationMap(LString.unescapeHTML(schedulerEvent.get('content')))
						}
					},
					{
						start: function() {
							schedulerEvent.set(
								'loading',
								true,
								{
									silent: true
								}
							);
						},

						success: function(data) {
							schedulerEvent.set(
								'loading',
								false,
								{
									silent: true
								}
							);

							if (success) {
								success.call(instance, data);
							}
						}
					}
				);
			}
		};

		Liferay.RoomUtil = RoomUtil;

		var RoomWorkflow = {
			STATUS_MAYBE: 9
		};

		A.mix(RoomWorkflow, Workflow);

		Liferay.RoomWorkflow = RoomWorkflow;

		var SchedulerModelSync = function(config) {};

		SchedulerModelSync.prototype = {
			sync: function(action, options, callback) {
				var instance = this;

				var actionMethod = instance['_do' + toInitialCap(action)];

				if (isFunction(actionMethod)) {
					actionMethod.apply(instance, [options, callback]);
				}
			},

			_doRead: function() {
				var instance = this;

				var args = arguments;

				var callback = args[args.length - 1];

				if (isFunction(callback)) {
					callback();
				}
			}
		};

		Liferay.SchedulerModelSync = SchedulerModelSync;

		var SchedulerEvent = A.Component.create(
			{
				ATTRS: {
					roomBookingId: {
						setter: toInt,
						value: 0
					},

					roomId: {
						setter: toInt,
						value: 0
					},

					content: {
						getter: function(val) {
							if (val) {
								val = LString.escapeHTML(val);
							}

							return val;
						}
					},

					description: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					editingEvent: {
						validator: isBoolean,
						value: false
					},

					firstReminder: {
						setter: toInt,
						value: 0
					},

					firstReminderType: {
						setter: String,
						validator: isValue,
						value: RoomUtil.NOTIFICATION_DEFAULT_TYPE
					},

					hasChildRoomBookings: {
						validator: isBoolean,
						value: false
					},

					instanceIndex: {
						setter: toInt,
						value: 0
					},

					loading: {
						validator: isBoolean,
						value: false
					},

					location: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					parentRoomBookingId: {
						setter: toInt,
						value: 0
					},

					recurrence: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					reminder: {
						getter: function() {
							var instance = this;

							return (instance.get('firstReminder') > 0) || (instance.get('secondReminder') > 0);
						}
					},

					repeated: {
						getter: 'isRecurring'
					},

					secondReminder: {
						setter: toInt,
						value: 0
					},

					secondReminderType: {
						setter: String,
						validator: isValue,
						value: RoomUtil.NOTIFICATION_DEFAULT_TYPE
					},

					status: {
						setter: toInt,
						value: 0
					}
				},

				EXTENDS: A.SchedulerEvent,

				NAME: 'scheduler-event',

				PROPAGATE_ATTRS: A.SchedulerEvent.PROPAGATE_ATTRS.concat(['roomBookingId', 'roomId', 'roomResourceId', 'parentRoomBookingId', 'recurrence', 'status']),

				prototype: {
					eventModel: Liferay.SchedulerEvent,

					initializer: function() {
						var instance = this;

						instance._uiSetLoading(instance.get('loading'));
						instance._uiSetStartDate(instance.get('startDate'));
						instance._uiSetStatus(instance.get('status'));

						instance.on('loadingChange', instance._onLoadingChange);
						instance.on('startDateChange', instance._onStartDateChange);
						instance.on('statusChange', instance._onStatusChange);
					},

					isMasterBooking: function() {
						var instance = this;

						return (instance.get('parentRoomBookingId') === instance.get('roomBookingId'));
					},

					isRecurring: function() {
						var instance = this;

						return (instance.get('recurrence') !== STR_BLANK);
					},

					syncNodeColorUI: function() {
						var instance = this;

						Liferay.SchedulerEvent.superclass.syncNodeColorUI.apply(instance, arguments);

						var node = instance.get('node');
						var scheduler = instance.get('scheduler');

						if (scheduler && !instance.get('editingEvent')) {
							var activeViewName = scheduler.get('activeView').get('name');

							if ((activeViewName === 'month') && !instance.get('allDay')) {
								node.setStyles(
									{
										backgroundColor: instance.get('color'),
										border: 'none',
										color: '#111',
										padding: '0 2px'
									}
								);
							}
						}
					},

					syncUI: function() {
						var instance = this;

						Liferay.SchedulerEvent.superclass.syncUI.apply(instance, arguments);

						instance._uiSetStatus(instance.get('status'));
					},

					_onLoadingChange: function(event) {
						var instance = this;

						instance._uiSetLoading(event.newVal);
					},

					_onStartDateChange: function(event) {
						var instance = this;

						instance._uiSetStartDate(event.newVal);
					},

					_onStatusChange: function(event) {
						var instance = this;

						instance._uiSetStatus(event.newVal);
					},

					_uiSetEndDate: function(val) {
						var instance = this;

						Liferay.SchedulerEvent.superclass._uiSetEndDate.apply(instance, arguments);

						var node = instance.get('node');

						node.attr('data-endDate', instance._formatDate(val, '%m/%d/%Y'));
						node.attr('data-endTime', instance._formatDate(val, '%I:%M %p'));
					},

					_uiSetLoading: function(val) {
						var instance = this;

						instance.get('node').toggleClass('room-portlet-event-loading', val);
					},

					_uiSetStartDate: function(val) {
						var instance = this;

						var node = instance.get('node');

						node.attr('data-startDate', instance._formatDate(val, '%m/%d/%Y'));
						node.attr('data-startTime', instance._formatDate(val, '%I:%M %p'));
					},

					_uiSetStatus: function(val) {
						var instance = this;

						var node = instance.get('node');

						node.toggleClass('room-portlet-event-approved', (val === RoomWorkflow.STATUS_APPROVED));
						node.toggleClass('room-portlet-event-maybe', (val === RoomWorkflow.STATUS_MAYBE));
						node.toggleClass('room-portlet-event-pending', (val === RoomWorkflow.STATUS_PENDING));
					}
				}
			}
		);

		Liferay.SchedulerEvent = SchedulerEvent;

		var Room = A.Component.create(
			{
				ATTRS: {
					roomId: {
						setter: toInt,
						value: 0
					},

					roomResourceId: {
						setter: toInt,
						value: 0
					},

					roomResourceName: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					classNameId: {
						setter: toInt,
						value: 0
					},

					classPK: {
						setter: toInt,
						value: 0
					},

					defaultRoom: {
						setter: A.DataType.Boolean.parse,
						value: false
					},

					groupId: {
						setter: toInt,
						value: 0
					},

					permissions: {
						lazyAdd: false,
						setter: function(val) {
							var instance = this;

							instance.set('disabled', !val.MANAGE_BOOKINGS);

							return val;
						},
						validator: isObject,
						value: {}
					}
				},

				EXTENDS: A.SchedulerCalendar,

				NAME: 'scheduler-room',

				prototype: {
					getDisplayName: function() {
						var instance = this;

						var roomResourceName = instance.get('roomResourceName');
						var name = instance.get('name');

						return RoomUtil.getRoomName(name, roomResourceName);
					},

					_afterColorChange: function(event) {
						var instance = this;

						Room.superclass._afterColorChange.apply(instance, arguments);

						var roomId = instance.get('roomId');

						var color = event.newVal;

						if (instance.get('permissions.UPDATE')) {
							RoomUtil.invokeService(
								{
									'/room-portlet.room/update-color': {
										roomId: roomId,
										color: parseInt(color.substr(1), 16)
									}
								}
							);
						}
						else {
							Liferay.Store('room-portlet-room-' + roomId + '-color', color);
						}
					},

					_afterVisibleChange: function(event) {
						var instance = this;

						Room.superclass._afterVisibleChange.apply(instance, arguments);

						var scheduler = instance.get('scheduler');

						scheduler.syncEventsUI();
					}
				}
			}
		);

		Liferay.SchedulerRoom = Room;

		Liferay.SchedulerEvents = A.Base.create(
			'scheduler-events',
			A.SchedulerEvents,
			[Liferay.SchedulerModelSync],
			{
				getLoadEndDate: function(activeView) {
					var instance = this;

					var date = activeView.getNextDate();

					var viewName = activeView.get('name');

					if (viewName === 'agenda') {
						date = DateMath.add(date, DateMath.MONTH, 1);
					}
					else if (viewName === 'month') {
						date = DateMath.add(date, DateMath.WEEK, 1);
					}

					return RoomUtil.toUTC(date);
				},

				getLoadStartDate: function(activeView) {
					var instance = this;

					var scheduler = activeView.get('scheduler');
					var viewName = activeView.get('name');

					var date = scheduler.get('viewDate');

					if (viewName === 'month') {
						date = DateMath.subtract(date, DateMath.WEEK, 1);
					}

					return RoomUtil.toUTC(date);
				},

				_doRead: function(options, callback) {
					var instance = this;

					var scheduler = instance.get('scheduler');

					var activeView = scheduler.get('activeView');
					var filterRoomBookings = scheduler.get('filterRoomBookings');

					RoomUtil.message(Liferay.Language.get('loading'));

					RoomUtil.getEvents(
						instance.getLoadStartDate(activeView),
						instance.getLoadEndDate(activeView),
						[RoomWorkflow.STATUS_APPROVED, RoomWorkflow.STATUS_MAYBE, RoomWorkflow.STATUS_PENDING],
						function(roomBookings) {
							if (filterRoomBookings) {
								roomBookings = AArray.filter(roomBookings, filterRoomBookings);
							}

							callback(null, roomBookings);
						}
					);
				}
			},
			{}
		);

		var Scheduler = A.Component.create(
			{
				ATTRS: {
					filterRoomBookings: {
						validator: isFunction
					},

					iconAddEventNode: {
						valueFn: function() {
							return A.Node.create(TPL_ICON_ADD_EVENT_NODE);
						}
					},

					portletNamespace: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					preventPersistence: {
						validator: isBoolean,
						value: false
					},

					showAddRoomBookingBtn: {
						validator: isBoolean,
						value: true
					}
				},

				EXTENDS: A.Scheduler,

				NAME: 'scheduler-base',

				prototype: {
					roomModel: Liferay.SchedulerRoom,
					eventModel: Liferay.SchedulerEvent,
					eventsModel: Liferay.SchedulerEvents,
					queue: null,

					renderUI: function() {
						var instance = this;

						Scheduler.superclass.renderUI.apply(this, arguments);

						var showAddRoomBookingBtn = instance.get('showAddRoomBookingBtn');
						console.log(showAddRoomBookingBtn);

						if (showAddRoomBookingBtn) {
							instance[ICON_ADD_EVENT_NODE] = instance.get(ICON_ADD_EVENT_NODE);

							instance[CONTROLS_NODE].prepend(instance[ICON_ADD_EVENT_NODE]);

							instance[ICON_ADD_EVENT_NODE].on('click', instance._onClickAddEvent, instance);
						}
					},

					bindUI: function() {
						var instance = this;

						instance.after(
							{
								'scheduler-base:dateChange': instance._afterDateChange,
								'scheduler-event:change': instance._afterSchedulerEventChange
							}
						);

						instance.on(
							{
								'*:load': instance._onLoadSchedulerEvents,
								'scheduler-event-recorder:delete': instance._onDeleteEvent,
								'scheduler-event-recorder:save': instance._onSaveEvent
							}
						);

						Scheduler.superclass.bindUI.apply(this, arguments);
					},

					load: function() {
						var instance = this;

						var events = instance._events;

						return events.load.apply(events, arguments);
					},

					plotRoomBookings: function(roomBookings) {
						var instance = this;

						var events = [];
						var roomEvents = {};

						AArray.each(
							roomBookings,
							function(item, index) {
								var roomId = item.roomId;

								if (!roomEvents[roomId]) {
									roomEvents[roomId] = [];
								}

								var schedulerEvent = RoomUtil.createSchedulerEvent(item);

								schedulerEvent.set(
									'scheduler',
									instance,
									{
										silent: true
									}
								);

								events.push(schedulerEvent);
								roomEvents[roomId].push(schedulerEvent);
							}
						);

						instance.resetEvents(events);

						A.each(
							Liferay.RoomUtil.availableRooms,
							function(item, index) {
								item.reset(roomEvents[index]);
							}
						);

						if (instance.get('rendered')) {
							instance.syncEventsUI();
						}

						RoomUtil.message(STR_BLANK);
					},

					sync: function() {
						var instance = this;

						var events = instance._events;

						return events.sync.apply(events, arguments);
					},

					_afterActiveViewChange: function(event) {
						var instance = this;

						Scheduler.superclass._afterActiveViewChange.apply(this, arguments);

						Liferay.Store('room-portlet-default-view', event.newVal.get('name'));

						instance.load();
					},

					_afterDateChange: function(event) {
						var instance = this;

						instance.load();
					},

					_afterSchedulerEventChange: function(event) {
						var instance = this;

						if (!instance.get('preventPersistence')) {
							var changedAttributes = event.changed;

							var persistentAttrMap = {
								roomId: 1,
								color: 1,
								content: 1,
								endDate: 1,
								endTime: 1,
								startDate: 1,
								startTime: 1
							};

							var persist = true;

							A.each(
								changedAttributes,
								function(item, index) {
									persist = AObject.owns(persistentAttrMap, index);
								}
							);

							if (persist) {
								var schedulerEvent = event.target;

								instance._updateSchedulerEvent(schedulerEvent, changedAttributes);
							}
						}
					},

					_createViewTriggerNode: function(view, tpl) {
						var instance = this;

						var node = Scheduler.superclass._createViewTriggerNode.apply(this, arguments);

						var schedulerViewText = '';

						var viewName = view.get('name');

						if (viewName == 'agenda') {
							schedulerViewText = Liferay.Language.get('agenda-view');
						}
						else if (viewName == 'day') {
							schedulerViewText = Liferay.Language.get('day-view');
						}
						else if (viewName == 'month') {
							schedulerViewText = Liferay.Language.get('month-view');
						}
						else if (viewName == 'week') {
							schedulerViewText = Liferay.Language.get('week-view');
						}

						if (node.get('nodeName') === 'OPTION') {
							node.text(schedulerViewText);
						}

						return node;
					},

					_getRoomBookingDuration: function(schedulerEvent) {
						var instance = this;

						var duration = schedulerEvent.getSecondsDuration() * Time.SECOND;

						return duration;
					},

					_getRoomBookingOffset: function(schedulerEvent, changedAttributes) {
						var instance = this;

						var offset = 0;

						if (changedAttributes.startDate) {
							offset = changedAttributes.startDate.newVal.getTime() - changedAttributes.startDate.prevVal.getTime();
						}

						return offset;
					},

					_onClickAddEvent: function(event) {
						var instance = this;

						var recorder = instance.get('eventRecorder');

						var activeViewName = instance.get('activeView').get('name');

						var defaultUserRoom = RoomUtil.getDefaultUserRoom();

						var roomId = defaultUserRoom.get('roomId');

						var editRoomBookingURL = decodeURIComponent(recorder.get('editRoomBookingURL'));

						Liferay.Util.openWindow(
							{
								dialog: {
									after: {
										destroy: function(event) {
											instance.load();
										}
									},
									destroyOnHide: true,
									modal: true
								},
								title: Liferay.Language.get('new-room-booking'),
								uri: Lang.sub(
									editRoomBookingURL,
									{
										activeView: activeViewName,
										roomId: roomId,
										titleCurrentValue: ''
									}
								)
							}
						);
					},

					_onDeleteEvent: function(event) {
						var instance = this;

						var schedulerEvent = event.schedulerEvent;

						var success = function() {
							instance.load();
							instance.get('eventRecorder').hidePopover();
						};

						if (schedulerEvent.isRecurring()) {
							RecurrenceUtil.openConfirmationPanel(
								'delete',
								function() {
									RoomUtil.deleteEventInstance(schedulerEvent, false, success);
								},
								function() {
									RoomUtil.deleteEventInstance(schedulerEvent, true, success);
								},
								function() {
									RoomUtil.deleteEvent(schedulerEvent, success);
								}
							);
						}
						else if (schedulerEvent.isMasterBooking() && confirm(Liferay.Language.get('deleting-this-event-will-cancel-the-meeting-with-your-guests-would-you-like-to-delete'))) {
							RoomUtil.deleteEvent(schedulerEvent, success);
						}

						event.preventDefault();
					},

					_onLoadSchedulerEvents: function(event) {
						var instance = this;

						instance.plotRoomBookings(event.parsed);
					},

					_onSaveEvent: function(event) {
						var instance = this;

						RoomUtil.addEvent(
							event.newSchedulerEvent,
							function() {
								instance.load();
								instance.get('eventRecorder').hidePopover();
							}
						);
					},

					_queueableQuestionResolver: function(data) {
						var instance = this;

						var answers = data.answers;
						var duration = data.duration;
						var offset = data.offset;
						var schedulerEvent = data.schedulerEvent;

						var showNextQuestion = A.bind(instance.load, instance);

						if (answers.cancel) {
							A.soon(showNextQuestion);
						}
						else if (answers.updateInstance) {
							RoomUtil.updateEventInstance(schedulerEvent, !!answers.allFollowing, showNextQuestion);
						}
						else {
							RoomUtil.updateEvent(schedulerEvent, offset, duration, showNextQuestion);
						}
					},

					_updateSchedulerEvent: function(schedulerEvent, changedAttributes) {
						var instance = this;

						var room = Liferay.RoomUtil.availableRooms[schedulerEvent.get('roomId')];

						Liferay.RoomMessageUtil.promptSchedulerEventUpdate(
							{
								roomName: room.get('name'),
								duration: instance._getRoomBookingDuration(schedulerEvent),
								hasChild: schedulerEvent.get('hasChildRoomBookings'),
								masterBooking: schedulerEvent.isMasterBooking(),
								offset: instance._getRoomBookingOffset(schedulerEvent, changedAttributes),
								recurring: schedulerEvent.isRecurring(),
								resolver: A.bind(instance._queueableQuestionResolver, instance),
								schedulerEvent: schedulerEvent
							}
						);
					}
				}
			}
		);

		Liferay.Scheduler = Scheduler;

		var SchedulerEventRecorder = A.Component.create(
			{
				ATTRS: {
					roomId: {
						setter: toInt,
						value: 0
					},

					editRoomBookingURL: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					permissionsRoomBookingURL: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					portletNamespace: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					},

					status: {
						setter: toInt,
						value: RoomWorkflow.STATUS_DRAFT
					},

					toolbar: {
						value: {
							children: []
						}
					},

					viewRoomBookingURL: {
						setter: String,
						validator: isValue,
						value: STR_BLANK
					}
				},

				EXTENDS: A.SchedulerEventRecorder,

				NAME: 'scheduler-event-recorder',

				prototype: {
					initializer: function() {
						var instance = this;

						var popoverBB = instance.popover.get('boundingBox');

						popoverBB.delegate('click', instance._handleEventAnswer, '.room-event-answer', instance);
					},

					getTemplateData: function() {
						var instance = this;

						var editing = true;

						var schedulerEvent = instance.get('event');

						if (!schedulerEvent) {
							editing = false;

							schedulerEvent = instance;
						}

						var availableRooms = RoomUtil.availableRooms;
						
						console.log(schedulerEvent.get('roomId'));
						//var room = availableRooms[schedulerEvent.get('roomId')];

						//var permissions = room.get('permissions');

						var templateData = SchedulerEventRecorder.superclass.getTemplateData.apply(this, arguments);

						return A.merge(
							templateData,
							{
								acceptLinkEnabled: instance._hasWorkflowStatusPermission(schedulerEvent, RoomWorkflow.STATUS_APPROVED),
								allDay: schedulerEvent.get('allDay'),
								availableRooms: availableRooms,
								//room: room,
								roomIds: AObject.keys(availableRooms),
								declineLinkEnabled: instance._hasWorkflowStatusPermission(schedulerEvent, RoomWorkflow.STATUS_DENIED),
								editing: editing,
								endTime: templateData.endDate,
								instanceIndex: schedulerEvent.get('instanceIndex'),
								maybeLinkEnabled: instance._hasWorkflowStatusPermission(schedulerEvent, RoomWorkflow.STATUS_MAYBE),
								//permissions: permissions,
								startTime: templateData.startDate,
								status: schedulerEvent.get('status'),
								workflowStatus: RoomWorkflow
							}
						);
					},

					getUpdatedSchedulerEvent: function(optAttrMap) {
						var instance = this;

						var	attrMap = {
							color: instance.get('color')
						};

						return SchedulerEventRecorder.superclass.getUpdatedSchedulerEvent.call(instance, A.merge(attrMap, optAttrMap));
					},

					isMasterBooking: Lang.emptyFnFalse,

					populateForm: function() {
						var instance = this;

						var bodyTemplate = instance.get('bodyTemplate');

						var headerTemplate = instance.get('headerTemplate');

						var templateData = instance.getTemplateData();

						if (A.instanceOf(bodyTemplate, A.Template) && A.instanceOf(headerTemplate, A.Template)) {
							instance.popover.setStdModContent('body', bodyTemplate.parse(templateData));
							instance.popover.setStdModContent('header', headerTemplate.parse(templateData));

							instance.popover.addToolbar(instance._getFooterToolbar(), 'footer');
						}
						else {
							SchedulerEventRecorder.superclass.populateForm.apply(instance, arguments);
						}

						instance.popover.addToolbar(
							[
								{
									cssClass: 'close',
									label: '\u00D7',
									on: {
										click: A.bind(instance._handleCancelEvent, instance)
									},
									render: true
								}
							],
							'header'
						);

						//instance.popover.headerNode.toggleClass('hide', !templateData.permissions.VIEW_BOOKING_DETAILS);
						instance.popover.headerNode.toggleClass('hide', false);
						
						instance._showResources();
					},

					_getFooterToolbar: function() {
						var instance = this;

						var schedulerEvent = instance.get('event');

						var schedulerEventCreated = false;

						if (schedulerEvent) {
							schedulerEventCreated = true;
						}
						else {
							schedulerEvent = instance;
						}

						var children = [];
						var editGroup = [];
						var respondGroup = [];

						var status = schedulerEvent.get('status');
						var room = RoomUtil.availableRooms[schedulerEvent.get('roomId')];

						if (room) {
							var permissions = room.get('permissions');

							if (instance._hasSaveButton(permissions, room, status)) {
								editGroup.push(
									{
										icon: 'icon-hdd',
										id: 'saveBtn',
										label: Liferay.Language.get('save'),
										on: {
											click: A.bind(instance._handleSaveEvent, instance)
										},
										primary: true
									}
								);
							}

							if (instance._hasEditButton(permissions, room, status)) {
								editGroup.push(
									{
										icon: 'icon-edit',
										id: 'editBtn',
										label: Liferay.Language.get('edit'),
										on: {
											click: A.bind(instance._handleEditEvent, instance)
										}
									}
								);
							}

							if ((schedulerEventCreated === true) && permissions.VIEW_BOOKING_DETAILS) {
								editGroup.push(
									{
										icon: 'icon-eye-open',
										id: 'viewBtn',
										label: Liferay.Language.get('view-details'),
										on: {
											click: A.bind(instance._handleViewEvent, instance)
										}
									}
								);
							}

							if (schedulerEvent.isMasterBooking() && instance._hasDeleteButton(permissions, room, status)) {
								editGroup.push(
									{
										icon: 'icon-trash',
										id: 'deleteBtn',
										label: Liferay.Language.get('delete'),
										on: {
											click: A.bind(instance._handleDeleteEvent, instance)
										}
									}
								);
							}

							if (editGroup.length) {
								children.push(editGroup);
							}

							if (respondGroup.length) {
								children.push(respondGroup);
							}
						}

						return children;
					},

					_handleEditEvent: function(event) {
						var instance = this;

						var scheduler = instance.get('scheduler');

						var activeViewName = scheduler.get('activeView').get('name');

						var date = scheduler.get('date');

						var schedulerEvent = instance.get('event');

						var editRoomBookingURL = decodeURIComponent(instance.get('editRoomBookingURL'));

						var data = instance.serializeForm();

						data.activeView = activeViewName;

						data.date = date.getTime();

						var endTime = new Date(data.endTime);

						data.endTimeDay = endTime.getDate();
						data.endTimeHour = endTime.getHours();
						data.endTimeMinute = endTime.getMinutes();
						data.endTimeMonth = endTime.getMonth();
						data.endTimeYear = endTime.getFullYear();

						var startTime = new Date(data.startTime);

						data.startTimeDay = startTime.getDate();
						data.startTimeHour = startTime.getHours();
						data.startTimeMinute = startTime.getMinutes();
						data.startTimeMonth = startTime.getMonth();
						data.startTimeYear = startTime.getFullYear();

						data.titleCurrentValue = encodeURIComponent(data.content);

						if (schedulerEvent) {
							data.allDay = schedulerEvent.get('allDay');
							data.roomBookingId = schedulerEvent.get('roomBookingId');
						}

						Liferay.Util.openWindow(
							{
								dialog: {
									after: {
										destroy: function(event) {
											scheduler.load();
										}
									},
									destroyOnHide: true,
									modal: true
								},
								refreshWindow: window,
								title: Liferay.Language.get('edit-room-booking'),
								uri: Lang.sub(editRoomBookingURL, data)
							}
						);

						instance.hidePopover();
					},

					_handleEventAnswer: function(event) {
						var instance = this;

						var currentTarget = event.currentTarget;

						var schedulerEvent = instance.get('event');

						var linkEnabled = A.DataType.Boolean.parse(currentTarget.hasClass('room-event-answer-true'));

						var statusData = Lang.toInt(currentTarget.getData('status'));

						if (schedulerEvent && linkEnabled) {
							RoomUtil.invokeTransition(schedulerEvent, statusData);
						}
					},

					_handleViewEvent: function(event) {
						var instance = this;

						var scheduler = instance.get('scheduler');

						var viewRoomBookingURL = decodeURIComponent(instance.get('viewRoomBookingURL'));

						var data = instance.serializeForm();

						var schedulerEvent = instance.get('event');

						data.roomBookingId = schedulerEvent.get('roomBookingId');

						Liferay.Util.openWindow(
							{
								dialog: {
									after: {
										destroy: function(event) {
											scheduler.load();
										}
									},
									destroyOnHide: true,
									modal: true
								},
								refreshWindow: window,
								title: Liferay.Language.get('view-room-booking-details'),
								uri: Lang.sub(viewRoomBookingURL, data)
							}
						);

						event.domEvent.preventDefault();
					},

					_hasDeleteButton: function(permissions, room, status) {
						return permissions.MANAGE_BOOKINGS && room;
					},

					_hasEditButton: function(permissions, room, status) {
						return permissions.MANAGE_BOOKINGS;
					},

					_hasSaveButton: function(permissions, room, status) {
						return permissions.MANAGE_BOOKINGS;
					},

					_hasWorkflowStatusPermission: function(schedulerEvent, newStatus) {
						var instance = this;

						var hasPermission = false;

						if (schedulerEvent) {
							var roomId = schedulerEvent.get('roomId');

							var room = RoomUtil.availableRooms[roomId];

							//var permissions = room.get('permissions');

							var status = schedulerEvent.get('status');

							//hasPermission = permissions.MANAGE_BOOKINGS && (status !== newStatus) && (status !== RoomWorkflow.STATUS_DRAFT);
							hasPermission = true;
						}

						return hasPermission;
					},

					_renderPopOver: function() {
						var instance = this;

						var popoverBB = instance.popover.get('boundingBox');

						SchedulerEventRecorder.superclass._renderPopOver.apply(this, arguments);

						popoverBB.delegate(
							['change', 'keypress'],
							function(event) {
								var schedulerEvent = instance.get('event') || instance;

								var roomId = toInt(event.currentTarget.val());

								var selectedRoom = RoomUtil.availableRooms[roomId];

								if (selectedRoom) {
									schedulerEvent.set(
										'color',
										selectedRoom.get('color'),
										{
											silent: true
										}
									);
								}
							},
							'#' + instance.get('portletNamespace') + 'eventRecorderRoom'
						);
					},

					_showResources: function() {
						var instance = this;

						var schedulerEvent = instance.get('event');

						var popoverBB = instance.popover.get('boundingBox');

						popoverBB.toggleClass('room-portlet-event-recorder-editing', !!schedulerEvent);

						var defaultUserRoom = RoomUtil.getDefaultUserRoom();

						var roomId = defaultUserRoom.get('roomId');
						var color = defaultUserRoom.get('color');

						var eventInstance = instance;

						if (schedulerEvent) {
							roomId = schedulerEvent.get('roomId');

							var room = RoomUtil.availableRooms[roomId];

							if (room) {
								color = room.get('color');

								eventInstance = schedulerEvent;
							}
						}

						eventInstance.set(
							'color',
							color,
							{
								silent: true
							}
						);

						var portletNamespace = instance.get('portletNamespace');

						var eventRecorderRoom = A.one('#' + portletNamespace + 'eventRecorderRoom');

						if (eventRecorderRoom) {
							eventRecorderRoom.val(roomId.toString());
						}

						instance._syncInvitees();
					},

					_syncInvitees: function() {
						var instance = this;

						var schedulerEvent = instance.get('event');

						if (schedulerEvent) {
							var room = RoomUtil.availableRooms[schedulerEvent.get('roomId')];

							if (room) {
								var permissions = room.get('permissions');

								if (permissions.VIEW_BOOKING_DETAILS) {
									var parentRoomBookingId = schedulerEvent.get('parentRoomBookingId');
									var portletNamespace = instance.get('portletNamespace');

									RoomUtil.getRoomBookingInvitees(
										parentRoomBookingId,
										function(data) {
											var results = AArray.partition(
													data,
													function(item) {
														return item.classNameId === RoomUtil.USER_CLASS_NAME_ID;
													}
											);

											instance._syncInviteesContent('#' + portletNamespace + 'eventRecorderUsers', results.matches);
											instance._syncInviteesContent('#' + portletNamespace + 'eventRecorderResources', results.rejects);
										}
									);
								}
							}
						}
					},

					_syncInviteesContent: function(contentNode, roomResources) {
						var instance = this;
						
						var values = AArray.map(
							roomResources,
							function(item) {
								return item.name;
							}
						);

						contentNode = A.one(contentNode);

						var messageNode = contentNode.one('.room-portlet-invitees');

						var messageHTML = '&mdash;';

						if (values.length > 0) {
							contentNode.show();

							messageHTML = values.join(STR_COMMA_SPACE);
						}

						messageNode.html(messageHTML);
					}
				}
			}
		);

		Liferay.SchedulerEventRecorder = SchedulerEventRecorder;
	},
	'',
	{
		requires: ['async-queue', 'aui-datatype', 'aui-io', 'aui-scheduler', 'aui-toolbar', 'autocomplete', 'autocomplete-highlighters', 'dd-plugin', 'liferay-room-message-util', 'liferay-room-recurrence-util', 'liferay-node', 'liferay-portlet-url', 'liferay-store', 'promise', 'resize-plugin']
	}
);