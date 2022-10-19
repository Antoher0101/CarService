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
    --
    primary key (ID)
);