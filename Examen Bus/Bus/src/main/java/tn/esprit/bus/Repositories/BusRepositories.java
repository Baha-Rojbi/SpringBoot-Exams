package tn.esprit.bus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.esprit.bus.Entities.Bus;

public interface BusRepositories extends JpaRepository<Bus,Integer> {
    Bus findByNumImmatriculation(String numImmatriculation);
}
