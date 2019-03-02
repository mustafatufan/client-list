package com.avalah.clientlist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avalah.clientlist.model.Client;
import com.avalah.clientlist.model.User;
import com.avalah.clientlist.repository.UserRepository;
import com.avalah.clientlist.service.ClientService;

@Controller
public class ClientController {

	private ClientService clientService;
	private UserRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("clientList", clientService.getClientList(getCurrentUser()));
		return "index";
	}

	@PostMapping("/client")
	public String client(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client";
		}
		clientService.saveClient(client);
		model.addAttribute("clientList", clientService.getClientList(getCurrentUser()));
		return "index";
	}

	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.getOne(authentication.getName());
	}

	// TODO: Refactor this approach.
	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	@Qualifier("clientService")
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

}
