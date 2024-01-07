package tn.esprit.examenpathologie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.PartTreeJpaQuery;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenpathologie.Entities.Pathologie;

public interface PathologieRepository extends JpaRepository<Pathologie,Long> {
    Pathologie findByCodePath(String codePath);
    @Query("select p from Pathologie p where p.codePath=:identifiant or p.libelle=:identifiant")
    Pathologie findByCodePathOrLibel(@Param("identifiant") String identifiant);
    Pathologie findByCodePathAndArchiveIsFalse(String codePath);
}
