package com.avalah.clientlist.service;

import java.util.List;

import com.avalah.clientlist.model.Client;

public interface ClientService {

	public Client saveClient(Client client);

	public Client getClient(String username);

	public List<Client> getClientList();

}
