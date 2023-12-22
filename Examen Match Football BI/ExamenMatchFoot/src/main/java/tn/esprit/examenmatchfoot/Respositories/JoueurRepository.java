package tn.esprit.examenmatchfoot.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenmatchfoot.Entities.Division;
import tn.esprit.examenmatchfoot.Entities.Joueur;
import tn.esprit.examenmatchfoot.Entities.Poste;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur,Integer> {
    public List<Joueur> findByPosteAndTailleIsGreaterThan(Poste poste,float taille);
    @Query("SELECT j FROM Joueur j WHERE j.poste = :poste AND j.equipeJoueur.division = :division AND :matchId MEMBER OF j.equipeJoueur.matchFootballEquipe")
    List<Joueur> findJoueursByDivisionAndPosteAndMatchId(@Param("division") Division division, @Param("poste") Poste poste, @Param("matchId") Integer matchId);

    int countByEquipeJoueurIdEquipeAndBlessureIsTrue(Integer equipeId);
}
