-- alter table CARSERVICE_REPAIR add column EMPLOYEE_ID uuid ^
-- update CARSERVICE_REPAIR set EMPLOYEE_ID = <default_value> ;
-- alter table CARSERVICE_REPAIR alter column EMPLOYEE_ID set not null ;
alter table CARSERVICE_REPAIR add column EMPLOYEE_ID uuid not null ;
