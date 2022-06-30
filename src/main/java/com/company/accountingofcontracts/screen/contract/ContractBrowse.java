package com.company.accountingofcontracts.screen.contract;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contract;

@UiController("Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
public class ContractBrowse extends StandardLookup<Contract> {
}