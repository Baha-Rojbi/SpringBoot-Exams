package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bus.Entities.Trajet;

public interface TrajetRepositories extends JpaRepository<Trajet,Integer> {
}
