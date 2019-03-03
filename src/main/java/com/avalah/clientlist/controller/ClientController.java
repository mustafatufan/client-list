package com.avalah.clientlist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.avalah.clientlist.model.Client;
import com.avalah.clientlist.service.ClientService;
import com.avalah.clientlist.service.CountryService;

@Controller
public class ClientController {

	private ClientService clientService;
	private CountryService countryService;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("clientList", clientService.getClientList());
		return "index";
	}

	@GetMapping(value = "/client/{clientUsername}")
	public String editClient(@PathVariable("clientUsername") String clientUsername,
			Model model) {
		model.addAttribute("countryList", countryService.getCountryList());
		model.addAttribute("client", clientService.getClient(clientUsername));
		return "client";
	}

	@GetMapping(value = "/newClient")
	public String newClient(Model model) {
		model.addAttribute("countryList", countryService.getCountryList());
		model.addAttribute("client", new Client());
		return "client";
	}

	@PostMapping("/client")
	public String client(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client";
		}
		clientService.saveClient(client);
		model.addAttribute("clientList", clientService.getClientList());
		return "index";
	}

	@Autowired
	@Qualifier("clientService")
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Autowired
	@Qualifier("countryService")
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

}
