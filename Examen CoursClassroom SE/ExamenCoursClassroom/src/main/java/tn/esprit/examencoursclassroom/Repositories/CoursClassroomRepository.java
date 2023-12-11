package tn.esprit.examencoursclassroom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examencoursclassroom.Entities.CoursClassroom;
import tn.esprit.examencoursclassroom.Entities.Niveau;
import tn.esprit.examencoursclassroom.Entities.Specialite;

public interface CoursClassroomRepository extends JpaRepository<CoursClassroom,Integer> {
    @Query("SELECT SUM(cc.nbHeures) FROM CoursClassroom cc WHERE cc.specialite =:specialite AND cc.classe.niveau = :niveau")
    Integer nbHeuresParSpecialiteEtdNiveau(@Param("specialite") Specialite specialite, @Param("niveau") Niveau niveau);
}
