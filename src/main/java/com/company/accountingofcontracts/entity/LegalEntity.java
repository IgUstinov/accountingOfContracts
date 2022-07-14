package com.company.accountingofcontracts.entity;

import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "LegalEntity")
@JmixEntity
@Entity
@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("LegalEntity")
public class LegalEntity extends Contractor {

    @NotNull
    @Column(name = "TIN", nullable = false)
    private String tin;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    @NotNull
    @Column(name = "DIRECTOR", nullable = false)
    private String director;

    @Override
    public IndOrLegEnt getType() {
        return IndOrLegEnt.LEGAL_ENTITY;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    @InstanceName
    @DependsOnProperties({"name"})
    public String getInstanceName() {
        return String.format("%s", getName());
    }
}