package tn.esprit.examenfinal.Services;

import tn.esprit.examenfinal.Entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IService {
    Internaute ajouterInternaute(Internaute internaute);
    Evenement ajouterEvenement(Evenement evenement);
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets,Long idEvenement,Long idInternaute);
    Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin,LocalDate dateMax);
    Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket);
    String internauteLePlusActif();
}
