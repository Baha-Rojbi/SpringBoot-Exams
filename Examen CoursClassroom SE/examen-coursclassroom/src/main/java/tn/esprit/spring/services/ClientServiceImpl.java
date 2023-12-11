package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		List<Client> listClient= clientRepository.findAll();
		for(Client c:listClient)
		{
			log.info("Client:" + c.getNom()+ c.getPrenom());
		}
		return listClient;
	}

	@Override
	public Client addClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client updateClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	public Client retrieveClient(Long id) {
		Client c= clientRepository.findById(id).get();
		return c;
	}

}
