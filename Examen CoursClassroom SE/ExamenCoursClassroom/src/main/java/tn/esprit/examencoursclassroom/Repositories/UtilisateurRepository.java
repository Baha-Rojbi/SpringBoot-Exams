package tn.esprit.examencoursclassroom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examencoursclassroom.Entities.Niveau;
import tn.esprit.examencoursclassroom.Entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Integer countByClassUser_Niveau(Niveau nv);
}
