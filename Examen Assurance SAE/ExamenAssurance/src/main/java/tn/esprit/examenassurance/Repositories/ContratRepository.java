package tn.esprit.examenassurance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenassurance.Entities.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    Contrat findByMatricule(String matricule);

}
