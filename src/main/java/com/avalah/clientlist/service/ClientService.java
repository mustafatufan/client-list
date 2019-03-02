package com.avalah.clientlist.service;

import java.util.List;

import com.avalah.clientlist.model.Client;
import com.avalah.clientlist.model.User;

public interface ClientService {

	public Client saveClient(Client client);

	public Client getClient(String username, User user);

	public List<Client> getClientList(User user);

}
