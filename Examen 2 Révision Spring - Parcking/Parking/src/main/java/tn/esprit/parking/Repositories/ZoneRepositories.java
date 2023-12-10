package tn.esprit.parking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.parking.Entities.Zone;

public interface ZoneRepositories extends JpaRepository<Zone,Integer> {
}
