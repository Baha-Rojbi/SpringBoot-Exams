package tn.esprit.bus.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bus.Entities.Tuteur;
import tn.esprit.bus.Services.ITuteurService;

@RestController
@AllArgsConstructor
public class TuteurController {
    private ITuteurService iTuteurService;
    @PostMapping("/ajouterEtAffecterTuteur/{idEtudiant}")
    public void ajouterEtAffecterTuteur (@RequestBody Tuteur tuteur,@PathVariable int idEtudiant){
        iTuteurService.ajouterEtAffecterTuteur(tuteur,idEtudiant);
    }
}
