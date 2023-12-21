package tn.esprit.examenformation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenformation.Entities.Apprenant;
import tn.esprit.examenformation.Entities.Formateur;
import tn.esprit.examenformation.Entities.Formation;
import tn.esprit.examenformation.Services.IServices;

import java.util.Date;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IServices iServices;
    @PostMapping("/ajouterFormateur")
    public void ajouterFormateur(@RequestBody Formateur formateur){
        iServices.ajouterFormateur(formateur);
    }
    @PostMapping("/ajouterApprenant")
    public void ajouterApprenant (@RequestBody Apprenant apprenant){
        iServices.ajouterApprenant(apprenant);
    }
    @PostMapping("/ajouterEtAffecterFormationAFormateur/{idFormateur}")
    public void ajouterEtAffecterFormationAFormateur (@RequestBody Formation formation,@PathVariable Integer idFormateur)
    {
        iServices.ajouterEtAffecterFormationAFormateur(formation,idFormateur);
    }
    @PutMapping("/affecterApprenantFormation/{idApprenant}/{idFormation}")
    public void affecterApprenantFormation (@PathVariable Integer idApprenant,@PathVariable Integer idFormation){
        iServices.affecterApprenantFormation(idApprenant,idFormation);
    }
    @GetMapping("/remuneration/{idFormateur}/{dateDebut}/{dateFin}")
    public Integer getFormateurRemunerationByDate(
            @PathVariable("idFormateur") Integer idFormateur,
            @PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin
    ) {
        return iServices.calculateRemuneration(idFormateur, dateDebut, dateFin);
    }
    @GetMapping("/revenu/{idFormation}")
    public Integer getRevenuByFormation(@PathVariable Integer idFormation){
        return iServices.getRevenuByFormation(idFormation);
    }
}
