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

	private UserService userService;
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		client.setUser(userService.getCurrentUser());
		return clientRepository.save(client);
	}

	@Override
	public Client getClient(String username) {
		Client client = clientRepository.getOne(username);
		User user = userService.getCurrentUser();
		if (client.getUser().equals(user)) {
			return client;
		}
		return null;
	}

	@Override
	public List<Client> getClientList() {
		User user = userService.getCurrentUser();
		return clientRepository.findByUser(user);
	}

	@Autowired
	@Qualifier("clientRepository")
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Autowired
	@Qualifier("userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
