package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bus.Entities.Tuteur;

public interface TuteurRepositories extends JpaRepository<Tuteur,Integer> {
}
