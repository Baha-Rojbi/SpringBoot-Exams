package tn.esprit.examenformation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenformation.Entities.Apprenant;

public interface ApprenantRepository extends JpaRepository<Apprenant,Integer> {
}
