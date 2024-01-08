package tn.esprit.examenfinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenfinal.Entities.Internaute;
import tn.esprit.examenfinal.Entities.TrancheAge;

import java.util.List;

public interface InternauteRepository extends JpaRepository<Internaute,Long> {
List<Internaute> findByTrancheAge(TrancheAge trancheAge);
}
