package com.company.accountingofcontracts.screen.contractor;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contractor;

@UiController("Contractor.browse")
@UiDescriptor("contractor-browse.xml")
@LookupComponent("contractorsTable")
public class ContractorBrowse extends StandardLookup<Contractor> {
}