alter table CARSERVICE_REPAIR add constraint FK_CARSERVICE_REPAIR_ON_CAR_SERVICE foreign key (CAR_SERVICE_ID) references CARSERVICE_CAR_SERVICE(ID);
create index IDX_CARSERVICE_REPAIR_ON_CAR_SERVICE on CARSERVICE_REPAIR (CAR_SERVICE_ID);
