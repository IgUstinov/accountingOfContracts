package com.company.accountingofcontracts.screen.client;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Client;

@UiController("Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
public class ClientBrowse extends StandardLookup<Client> {
}