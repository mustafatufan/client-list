package com.avalah.clientlist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.avalah.clientlist.model.Client;
import com.avalah.clientlist.model.User;
import com.avalah.clientlist.repository.UserRepository;
import com.avalah.clientlist.service.CacheService;
import com.avalah.clientlist.service.ClientService;

@Controller
public class ClientController {

	private ClientService clientService;
	private CacheService cacheService;
	private UserRepository userRepository;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("clientList", clientService.getClientList(getCurrentUser()));
		return "index";
	}

	@GetMapping(value = "/client/{clientUsername}")
	public String editClient(@PathVariable("clientUsername") String clientUsername,
			Model model) {
		model.addAttribute("countryList", cacheService.getCountryList());
		model.addAttribute("client", clientService.getClient(clientUsername, getCurrentUser()));
		return "client";
	}

	@GetMapping(value = "/newClient")
	public String newClient(Model model) {
		model.addAttribute("countryList", cacheService.getCountryList());
		model.addAttribute("client", new Client());
		return "client";
	}

	@PostMapping("/client")
	public String client(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client";
		}
		client.setUser(getCurrentUser());
		clientService.saveClient(client);
		model.addAttribute("clientList", clientService.getClientList(getCurrentUser()));
		return "index";
	}

	// TODO: Refactor this approach.
	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.getOne(authentication.getName());
	}

	@Autowired
	@Qualifier("clientService")
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Autowired
	@Qualifier("cacheService")
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
