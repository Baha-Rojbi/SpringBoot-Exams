package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;


public interface ICoursClassroomService {

	List<CoursClassroom> retrieveAllCoursClassrooms();

	CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer classeId);

	void deleteCoursClassroom(Integer id);

	CoursClassroom updateCoursClassroom(CoursClassroom cc);

	CoursClassroom retrieveCoursClassroom(Integer id);
	
	public void desaffecterCoursClassroomClasse(Integer idCours); 
		
	public void archiverCoursClassrooms(); 
	
	public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv); 
	
}
