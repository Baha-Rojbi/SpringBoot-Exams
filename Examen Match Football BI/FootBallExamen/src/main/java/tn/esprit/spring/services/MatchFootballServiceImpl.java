package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Equipe;
import tn.esprit.spring.entities.Joueur;
import tn.esprit.spring.entities.MatchFootball;
import tn.esprit.spring.repository.EquipeRepository;
import tn.esprit.spring.repository.JoueurRepository;
import tn.esprit.spring.repository.MatchFootBallRepository;
import tn.esprit.spring.serviceInterfaces.IMatchFootballService;

@Service
public class MatchFootballServiceImpl implements IMatchFootballService {

	@Autowired
	MatchFootBallRepository matchRepository;
	@Autowired
	JoueurRepository joueurRepository;

	@Autowired
	EquipeRepository equipeRepository;

	@Transactional
	public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1,
			Integer idEquipe2) {
		if (idEquipe1 != idEquipe2) {
			Equipe equipe1 = equipeRepository.findById(idEquipe1).orElse(null);
			Equipe equipe2 = equipeRepository.findById(idEquipe2).orElse(null);
			matchFootball.getEquipes().add(equipe1);
			matchFootball.getEquipes().add(equipe2);
			matchRepository.save(matchFootball);
		}
		return matchFootball;
	}

	@Override
	public MatchFootball reporterMatch(Integer idMatch, Date dateReportee) {
		MatchFootball match = matchRepository.findById(idMatch).orElse(null);

		List<Joueur> joueurs = joueurRepository.findByEquipeMatchsIdMatchAndBlessure(idMatch, true);
		if (joueurs.size() > 1 && match.getDateMatch().after(new Date()))
			match.setDateMatch(dateReportee);

		matchRepository.save(match);

		return match;
	}

}