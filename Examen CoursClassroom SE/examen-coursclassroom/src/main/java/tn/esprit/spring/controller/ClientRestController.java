package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.services.IClientService;
@RestController
@Api(tags = "Gestion des clients")
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	IClientService clientService;

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@ApiOperation(value = "Récupérer la liste des clients")
	@GetMapping("/retrieve-all-clients")
	public List<Client> getClients() {
		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;
	}

	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@ApiOperation(value = "Récupérer un client par Id")
	@GetMapping("/retrieve-client/{client-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retrieveClient(clientId);
	}

	@PostMapping("/add-client")
	public Client addClient(@RequestBody Client c) {
		return clientService.addClient(c);
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	public void removeClient(@PathVariable("client-id") Long clientId) {
		clientService.deleteClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	public Client modifyClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}


}
