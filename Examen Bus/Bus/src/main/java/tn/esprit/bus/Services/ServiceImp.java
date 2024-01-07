package tn.esprit.bus.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.bus.Entities.Bus;
import tn.esprit.bus.Entities.Role;
import tn.esprit.bus.Entities.Trajet;
import tn.esprit.bus.Entities.Utilisateur;
import tn.esprit.bus.Repositories.BusRepositories;
import tn.esprit.bus.Repositories.TrajetRepositories;
import tn.esprit.bus.Repositories.UtilisateurRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private BusRepositories busRepositories;
    private TrajetRepositories trajetRepositories;
    private UtilisateurRepositories utilisateurRepositories;


    @Override
    public Trajet ajouterTrajet(Trajet trajet) {
        return trajetRepositories.save(trajet);
    }

    @Override
    public Utilisateur ajouterEtudiant(Utilisateur etudiant) {
        return utilisateurRepositories.save(etudiant);
    }

    @Override
    public Bus ajouterBusEtChauffeur(Bus bus) {
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setRole(Role.CHAUFFEUR);
        bus.setChauffeur(utilisateur);
        busRepositories.save(bus);
        return bus;
    }

    @Override
    public Bus affecterTrajetABus(int idBus, int idTrajet) {
       Bus bus=busRepositories.findById(idBus).orElse(null);
       Trajet trajet=trajetRepositories.findById(idTrajet).orElse(null);
       bus.setTrajet(trajet);
       busRepositories.save(bus);
        return bus;
    }

    @Override
    public String affecterEtudiantABus(String numImma, String nom, String prenom) {
Bus bus=busRepositories.findByNumImmatriculation(numImma);
Utilisateur utilisateur=utilisateurRepositories.findByNomAndPrenom(nom,prenom);
if(bus.getEtudiant().size()<bus.getNbreDePlaceMax()){
  utilisateur.setBusEtudiant(bus);
  utilisateurRepositories.save(utilisateur);
    return ("L'affectation de l’étudiant est effectuée avec succès");
}else {
    return ("Le bus est complet");
}
}
    @Override
    public List<Utilisateur> afficherEtudiantsAvecTrajet(int idTrajet, Date dateInf, Date dateSup) {

        return utilisateurRepositories.afficherEtudiantsAvecTrajet(idTrajet,dateInf,dateSup);
    }
    @Scheduled(fixedRate = 60000)
    void arreterAbonnement(){
        Date currentDate = new Date(); // Get current system date
        List<Utilisateur> utilisateurs = utilisateurRepositories.findByDateFinAbonnementBefore(currentDate);

        for (Utilisateur utilisateur : utilisateurs) {
            // Log the name and the prenom of the user whose subscription is being cancelled
            log.info(("Annulation de l abonnement pour etudiant: "+ utilisateur.getNom()+" "+utilisateur.getPrenom()));

            // Désaffecter l’étudiant du bus and set subscription dates to null
            utilisateur.setBusEtudiant(null);
            utilisateur.setDateDebutAbonnement(null);
            utilisateur.setDateFinAbonnement(null);
            utilisateurRepositories.save(utilisateur);
        }
    }
}
