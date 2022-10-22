-- begin CARSERVICE_CITY
create table CARSERVICE_CITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE_CODE varchar(255) not null,
    DEFAULT_CITY boolean not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CITY
-- begin CARSERVICE_CAR_SERVICE
create table CARSERVICE_CAR_SERVICE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ADDRESS varchar(255) not null,
    PHONE_NUMBER varchar(255) not null,
    CITY_ID uuid not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CAR_SERVICE
-- begin CARSERVICE_EMPLOYEE
create table CARSERVICE_EMPLOYEE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    BIRTHDAY date not null,
    SALARY decimal(19, 2),
    EMAIL varchar(255),
    CAR_SERVICE_ID uuid,
    --
    primary key (ID)
)^
-- end CARSERVICE_EMPLOYEE
-- begin CARSERVICE_REPAIR
create table CARSERVICE_REPAIR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CAR_SERVICE_ID uuid not null,
    EMPLOYEE_ID uuid not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_REPAIR
