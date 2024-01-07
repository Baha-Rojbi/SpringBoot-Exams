package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.bus.Entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface UtilisateurRepositories extends JpaRepository<Utilisateur,Integer> {
Utilisateur findByNomAndPrenom(String nom, String prenom);
    @Query("SELECT u FROM Utilisateur u WHERE u.busEtudiant.trajet.idTrajet = :idTrajet AND " +
            "u.role = tn.esprit.bus.Entities.Role.ETUDIANT AND " +
            "u.dateDebutAbonnement <= :dateSup AND " +
            "u.dateFinAbonnement >= :dateInf")
    List<Utilisateur> afficherEtudiantsAvecTrajet(@Param("idTrajet") int idTrajet,
                                                  @Param("dateInf") Date dateInf,
                                                  @Param("dateSup") Date dateSup);
    List<Utilisateur> findByDateFinAbonnementBefore(Date currentDate);
}
