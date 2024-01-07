package tn.esprit.examenformation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenformation.Entities.Formation;

import java.util.Date;

public interface FormationRepository extends JpaRepository<Formation,Integer> {
/*    @Query("SELECT SUM(f.nbrHeures) FROM Formation f WHERE f.formateur.idFormateur = :idFormateur AND f.dateDebut >= :dateDebut AND f.dateFin <= :dateFin")
    Integer sumFormationHoursForFormateur(@Param("idFormateur") Integer idFormateur,
                                          @Param("dateDebut") Date dateDebut,
                                          @Param("dateFin") Date dateFin);*/
    @Query("select sum(f.nbrHeures) from Formation f where f.formateur.idFormateur = :idFormateur and f.dateDebut >= :dateDebut and f.dateFin<=:dateFin")
    Integer sumFormationHoursForFormateur(@Param("idFormateur") Integer idFormateur,@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin);
}
