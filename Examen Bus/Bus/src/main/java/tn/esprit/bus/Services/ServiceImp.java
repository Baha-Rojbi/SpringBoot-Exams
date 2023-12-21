package tn.esprit.bus.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.bus.Entities.Bus;
import tn.esprit.bus.Entities.Trajet;
import tn.esprit.bus.Entities.Utilisateur;
import tn.esprit.bus.Repositories.BusRepositories;
import tn.esprit.bus.Repositories.TrajetRepositories;
import tn.esprit.bus.Repositories.UtilisateurRepositories;

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

        return busRepositories.save(bus);
    }

    @Override
    public Bus affecterTrajetABus(int idBus, int idTrajet) {
        Bus bus = busRepositories.findById(idBus).orElse(null);
        Trajet trajet=trajetRepositories.findById(idTrajet).orElse(null);
        bus.setTrajet(trajet);
        return busRepositories.save(bus);
    }

    @Override
    public String affecterEtudiantABus(String numImma, String nom, String prenom) {
        Utilisateur etudiant = utilisateurRepositories.findByNomAndPrenom(nom, prenom);
        Bus bus = busRepositories.findByNumImmatriculation(numImma);
        if (bus.getEtudiant().size()< bus.getNbreDePlaceMax())
        {
            bus.getEtudiant().add(etudiant);
            log.info("L'affectation de l’étudiant est effectuée avec succès");
            return "L'affectation de l’étudiant est effectuée avec succès";
        }else {
            log.info(" Le bus est complet");
            return "Le bus est complet";
        }
    }

    @Override
    public List<Utilisateur> afficherEtudiantsAvecTrajet(int idTrajet, Date dateInf, Date dateSup) {
        return null;
    }
}
