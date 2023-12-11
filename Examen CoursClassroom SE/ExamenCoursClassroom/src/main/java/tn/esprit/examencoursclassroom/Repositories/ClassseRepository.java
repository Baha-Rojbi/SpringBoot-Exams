package tn.esprit.examencoursclassroom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examencoursclassroom.Entities.Classe;

public interface ClassseRepository extends JpaRepository<Classe,Integer> {
    Classe findByNiveau (Classe classe);
}
