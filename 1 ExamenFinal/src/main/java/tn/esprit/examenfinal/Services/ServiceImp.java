package tn.esprit.examenfinal.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenfinal.Entities.*;
import tn.esprit.examenfinal.Repositories.CategorieRepository;
import tn.esprit.examenfinal.Repositories.EvenementRepository;
import tn.esprit.examenfinal.Repositories.InternauteRepository;
import tn.esprit.examenfinal.Repositories.TicketRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private CategorieRepository categorieRepository;
    private EvenementRepository evenementRepository;
    private InternauteRepository internauteRepository;
    private TicketRepository ticketRepository;


    @Override
    public Internaute ajouterInternaute(Internaute internaute) {
        return internauteRepository.save(internaute);
    }

    @Override
    public Evenement ajouterEvenement(Evenement evenement) {
        evenementRepository.save(evenement);

        return evenement;
    }

    @Override
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute) {
        Evenement evenement=evenementRepository.findById(idEvenement).orElse(null);
        Internaute internaute=internauteRepository.findById(idInternaute).orElse(null);
        Long nbrePlace=evenement.getNbPlacesRestants();
        for (Ticket ticket : tickets) {
            if(nbrePlace>=tickets.size()-1){
                ticket.setEvenement(evenement);
                ticket.setInternaute(internaute);
                nbrePlace-=1;
            }else {
                throw new java.lang.UnsupportedOperationException("nombre de places demandées idisponible");
            }
        }
        evenement.setNbPlacesRestants(nbrePlace);
        evenementRepository.save(evenement);
        ticketRepository.saveAll(tickets);
        return tickets;
    }

    @Override
    public Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax) {
        List<Internaute> internautes =internauteRepository.findByTrancheAge(trancheAge);
        List<Evenement> evenements=evenementRepository.findByDateEvenementBetween(dateMin,dateMax);
        int nbrInternaute=internautes.size();
        for (Evenement evenement:evenements){
            for (Internaute internaute : internautes){
                if (evenement.getTicketsEvenement().contains(internaute.getTicketsInternaute())){
                    nbrInternaute=internautes.size();
                }
            }
        }
        return (long) nbrInternaute;
    }

    @Override
    public Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket) {
        return ticketRepository.countSomme(nomEvt, typeTicket);
    }

    @Override
    public String internauteLePlusActif() {
        List<Internaute> internautes =internauteRepository.findAll();
        String identifiant="";
        int maxTicket=0;
        for (Internaute internaute : internautes) {
            if(internaute.getTicketsInternaute().size()>maxTicket) {
                maxTicket = internaute.getTicketsInternaute().size();
                identifiant=internaute.getIdentifiant();
            }
        }
        return identifiant;
    }
    @Scheduled(fixedRate = 15000)
    void listeEvenementsParCategory(){
        List<Categorie> categories=categorieRepository.findAll();
        for (Categorie categorie:categories){
            log.info("Categorie "+categorie.getNomCategorie());
            Set<Evenement> evenements=categorie.getEvenements();
            for(Evenement evenement:evenements){
                log.info("Evenemnt "+evenement.getNomEvenement()+" planifie le "+evenement.getDateEvenement());
            }
        }
    }

}
