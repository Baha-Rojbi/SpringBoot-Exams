package tn.esprit.examencoursclassroom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examencoursclassroom.Entities.CoursClassroom;
import tn.esprit.examencoursclassroom.Entities.Niveau;
import tn.esprit.examencoursclassroom.Entities.Specialite;

public interface CoursClassroomRepository extends JpaRepository<CoursClassroom,Integer> {
    @Query("select SUM(cc.nbHeures) from CoursClassroom cc where cc.specialite=:sp and cc.classe.niveau=:nv")
    public Integer nbHeuresParSpecEtNiv(@Param("sp") Specialite sp,@Param("nv") Niveau nv);
}
