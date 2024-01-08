package tn.esprit.examenfinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenfinal.Entities.Ticket;
import tn.esprit.examenfinal.Entities.TypeTicket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query("select sum(t.prixTicket) from Ticket t where t.typeTicket=:typeTicket and t.evenement.nomEvenement=:nomEvt")
    Double countSomme(@Param("nomEvt") String nomEvt,@Param("typeTicket") TypeTicket typeTicket);
}
