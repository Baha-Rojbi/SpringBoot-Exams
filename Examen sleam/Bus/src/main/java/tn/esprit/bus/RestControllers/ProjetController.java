package tn.esprit.bus.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bus.Entities.Projet;
import tn.esprit.bus.Services.IProjetService;

@RestController
@AllArgsConstructor
public class ProjetController {
    private IProjetService iProjetService;
    @PostMapping("/ajouterProjet")
    public void ajouterProjet(@RequestBody Projet projet){
        iProjetService.ajouterProjet(projet);
    }
}
