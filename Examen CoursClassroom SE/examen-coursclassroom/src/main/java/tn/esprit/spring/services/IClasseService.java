package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Classe;


public interface IClasseService {

	List<Classe> retrieveAllClasses();

	Classe ajouterClasse(Classe c);

	void deleteClasse(Integer id);

	Classe updateClasse(Classe c);

	Classe retrieveClasse(Integer id); 
	
	public Classe AjouterClasseEtAffecterCoursClasse(Classe c, Integer idCours); 


}
