package com.company.accountingofcontracts.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
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
        @Index(name = "IDX_CONTRACT_EXECUTOR_ID", columnList = "EXECUTOR_ID")
})
@Entity
public class Contract {
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

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "EXECUTOR_ID", nullable = false)
    @Composition
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Contractor executor;

    public Contractor getExecutor() {
        return executor;
    }

    public void setExecutor(Contractor executor) {
        this.executor = executor;
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

    @InstanceName
    @DependsOnProperties({"id", "customer", "executor"})
    public String getInstanceName() {
        return String.format("%s %s %s", id, customer, executor);
    }
}