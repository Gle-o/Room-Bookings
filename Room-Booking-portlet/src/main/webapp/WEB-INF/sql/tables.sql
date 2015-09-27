create table RoomBooking_Equipment (
	uuid_ VARCHAR(75) null,
	equipmentId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	reference VARCHAR(75) null,
	equipmentTypeId LONG,
	roomId LONG
);

create table RoomBooking_EquipmentType (
	uuid_ VARCHAR(75) null,
	equipmentTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null
);

create table RoomBooking_Room (
	uuid_ VARCHAR(75) null,
	roomId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	capacity INTEGER,
	level INTEGER
);

create table RoomBooking_RoomBooking (
	uuid_ VARCHAR(75) null,
	roomBookingId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	userName VARCHAR(75) null,
	roomId LONG,
	vEventUid VARCHAR(75) null,
	title STRING null,
	description STRING null,
	startTime LONG,
	endTime LONG,
	allDay BOOLEAN,
	recurrence VARCHAR(75) null,
	firstReminder LONG,
	firstReminderType VARCHAR(75) null,
	secondReminder LONG,
	secondReminderType VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);