package tn.esprit.spring.serviceInterfaces;

import java.util.Date;

import tn.esprit.spring.entities.MatchFootball;

public interface IMatchFootballService {
	public MatchFootball reporterMatch(Integer idMatch, Date dateReportee);

	public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1,
			Integer idEquipe2);
}
