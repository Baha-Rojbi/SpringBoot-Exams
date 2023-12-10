package tn.esprit.parking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.parking.Entities.Parking;

public interface ParkingRepositories extends JpaRepository<Parking,Integer> {
}
