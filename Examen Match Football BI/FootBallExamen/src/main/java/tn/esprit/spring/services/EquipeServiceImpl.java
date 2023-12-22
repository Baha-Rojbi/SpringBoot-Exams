package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Equipe;
import tn.esprit.spring.repository.EquipeRepository;
import tn.esprit.spring.serviceInterfaces.IEquipeService;

@Service

public class EquipeServiceImpl implements IEquipeService {

	@Autowired
	EquipeRepository equipeRepository;

	@Override
	public Equipe ajouterEquipe(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

}