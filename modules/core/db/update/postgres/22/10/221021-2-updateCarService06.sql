alter table CARSERVICE_CAR_SERVICE add constraint FK_CARSERVICE_CAR_SERVICE_ON_REPAIR foreign key (REPAIR_ID) references CARSERVICE_REPAIR(ID);
create index IDX_CARSERVICE_CAR_SERVICE_ON_REPAIR on CARSERVICE_CAR_SERVICE (REPAIR_ID);
