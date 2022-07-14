package com.company.accountingofcontracts.screen.client;

import com.company.accountingofcontracts.entity.*;
import com.company.accountingofcontracts.screen.contract.ContractBrowse;
import com.company.accountingofcontracts.screen.contract.ShowContractBrowse;
import io.jmix.core.metamodel.model.MetaClass;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.builder.EditorBuilder;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.component.ListComponent;
import io.jmix.ui.component.Table;
import io.jmix.ui.component.data.meta.EntityDataUnit;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataComponents;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
public class ClientBrowse extends StandardLookup<Client> {
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private GroupTable<Client> clientsTable;

    @Subscribe("showContracts")
    public void onCheckBtnCheck(Action.ActionPerformedEvent event) {
        Client selectedClient = clientsTable.getSingleSelected();
        ShowContractBrowse contracts = screenBuilders.screen(this)
                .withScreenClass(ShowContractBrowse.class)
                .withOpenMode(OpenMode.DIALOG)
                .build();
        contracts.setSelectedClient(selectedClient);
        contracts.show();
    }
}