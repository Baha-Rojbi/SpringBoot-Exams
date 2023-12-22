package tn.esprit.examenrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenrendezvous.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
