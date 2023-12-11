package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Client;


public interface IClientService {

	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

}
