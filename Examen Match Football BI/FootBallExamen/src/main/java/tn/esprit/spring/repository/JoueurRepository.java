package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Division;
import tn.esprit.spring.entities.Joueur;
import tn.esprit.spring.entities.Poste;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {

	@Query("SELECT j FROM Joueur j where j.poste =:poste and j.taille =:taille")
	List<Joueur> retreiveJoueurParPosteEtTaille(@Param("poste") Poste poste, @Param("taille") float taille);

	List<Joueur> findByPosteAndTailleGreaterThanEqual(Poste poste, float taille);

	List<Joueur> findByEquipeDivisionAndPosteAndEquipeMatchsIdMatch(Division d, Poste p, Integer idMatch);

	List<Joueur> findByPoste(Poste poste);

	List<Joueur> findByEquipeMatchsIdMatchAndBlessure(Integer idMatch, boolean blessure);

}
