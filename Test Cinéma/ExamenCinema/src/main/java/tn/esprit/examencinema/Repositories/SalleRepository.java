package tn.esprit.examencinema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examencinema.Entities.Salle;

public interface SalleRepository extends JpaRepository<Salle,Long> {
    Salle findByNomSalle(String nomSalle);
}
