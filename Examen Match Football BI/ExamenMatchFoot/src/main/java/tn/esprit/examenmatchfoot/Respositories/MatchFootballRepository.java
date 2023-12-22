package tn.esprit.examenmatchfoot.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenmatchfoot.Entities.MatchFootball;

public interface MatchFootballRepository extends JpaRepository<MatchFootball,Integer> {
}
