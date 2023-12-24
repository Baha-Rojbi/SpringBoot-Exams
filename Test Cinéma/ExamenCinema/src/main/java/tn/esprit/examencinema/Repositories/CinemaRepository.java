package tn.esprit.examencinema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examencinema.Entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {
}
