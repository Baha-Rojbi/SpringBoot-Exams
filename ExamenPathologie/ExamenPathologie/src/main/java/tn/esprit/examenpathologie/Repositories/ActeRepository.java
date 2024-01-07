package tn.esprit.examenpathologie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenpathologie.Entities.Acte;

public interface ActeRepository extends JpaRepository<Acte,Long> {
Acte findByCodeActe(String codeActe);
}
