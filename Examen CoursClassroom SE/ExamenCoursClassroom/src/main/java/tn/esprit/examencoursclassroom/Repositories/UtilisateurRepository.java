package tn.esprit.examencoursclassroom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examencoursclassroom.Entities.Niveau;
import tn.esprit.examencoursclassroom.Entities.Utilisateur;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Integer countByClassUser_Niveau(Niveau nv);
    List<Utilisateur> findByClassUser_Niveau(Niveau nv);
}
