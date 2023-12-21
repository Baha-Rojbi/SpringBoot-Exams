package tn.esprit.examenformation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenformation.Entities.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur,Integer> {
}
