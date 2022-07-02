package com.company.accountingofcontracts.screen.contractor;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contractor;

@UiController("Contractor.edit")
@UiDescriptor("contractor-edit.xml")
@EditedEntityContainer("contractorDc")
public class ContractorEdit extends StandardEditor<Contractor> {
}