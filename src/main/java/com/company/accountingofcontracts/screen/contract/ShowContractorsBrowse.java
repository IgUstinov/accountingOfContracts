package com.company.accountingofcontracts.screen.contract;

import com.company.accountingofcontracts.entity.Client;
import com.company.accountingofcontracts.entity.Contractor;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ShowContractors.browse")
@UiDescriptor("showContractors-browse.xml")
@LookupComponent("contractsTable")
public class ShowContractorsBrowse extends StandardLookup<Contract> {
    @Autowired
    private CollectionLoader<Contract> contractsDl;

    public void setSelectedContractor(Contractor x) {
        contractsDl.setParameter("contractor", x);
    }
}