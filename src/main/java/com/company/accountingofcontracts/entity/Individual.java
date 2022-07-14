package com.company.accountingofcontracts.entity;

import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "Individual")
@JmixEntity
@Entity
@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("Individual")
public class Individual extends Contractor {

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false, length = 35)
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @NotNull
    @Column(name = "PROFESSION", nullable = false)
    private String profession;

    @Override
    public IndOrLegEnt getType() {
        return IndOrLegEnt.INDIVIDUAL;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @InstanceName
    @DependsOnProperties({"name"})
    public String getInstanceName() {
        return String.format("%s", getName());
    }
}