package tn.esprit.examen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.Entities.Campany;

public interface CampanyRepository extends JpaRepository<Campany,Long> {
    Campany findByCampanyName(String name);
}
