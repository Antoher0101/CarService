-- begin CARSERVICE_CAR_SERVICE
alter table CARSERVICE_CAR_SERVICE add constraint FK_CARSERVICE_CAR_SERVICE_ON_CITY foreign key (CITY_ID) references CARSERVICE_CITY(ID)^
create index IDX_CARSERVICE_CAR_SERVICE_ON_CITY on CARSERVICE_CAR_SERVICE (CITY_ID)^
-- end CARSERVICE_CAR_SERVICE
-- begin CARSERVICE_EMPLOYEE
alter table CARSERVICE_EMPLOYEE add constraint FK_CARSERVICE_EMPLOYEE_ON_CAR_SERVICE foreign key (CAR_SERVICE_ID) references CARSERVICE_CAR_SERVICE(ID)^
create index IDX_CARSERVICE_EMPLOYEE_ON_CAR_SERVICE on CARSERVICE_EMPLOYEE (CAR_SERVICE_ID)^
-- end CARSERVICE_EMPLOYEE
-- begin CARSERVICE_REPAIR
alter table CARSERVICE_REPAIR add constraint FK_CARSERVICE_REPAIR_ON_CAR_SERVICE foreign key (CAR_SERVICE_ID) references CARSERVICE_CAR_SERVICE(ID)^
alter table CARSERVICE_REPAIR add constraint FK_CARSERVICE_REPAIR_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references CARSERVICE_EMPLOYEE(ID)^
create index IDX_CARSERVICE_REPAIR_ON_CAR_SERVICE on CARSERVICE_REPAIR (CAR_SERVICE_ID)^
create index IDX_CARSERVICE_REPAIR_ON_EMPLOYEE on CARSERVICE_REPAIR (EMPLOYEE_ID)^
-- end CARSERVICE_REPAIR

-- begin CARSERVICE_LEGAL
alter table CARSERVICE_LEGAL add constraint FK_CARSERVICE_LEGAL_ON_ID foreign key (ID) references CARSERVICE_COUNTERPARTY(ID) on delete CASCADE^
-- end CARSERVICE_LEGAL
-- begin CARSERVICE_INDIVIDUAL
alter table CARSERVICE_INDIVIDUAL add constraint FK_CARSERVICE_INDIVIDUAL_ON_ID foreign key (ID) references CARSERVICE_COUNTERPARTY(ID) on delete CASCADE^
-- end CARSERVICE_INDIVIDUAL
