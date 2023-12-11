package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Classe;
import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;
import tn.esprit.spring.repository.ClasseRepository;
import tn.esprit.spring.repository.CoursClassroomRepository;

@Service
@Slf4j
public class CoursClassroomServiceImpl implements ICoursClassroomService {
	
	@Autowired
	CoursClassroomRepository coursClassroomRepository;
	
	@Autowired
	ClasseRepository classeRepository;

	@Override
	public List<CoursClassroom> retrieveAllCoursClassrooms() {
		List<CoursClassroom> listCoursClassroom= coursClassroomRepository.findAll();
		for(CoursClassroom cc:listCoursClassroom)
		{
			log.info("CoursClassroom:" + cc.getIdCours() + " " + cc.getNom());
		}
		return listCoursClassroom;
	}

	@Override
	public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer classeId) {
		Classe classe= classeRepository.findById(classeId).get();
		cc.setClasse(classe);
		coursClassroomRepository.save(cc);
		return cc;
	}

	@Override
	public void deleteCoursClassroom(Integer id) {
		coursClassroomRepository.deleteById(id);

	}

	@Override
	public CoursClassroom updateCoursClassroom(CoursClassroom c) {
		coursClassroomRepository.save(c);
		return c;
	}

	@Override
	public CoursClassroom retrieveCoursClassroom(Integer id) {
		CoursClassroom cc= coursClassroomRepository.findById(id).get();
		return cc;
	}
 	 
	public void desaffecterCoursClassroomClasse(Integer idCours) 
	{ 
		CoursClassroom cc= coursClassroomRepository.findById(idCours).get();
		// Classe c= classeRepository.findById(idClasse).get();
		
		cc.setClasse(null);
		
		coursClassroomRepository.save(cc); 
		
	} 
	
	//@Scheduled(fixedDelay = 60000) 
	public void archiverCoursClassrooms()
	{
		List<CoursClassroom> ccs= coursClassroomRepository.findAll();
		
		for (CoursClassroom coursClassroom : ccs) {
			coursClassroom.setArchive(true);
			coursClassroomRepository.save(coursClassroom); 
		}
	}
	
	public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) 
	{
		return coursClassroomRepository.nbHeuresParSpecialiteEtdNiveau(sp, nv); 
	}

	

	// Por tester l'aspect : 
	//@Scheduled(fixedDelay = 60000) 
	public void ajouterTest()
	{

	}
	 
} 
 