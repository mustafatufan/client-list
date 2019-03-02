package com.avalah.clientlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalah.clientlist.model.Client;
import com.avalah.clientlist.model.User;
import com.avalah.clientlist.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client getClient(String username, User user) {
		Client client = clientRepository.getOne(username);
		if (client.getUser().equals(user)) {
			return client;
		}
		return null;
	}

	@Override
	public List<Client> getClientList(User user) {
		return clientRepository.findByUser(user);
	}

	@Autowired
	@Qualifier("clientRepository")
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

}
