package tn.esprit.examenmatchfoot.Services;

import tn.esprit.examenmatchfoot.Entities.*;

import java.util.Date;
import java.util.List;

public interface IService {
    public Equipe ajouterEquipe (Equipe equipe);
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe);
    public List<Joueur> afficherJoueursParPosteEtTaille (Poste poste, float taille);
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2);
    public List <Joueur> afficherJoueursDuMatchParDivisionEtPoste (Division division, Poste poste, Integer idMatch);
    public MatchFootball reporterMatch(Integer idMatch, Date dateReportee);

}
