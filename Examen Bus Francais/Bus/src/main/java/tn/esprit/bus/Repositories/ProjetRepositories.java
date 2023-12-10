package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bus.Entities.Projet;

public interface ProjetRepositories extends JpaRepository<Projet,Integer> {
}
