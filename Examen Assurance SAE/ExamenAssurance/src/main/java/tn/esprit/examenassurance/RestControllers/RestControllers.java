package tn.esprit.examenassurance.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenassurance.Entities.Assurance;
import tn.esprit.examenassurance.Entities.Beneficiaire;
import tn.esprit.examenassurance.Entities.Contrat;
import tn.esprit.examenassurance.Entities.TypeContrat;
import tn.esprit.examenassurance.Services.IServices;

import java.util.Set;

@RestController
@AllArgsConstructor
public class RestControllers {
    private IServices iServices;
    @PostMapping("/ajouterBeneficiaire")
    public Beneficiaire ajouterBeneficiaire (@RequestBody Beneficiaire bf){
        return iServices.ajouterBeneficiaire(bf);
    }
    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat c){
        return iServices.ajouterContrat(c);
    }
    @PostMapping("/ajouterAssurance/{cinBf}/{matricule}")
    public Assurance ajouterAssurance(@RequestBody Assurance a, @PathVariable int cinBf,@PathVariable String matricule){
        return iServices.ajouterAssurance(a,cinBf,matricule);
    }
    @GetMapping("/getContratBf/{idBf}")
    public Contrat getContratBf(@PathVariable int idBf){
        return iServices.getContratBf(idBf);
    }
    @GetMapping("/getBeneficairesByType/{typeContrat}")
    public Set<Beneficiaire> getBeneficairesByType(@PathVariable TypeContrat typeContrat){
        return iServices.getBeneficairesByType(typeContrat);
    }
    @GetMapping("/getMontantBf/{cinBenef}")
    public float getMontantBf(@PathVariable("cinBenef") int cinBf){
        return iServices.getMontantBf(cinBf);
    }
}

