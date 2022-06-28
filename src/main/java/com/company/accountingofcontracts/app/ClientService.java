package com.company.accountingofcontracts.app;

import com.company.accountingofcontracts.entity.Client;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private DataManager dataManager;

    Client createAndSaveClient(String fullName, String phoneNumber, String email, String address) {
        Client client = dataManager.create(Client.class);
        client.setId(UUID.randomUUID());
        client.setFullName(fullName);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        client.setAddress(address);
        dataManager.save(client);
        return client;
    }

    void removeClient(Client entity) {
        dataManager.remove(entity);
    }
}