create table CARSERVICE_COUNTERPARTY_CAR_SERVICE_LINK (
    COUNTERPARTY_ID uuid,
    CAR_SERVICE_ID uuid,
    primary key (COUNTERPARTY_ID, CAR_SERVICE_ID)
);
