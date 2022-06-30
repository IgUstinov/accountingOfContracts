package com.company.accountingofcontracts.screen.individual;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Individual;

@UiController("Individual.edit")
@UiDescriptor("individual-edit.xml")
@EditedEntityContainer("individualDc")
public class IndividualEdit extends StandardEditor<Individual> {
}