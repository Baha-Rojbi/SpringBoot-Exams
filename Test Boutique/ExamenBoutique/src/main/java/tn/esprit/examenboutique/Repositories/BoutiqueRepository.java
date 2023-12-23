package tn.esprit.examenboutique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenboutique.Entities.Boutique;

public interface BoutiqueRepository extends JpaRepository<Boutique,Long> {
}
