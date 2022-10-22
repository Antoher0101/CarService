alter table CARSERVICE_COUNTERPARTY add column NAME varchar(255) ^
update CARSERVICE_COUNTERPARTY set NAME = '' where NAME is null ;
alter table CARSERVICE_COUNTERPARTY alter column NAME set not null ;
