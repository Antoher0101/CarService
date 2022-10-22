alter table CARSERVICE_CAR_SERVICE rename column repair_id to repair_id__u55778 ;
alter table CARSERVICE_CAR_SERVICE drop constraint FK_CARSERVICE_CAR_SERVICE_ON_REPAIR ;
drop index IDX_CARSERVICE_CAR_SERVICE_ON_REPAIR ;
