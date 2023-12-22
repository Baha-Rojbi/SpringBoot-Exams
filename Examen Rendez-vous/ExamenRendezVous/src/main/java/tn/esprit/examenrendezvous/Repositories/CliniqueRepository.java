package tn.esprit.examenrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenrendezvous.Entities.Clinique;

public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
}
