package tn.esprit.examenlavage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenlavage.Entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    Worker findByNic(String nic);
    Worker findByName(String name);
}
