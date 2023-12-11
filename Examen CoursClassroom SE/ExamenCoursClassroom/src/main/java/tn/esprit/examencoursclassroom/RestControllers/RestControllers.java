package tn.esprit.examencoursclassroom.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examencoursclassroom.Entities.Classe;
import tn.esprit.examencoursclassroom.Entities.CoursClassroom;
import tn.esprit.examencoursclassroom.Entities.Niveau;
import tn.esprit.examencoursclassroom.Entities.Utilisateur;
import tn.esprit.examencoursclassroom.Services.IServices;

@RestController
@AllArgsConstructor

public class RestControllers {
private IServices iServices;
@PostMapping("/ajouterUtilisateur")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return iServices.ajouterUtilisateur(utilisateur);
    }
    @PostMapping("/ajouterClasse")
    public Classe ajouterClasse(@RequestBody Classe c){
        return iServices.ajouterClasse(c);
    }
    @PostMapping("/ajouterCoursClassroom/{codeClasse}")
    public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc,@PathVariable Integer codeClasse){
        return iServices.ajouterCoursClassroom(cc,codeClasse);
    }
    @PutMapping("/affecterUtilisateurClasse/{idUtilisateur}/{codeClasse}")
    public void affecterUtilisateurClasse(@PathVariable Integer idUtilisateur,@PathVariable Integer codeClasse){
        iServices.affecterUtilisateurClasse(idUtilisateur,codeClasse);
    }
    @GetMapping("/nbUtilisateursParNiveau/{nv}")
    public Integer nbUtilisateursParNiveau(@PathVariable Niveau nv){
    return iServices.nbUtilisateursParNiveau(nv);
    }
    @PutMapping("/desaffecterCoursClassroomClasse/{idCours}")
    public void desaffecterCoursClassroomClasse(@PathVariable Integer idCours){
        iServices.desaffecterCoursClassroomClasse(idCours);
    }
}
