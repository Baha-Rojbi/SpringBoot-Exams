package tn.esprit.examenpathologie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenpathologie.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
