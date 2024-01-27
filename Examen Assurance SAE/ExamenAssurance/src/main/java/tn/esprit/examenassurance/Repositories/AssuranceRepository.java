package tn.esprit.examenassurance.Repositories;

import org.hibernate.query.criteria.JpaRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenassurance.Entities.Assurance;
import tn.esprit.examenassurance.Entities.Beneficiaire;
import tn.esprit.examenassurance.Entities.Contrat;
import tn.esprit.examenassurance.Entities.TypeContrat;

import java.util.List;
import java.util.Set;

public interface AssuranceRepository extends JpaRepository<Assurance,Integer> {
    @Query("SELECT a FROM Assurance a WHERE a.beneficiaire.idBenef = :idBf ORDER BY a.contrat.dateEffet ASC")
    List<Assurance> findAssurancesByBeneficiaireIdOrderByContratDateEffetAsc( @Param("idBf") int idBf);
    List<Assurance> findByBeneficiaireIdBenef(int idBenef);
    @Query("SELECT DISTINCT a.beneficiaire FROM Assurance a WHERE a.contrat.type = :typeContrat")
    Set<Beneficiaire> findBeneficiairesByContratType(@Param("typeContrat") TypeContrat typeContrat);



}
