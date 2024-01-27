package tn.esprit.examencoursclassroom.Services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examencoursclassroom.Entities.*;
import tn.esprit.examencoursclassroom.Repositories.ClassseRepository;
import tn.esprit.examencoursclassroom.Repositories.CoursClassroomRepository;
import tn.esprit.examencoursclassroom.Repositories.UtilisateurRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServicesImp implements IServices{
    private ClassseRepository classseRepository;
    private CoursClassroomRepository coursClassroomRepository;
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classseRepository.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe classe=classseRepository.findById(codeClasse).orElse(null);
        cc.setClasse(classe);
        return coursClassroomRepository.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
Utilisateur utilisateur=utilisateurRepository.findById(idUtilisateur).orElse(null);
Classe classe=classseRepository.findById(codeClasse).orElse(null);
utilisateur.setClassUser(classe);
utilisateurRepository.save(utilisateur);
    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {

return utilisateurRepository.findByClassUser_Niveau(nv).size();

    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
CoursClassroom coursClassroom=coursClassroomRepository.findById(idCours).orElse(null);
coursClassroom.setClasse(null);
coursClassroomRepository.save(coursClassroom);
    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        return coursClassroomRepository.nbHeuresParSpecEtNiv(sp, nv);
    }
    @Scheduled(fixedRate = 60000)
    public void archiverCoursClassrooms(){
List<CoursClassroom> coursClassrooms=coursClassroomRepository.findAll();
for (CoursClassroom coursClassroom:coursClassrooms){
    coursClassroom.setArchieve(true);
    coursClassroomRepository.save(coursClassroom);
    log.info("cours archive : "+coursClassroom.getNom());
}}


}
