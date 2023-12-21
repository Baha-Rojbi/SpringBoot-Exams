package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bus.Entities.Utilisateur;

public interface UtilisateurRepositories extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByNomAndPrenom(String nom, String prenom);
}
