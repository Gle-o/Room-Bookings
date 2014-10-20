create index IX_7B627481 on RoomBooking_Equipment (uuid_);
create index IX_304B6507 on RoomBooking_Equipment (uuid_, companyId);

create index IX_88CCB4E7 on RoomBooking_EquipmentType (uuid_);
create index IX_F6C108E1 on RoomBooking_EquipmentType (uuid_, companyId);

create index IX_1AFC90F2 on RoomBooking_Room (uuid_);
create index IX_7FF1C7F6 on RoomBooking_Room (uuid_, companyId);

create index IX_7479B0D1 on RoomBooking_RoomBooking (uuid_);
create index IX_7D1A56B7 on RoomBooking_RoomBooking (uuid_, companyId);
create unique index IX_13E71EF9 on RoomBooking_RoomBooking (uuid_, groupId);