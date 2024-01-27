package tn.esprit.examen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.Entities.Donation;
import tn.esprit.examen.Entities.DonationType;

import java.util.Set;

public interface DonationRepository extends JpaRepository<Donation,Long> {
Set<Donation> findByTypeOrderByDate(DonationType type);
}
