package com.company.accountingofcontracts.screen.contract;

import com.company.accountingofcontracts.entity.Client;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataComponents;
import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ShowContract.browse")
@UiDescriptor("ShowContract-browse.xml")
@LookupComponent("contractsTable")
public class ShowContractBrowse extends StandardLookup<Contract> {
    @Autowired
    private CollectionLoader<Contract> contractsDl;

    public void setSelectedClient(Client x) {
        contractsDl.setParameter("client", x);
    }
}