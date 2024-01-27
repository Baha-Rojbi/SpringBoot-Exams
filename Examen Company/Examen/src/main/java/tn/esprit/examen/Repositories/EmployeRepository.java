package tn.esprit.examen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examen.Entities.Employe;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
