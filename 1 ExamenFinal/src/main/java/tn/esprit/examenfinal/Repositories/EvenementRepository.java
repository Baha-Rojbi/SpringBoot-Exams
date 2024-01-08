package tn.esprit.examenfinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenfinal.Entities.Evenement;

import java.time.LocalDate;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
    List<Evenement> findByDateEvenementBetween(LocalDate datemin,LocalDate dateMax);
}
