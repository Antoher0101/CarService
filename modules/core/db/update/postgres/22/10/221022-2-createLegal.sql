alter table CARSERVICE_LEGAL add constraint FK_CARSERVICE_LEGAL_ON_ID foreign key (ID) references CARSERVICE_COUNTERPARTY(ID) on delete CASCADE;
