package tn.esprit.examenlavage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenlavage.Entities.Reservation;
import tn.esprit.examenlavage.Entities.Status;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findReservationByStatusOrderByTimeReservation(Status status);
}
