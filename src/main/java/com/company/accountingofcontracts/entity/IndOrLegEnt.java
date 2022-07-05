package com.company.accountingofcontracts.entity;

import io.jmix.core.Entity;
import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum IndOrLegEnt implements EnumClass<String> {

    INDIVIDUAL("Individual"),
    LEGAL_ENTITY("Legal Entity");

    private String id;

    IndOrLegEnt(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static IndOrLegEnt fromId(String id) {
        for (IndOrLegEnt at : IndOrLegEnt.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}