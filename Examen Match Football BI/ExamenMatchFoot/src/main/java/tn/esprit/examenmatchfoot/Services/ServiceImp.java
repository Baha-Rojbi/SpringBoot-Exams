package tn.esprit.examenmatchfoot.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenmatchfoot.Entities.*;
import tn.esprit.examenmatchfoot.Respositories.EquipeRepository;
import tn.esprit.examenmatchfoot.Respositories.JoueurRepository;
import tn.esprit.examenmatchfoot.Respositories.MatchFootballRepository;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class ServiceImp implements IService{
    private EquipeRepository equipeRepository;
    private JoueurRepository joueurRepository;
    private MatchFootballRepository matchFootballRepository;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
       joueur.setEquipeJoueur(equipe);
        return joueurRepository.save(joueur);
    }

    @Override
    public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
        return joueurRepository.findByPosteandTaille(poste, taille);
    }

    @Override
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2) {
        Equipe equipe1=equipeRepository.findById(idEquipe1).orElse(null);
        Equipe equipe2=equipeRepository.findById(idEquipe2).orElse(null);
        if (equipe1!=equipe2){
            Set<Equipe> equipes=new HashSet<>();
            equipes.add(equipe1);
            equipes.add(equipe2);
            matchFootball.setEquipeMatch(equipes);
        }
        return matchFootballRepository.save(matchFootball);
    }

    @Override
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {
        return joueurRepository.afficherJoueursDuMatchParDivisionEtPoste(division,poste,idMatch);
    }

    @Override
    public MatchFootball reporterMatch(Integer idMatch, Date dateReportee) {
        MatchFootball matchFootball=matchFootballRepository.findById(idMatch).orElse(null);
        if (matchFootball.getDateMatch().before(new Date())){
            return null;
        }
        Set<Equipe> equipes = matchFootball.getEquipeMatch();
        for (Equipe equipe:equipes){
            if (joueurRepository.countByEquipeJoueurIdEquipeAndBlessureIsTrue(equipe.getIdEquipe()) >= 2){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(matchFootball.getDateMatch());
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                matchFootball.setDateMatch(calendar.getTime());
                return matchFootballRepository.save(matchFootball);
            }
        }
        return matchFootball;
    }
    @Scheduled(fixedRate = 60000)
    public void afficherJoueursPolyvalentsDisponibles (){
        List<Joueur> joueurs=joueurRepository.findAll();
        for (Joueur joueur:joueurs){
            if(!joueur.isBlessure()&&joueur.getPoste()==Poste.DEFENSEUR&&joueur.getNbButsEnCarrire()>=20){
                log.info("le joueur "+joueur.getNom()+" est polyvalant");
            }
        }
    }

   /* @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        joueur.setEquipeJoueur(equipe);
        return joueurRepository.save(joueur);
    }

    @Override
    public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
        return joueurRepository.findByPosteAndTailleIsGreaterThan(poste,taille);
    }

    @Override
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2) {
        Equipe equipe1 = equipeRepository.findById(idEquipe1)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id " + idEquipe1));

        Equipe equipe2 = equipeRepository.findById(idEquipe2)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id " + idEquipe2));
        Set<Equipe> equipes = new HashSet<>();
        equipes.add(equipe1);
        equipes.add(equipe2);

        matchFootball.setEquipeMatch(equipes);
        return matchFootballRepository.save(matchFootball);
    }

    @Override
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {
        MatchFootball match = matchFootballRepository.findById(idMatch).orElse(null);
        Set<Equipe> equipes = match.getEquipeMatch();

        List<Joueur> joueurs = new ArrayList<>();
        for (Equipe equipe : equipes) {
            if (equipe.getDivision().equals(division)) {
                // This is a simple loop. In practice, you might want to make a single query to
                // fetch these from the database.
                for (Joueur joueur : equipe.getJoueurEquipe()) {
                    if(joueur.getPoste().equals(poste)) {
                        joueurs.add(joueur);
                    }
                }
            }
        }

        return joueurs;
       // return joueurRepository.findJoueursByDivisionAndPosteAndMatchId(division, poste, idMatch);

    }

    @Override
    public MatchFootball reporterMatch(Integer idMatch, Date dateReportee) {
        MatchFootball match = matchFootballRepository.findById(idMatch).orElse(null);
*//*        // Check if the match has already been played
        if (match.getDateMatch().before(new Date())) {
            // Handle the case where the match has already been played
            return null; // or throw a custom exception
        }*//*
        // Check for each team if there are at least two injured players
        Set<Equipe> teams = match.getEquipeMatch();

        for (Equipe team : teams) {
            if (joueurRepository.countByEquipeJoueurIdEquipeAndBlessureIsTrue(team.getIdEquipe()) >= 2) {
                // Report the match by adding 7 days to the current match date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(match.getDateMatch());
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                match.setDateMatch(calendar.getTime());
                return matchFootballRepository.save(match);
            }
        }
        return match;

    }



    @Scheduled(fixedRate = 60000)
    public void afficherJoueursPolyvalentsDisponibles (){
        List<Joueur>joueurs = joueurRepository.findAll();
        for(Joueur joueur : joueurs){
            if(joueur.getNbButsEnCarrire()>=20 && joueur.getPoste()==Poste.DEFENSEUR && !joueur.isBlessure())
            {
                log.info("Le joueur "+ joueur.getNom() + " est polyvalent");
            }
        }
    }*/
}
