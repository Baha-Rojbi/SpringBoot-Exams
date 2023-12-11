package tn.esprit.examenassurance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenassurance.Entities.Beneficiaire;
import tn.esprit.examenassurance.Entities.Contrat;

import java.util.List;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire,Integer> {
    Beneficiaire findByCin(int cin);
}
