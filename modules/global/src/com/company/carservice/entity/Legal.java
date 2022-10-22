package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "CARSERVICE_LEGAL")
@Entity(name = "carservice_Legal")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Legal extends Counterparty {
    private static final long serialVersionUID = 836869651191603535L;
}