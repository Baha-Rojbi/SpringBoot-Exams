package tn.esprit.examenrendezvous.RestController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examenrendezvous.Entities.*;
import tn.esprit.examenrendezvous.Services.IService;

import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService  iService;
    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique){
        return iService.addClinique(clinique);
    }
        @PostMapping("/addMedcineToClinique/{cliniqueId}")
    public Medecin addMedecinAndAssignToClinique (@RequestBody Medecin medecin,@PathVariable Long cliniqueId){
        return iService.addMedecinAndAssignToClinique(medecin, cliniqueId);
    }
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return iService.addPatient(patient);
    }
    @PostMapping("/addRDV/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,@PathVariable Long idMedecin,@PathVariable Long idPatient)
    {
        iService.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }
    @GetMapping("RDVByClinqueAndSpecialite/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique,@PathVariable Specialite specialite){
        return iService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
    @GetMapping("/nbreRDV/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin){
        return iService.getNbrRendezVousMedecin(idMedecin);
    }
    @GetMapping("/medecinRevenu/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        return iService.getRevenuMedecin(idMedecin, startDate, endDate);
    }
}
