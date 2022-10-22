-- alter table CARSERVICE_REPAIR add column CAR_SERVICE_ID uuid ^
-- update CARSERVICE_REPAIR set CAR_SERVICE_ID = <default_value> ;
-- alter table CARSERVICE_REPAIR alter column CAR_SERVICE_ID set not null ;
alter table CARSERVICE_REPAIR add column CAR_SERVICE_ID uuid not null ;
