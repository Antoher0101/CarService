package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "CARSERVICE_INDIVIDUAL")
@Entity(name = "carservice_Individual")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Individual extends Counterparty {
    private static final long serialVersionUID = 6393631541750016460L;
}