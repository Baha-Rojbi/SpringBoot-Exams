package tn.esprit.examendatacenter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examendatacenter.Entitites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
