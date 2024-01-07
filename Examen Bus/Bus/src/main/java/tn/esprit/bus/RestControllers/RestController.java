package tn.esprit.bus.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bus.Entities.Bus;
import tn.esprit.bus.Entities.Trajet;
import tn.esprit.bus.Entities.Utilisateur;
import tn.esprit.bus.Services.IService;

import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/ajouterTrajet")
    Trajet ajouterTrajet(@RequestBody Trajet trajet){
        return iService.ajouterTrajet(trajet);
    }
    @PostMapping("/ajouterEtudiant")
    Utilisateur ajouterEtudiant(@RequestBody Utilisateur etudiant){
        return iService.ajouterEtudiant(etudiant);
    }
        @PostMapping("/ajouterBusEtChauffeur")
    Bus ajouterBusEtChauffeur(@RequestBody Bus bus){
        return iService.ajouterBusEtChauffeur(bus);
    }
    @PutMapping("/affecterTrajetABus/{idBus}/{idTrajet}")
    Bus affecterTrajetABus(@PathVariable int idBus,@PathVariable int idTrajet){
        return iService.affecterTrajetABus(idBus,idTrajet);
    }
    @PutMapping("/affecterEtudiantABus/{numImma}/{nom}/{prenom}")
    String affecterEtudiantABus(@PathVariable String numImma,@PathVariable String nom,@PathVariable String prenom) {
        return iService.affecterEtudiantABus(numImma, nom, prenom);
    }
    @GetMapping("/afficherEtudiantsAvecTrajet/{idTrajet}/{dateInf}/{dateSup}")
    public List<Utilisateur> afficherEtudiantsAvecTrajet(@PathVariable int idTrajet,@DateTimeFormat(pattern = "yyyy-MM-dd")  @PathVariable Date dateInf,@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable Date dateSup){
        return iService.afficherEtudiantsAvecTrajet(idTrajet,dateInf,dateSup);
    }
}
