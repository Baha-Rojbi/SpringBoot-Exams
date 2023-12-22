package tn.esprit.examenrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenrendezvous.Entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
