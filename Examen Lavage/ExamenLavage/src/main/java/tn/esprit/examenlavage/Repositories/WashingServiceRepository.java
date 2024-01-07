package tn.esprit.examenlavage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenlavage.Entities.Type;
import tn.esprit.examenlavage.Entities.Washing_Service;
import tn.esprit.examenlavage.Entities.Worker;

public interface WashingServiceRepository extends JpaRepository<Washing_Service,Long> {
    Washing_Service getByType(Type type);
}
