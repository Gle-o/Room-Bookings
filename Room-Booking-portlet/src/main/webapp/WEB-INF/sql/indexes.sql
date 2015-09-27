create index IX_31572420 on RoomBooking_Equipment (equipmentTypeId);
create index IX_349C4037 on RoomBooking_Equipment (groupId);
create index IX_F24D8A3C on RoomBooking_Equipment (groupId, equipmentTypeId);
create index IX_28787386 on RoomBooking_Equipment (groupId, equipmentTypeId, roomId);
create index IX_8695F41D on RoomBooking_Equipment (roomId);
create index IX_4DA15F16 on RoomBooking_Equipment (roomId, equipmentTypeId);
create index IX_7B627481 on RoomBooking_Equipment (uuid_);
create index IX_304B6507 on RoomBooking_Equipment (uuid_, companyId);
create unique index IX_35A78149 on RoomBooking_Equipment (uuid_, groupId);

create index IX_9077FF1D on RoomBooking_EquipmentType (groupId);
create index IX_88CCB4E7 on RoomBooking_EquipmentType (uuid_);
create index IX_F6C108E1 on RoomBooking_EquipmentType (uuid_, companyId);
create unique index IX_510853A3 on RoomBooking_EquipmentType (uuid_, groupId);

create index IX_56210468 on RoomBooking_Room (groupId);
create index IX_1AFC90F2 on RoomBooking_Room (uuid_);
create index IX_7FF1C7F6 on RoomBooking_Room (uuid_, companyId);
create unique index IX_6017D3F8 on RoomBooking_Room (uuid_, groupId);

create index IX_7479B0D1 on RoomBooking_RoomBooking (uuid_);
create index IX_7D1A56B7 on RoomBooking_RoomBooking (uuid_, companyId);
create unique index IX_13E71EF9 on RoomBooking_RoomBooking (uuid_, groupId);