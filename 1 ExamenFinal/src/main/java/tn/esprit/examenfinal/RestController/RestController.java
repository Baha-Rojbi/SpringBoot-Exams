package tn.esprit.examenfinal.RestController;

import jakarta.persistence.PostRemove;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examenfinal.Entities.*;
import tn.esprit.examenfinal.Services.IService;

import java.time.LocalDate;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/ajouterInternaute")
    Internaute ajouterInternaute(@RequestBody Internaute internaute){
        return iService.ajouterInternaute(internaute);
    }
    @PostMapping("/ajouterEvenement")
    Evenement ajouterEvenement(@RequestBody Evenement evenement){
        return iService.ajouterEvenement(evenement);
    }
    @PostMapping("/ajouterTicket/{idEvenement}/{idInternaute}")
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(@RequestBody List<Ticket> tickets, @PathVariable Long idEvenement,@PathVariable Long idInternaute){
        return iService.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets,idEvenement,idInternaute);
    }
    @GetMapping("/nbInternaute/{trancheAge}/{dateMin}/{dateMax}")
    Long nbInternauteParTrancheAgeEtDateEvenement(@PathVariable TrancheAge trancheAge, @PathVariable("dateMin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateMin, @PathVariable("dateMax") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateMax){
        return iService.nbInternauteParTrancheAgeEtDateEvenement(trancheAge,dateMin,dateMax);

    }
    @GetMapping("/montantRecupere/{nomEvt}/{typeTicket}")
    Double montantRecupereParEvtEtTypeTicket(@PathVariable String nomEvt,@PathVariable TypeTicket typeTicket){
        return iService.montantRecupereParEvtEtTypeTicket(nomEvt,typeTicket);
    }
    @GetMapping("/internauteActif")
    String internauteLePlusActif(){
        return iService.internauteLePlusActif();
    }
}
