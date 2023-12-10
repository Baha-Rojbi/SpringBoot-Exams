package tn.esprit.parking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.parking.Entities.Personnel;

public interface PersonnelRepositories extends JpaRepository<Personnel,Integer> {
}
