package tn.esprit.bus.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bus.Entities.Etudiant;
import tn.esprit.bus.Services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {
    private IEtudiantService iEtudiantService;
    @PostMapping("/ajouterEtudiant")
    public void ajouterEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantService.ajouterEtudiant(etudiant);
    }
    @PostMapping("/affecterEtudiantProjet/{idEtudiant}/{idProjet}")
    public void affecterEtudiantProjet(@PathVariable int idEtudiant,@PathVariable int idProjet){
        iEtudiantService.affecterEtudiantProjet(idEtudiant,idProjet);
    }
    @GetMapping("/listerCollegues/{idEtudiant}/{idProjet}")
    public List<String> listerCollegues(@PathVariable int idEtudiant,@PathVariable int idProjet){
       return iEtudiantService.listerCollegues(idEtudiant,idProjet);
    }
    @PutMapping("/modifierEtudiants")
     public void modifierEtudiants(){
        iEtudiantService.modifierEtudiants();
    }
}
