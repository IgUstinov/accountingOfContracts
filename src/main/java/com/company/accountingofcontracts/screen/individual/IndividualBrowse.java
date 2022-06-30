package com.company.accountingofcontracts.screen.individual;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Individual;

@UiController("Individual.browse")
@UiDescriptor("individual-browse.xml")
@LookupComponent("individualsTable")
public class IndividualBrowse extends StandardLookup<Individual> {
}