package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Division;
import tn.esprit.spring.entities.Equipe;
import tn.esprit.spring.entities.Joueur;
import tn.esprit.spring.entities.Poste;
import tn.esprit.spring.repository.EquipeRepository;
import tn.esprit.spring.repository.JoueurRepository;
import tn.esprit.spring.repository.MatchFootBallRepository;
import tn.esprit.spring.serviceInterfaces.IJoueurService;

@Service
@Slf4j
public class JoueurServiceImpl implements IJoueurService {

	@Autowired
	JoueurRepository joueurRepository;
	@Autowired
	EquipeRepository equipeRepository;
	@Autowired
	MatchFootBallRepository matchFootBallRepository;

	@Override
	public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {
		Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
		joueur.setEquipe(equipe);
		return joueurRepository.save(joueur);
	}

	@Override
	public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
		return joueurRepository.findByPosteAndTailleGreaterThanEqual(poste, taille);
	}

	@Override
	public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {
		return joueurRepository.findByEquipeDivisionAndPosteAndEquipeMatchsIdMatch(division, poste, idMatch);

	}

	@Override
	@Scheduled(cron = "*/60 * * * * *")
	public void afficherJoueursPolyvalentsDisponibles() {
		List<Joueur> defenseurs = joueurRepository.findByPoste(Poste.DEFENSEUR);
		for (Joueur joueur : defenseurs) {
			if (joueur.getNbButsEnCarriere() >= 20 && Boolean.TRUE.equals(!joueur.getBlessure()))
				log.info("Le joueuer " + joueur.getNom() + " est polyvalent");
		}

	}

}