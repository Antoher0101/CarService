alter table CARSERVICE_CAR_SERVICE add constraint FK_CARSERVICE_CAR_SERVICE_ON_CITY foreign key (CITY_ID) references CARSERVICE_CITY(ID);
create index IDX_CARSERVICE_CAR_SERVICE_ON_CITY on CARSERVICE_CAR_SERVICE (CITY_ID);
