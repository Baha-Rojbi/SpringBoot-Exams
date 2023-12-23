package tn.esprit.examenboutique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenboutique.Entities.CentreCommercial;

public interface CentreCommercialRepository extends JpaRepository<CentreCommercial,Long> {
}
