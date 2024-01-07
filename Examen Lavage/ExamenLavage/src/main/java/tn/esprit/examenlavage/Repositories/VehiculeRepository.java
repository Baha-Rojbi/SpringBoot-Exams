package tn.esprit.examenlavage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenlavage.Entities.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
