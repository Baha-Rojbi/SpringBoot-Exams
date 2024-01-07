package tn.esprit.examenpathologie.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examenpathologie.Entities.FamilleActe;
import tn.esprit.examenpathologie.Entities.Pathologie;
import tn.esprit.examenpathologie.Entities.Patient;
import tn.esprit.examenpathologie.Services.IService;

@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private IService  iService;
    @PostMapping("/ajouterPathologie")
    public Pathologie ajouterPathologie(@RequestBody Pathologie path){
return iService.ajouterPathologie(path);
    }
    @PostMapping("/ajouterPatientEtAffecterAPathologie/{codePath}")
    public Patient ajouterPatientEtAffecterAPathologie(@RequestBody Patient p,@PathVariable String codePath){
        return iService.ajouterPatientEtAffecterAPathologie(p,codePath);
    }
    @PostMapping("/ajouterFamilleActeEtActeAssocie")
    public FamilleActe ajouterFamilleActeEtActeAssocie(@RequestBody FamilleActe facte){
        return iService.ajouterFamilleActeEtActeAssocie(facte);

    }
    @PostMapping("/affecterActeAPathologie/{codeActe}/{codePathologie}")
    public void affecterActeAPathologie(@PathVariable String codeActe ,@PathVariable String codePathologie){
        iService.affecterActeAPathologie(codeActe,codePathologie);
    }
    @GetMapping("/calculerFacture/{identifiant}")
    public float calculerFacture(@PathVariable String identifiant){
        return iService.calculerFacture(identifiant);
    }
}
