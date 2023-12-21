package tn.esprit.examenformation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenformation.Entities.Formation;

public interface FormationRepository extends JpaRepository<Formation,Integer> {
}
