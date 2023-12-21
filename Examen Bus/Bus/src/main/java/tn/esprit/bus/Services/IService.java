package tn.esprit.bus.Services;

import tn.esprit.bus.Entities.Bus;
import tn.esprit.bus.Entities.Trajet;
import tn.esprit.bus.Entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IService {
    Trajet ajouterTrajet(Trajet trajet);
    Utilisateur ajouterEtudiant(Utilisateur etudiant);
    Bus ajouterBusEtChauffeur(Bus bus);
    Bus affecterTrajetABus(int idBus, int idTrajet);
    String affecterEtudiantABus(String numImma, String nom, String prenom);
    List<Utilisateur> afficherEtudiantsAvecTrajet(int idTrajet, Date
            dateInf, Date dateSup);
}
