package tn.esprit.examencoursclassroom.Services;

import tn.esprit.examencoursclassroom.Entities.*;

public interface IServices {
    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur);
    public Classe ajouterClasse (Classe c);
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);
    public Integer nbUtilisateursParNiveau(Niveau nv);
    public void desaffecterCoursClassroomClasse(Integer idCours);
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);

}
