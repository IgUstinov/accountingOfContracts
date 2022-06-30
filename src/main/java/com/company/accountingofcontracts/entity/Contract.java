package com.company.accountingofcontracts.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTRACT", indexes = {
        @Index(name = "IDX_CONTRACT_CUSTOMER_ID", columnList = "CUSTOMER_ID"),
        @Index(name = "IDX_CONTRACT", columnList = "EXECUTOR_LEGAL_ENTITY_ID"),
        @Index(name = "IDX_CONTRACT", columnList = "EXECUTOR_INDIVIDUAL_ID")
})
@Entity
public class Contract {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATE_OF_CONCLUSION", nullable = false)
    @NotNull
    private LocalDate dateOfConclusion;

    @Column(name = "TERM_OF_THE_CONTRACT", nullable = false)
    @NotNull
    private LocalDate termOfTheContract;

    @Column(name = "AMOUNT_OF_SERVICES", nullable = false, precision = 19, scale = 3)
    @NotNull
    private BigDecimal amountOfServices;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @Composition
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Client customer;

    @JoinColumn(name = "EXECUTOR_LEGAL_ENTITY_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private LegalEntity executorLegalEntity;

    @JoinColumn(name = "EXECUTOR_INDIVIDUAL_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Individual executorIndividual;

    public Individual getExecutorIndividual() {
        return executorIndividual;
    }

    public void setExecutorIndividual(Individual executorIndividual) {
        this.executorIndividual = executorIndividual;
    }

    public LegalEntity getExecutorLegalEntity() {
        return executorLegalEntity;
    }

    public void setExecutorLegalEntity(LegalEntity executorLegalEntity) {
        this.executorLegalEntity = executorLegalEntity;
    }

    public Client getCustomer() {
        return customer;
    }

    public void setCustomer(Client customer) {
        this.customer = customer;
    }

    public BigDecimal getAmountOfServices() {
        return amountOfServices;
    }

    public void setAmountOfServices(BigDecimal amountOfServices) {
        this.amountOfServices = amountOfServices;
    }

    public LocalDate getTermOfTheContract() {
        return termOfTheContract;
    }

    public void setTermOfTheContract(LocalDate termOfTheContract) {
        this.termOfTheContract = termOfTheContract;
    }

    public LocalDate getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(LocalDate dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}