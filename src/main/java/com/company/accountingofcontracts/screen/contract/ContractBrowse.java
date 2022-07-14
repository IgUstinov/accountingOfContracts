package com.company.accountingofcontracts.screen.contract;

import com.company.accountingofcontracts.entity.Client;
import com.company.accountingofcontracts.entity.Contractor;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
public class ContractBrowse extends StandardLookup<Contract> {
}