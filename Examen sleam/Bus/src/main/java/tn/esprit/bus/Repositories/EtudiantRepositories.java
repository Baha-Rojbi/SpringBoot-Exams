package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.bus.Entities.Etudiant;

import java.util.List;

public interface EtudiantRepositories extends JpaRepository<Etudiant,Integer> {
    @Query("SELECT e.login FROM Etudiant e " +
            "JOIN e.projets p " +
            "WHERE e.idEtudiant = :idEtudiant AND p.refProjet = :idProjet")
    public List<String> findColleaguesLogins(@Param("idEtudiant") int idEtudiant, @Param("idProjet") int idProjet);
    @Query("SELECT e FROM Etudiant e where size(e.projets) = 1")
    List<Etudiant> findEtudiantsWithOnlyOneProjet();
}
