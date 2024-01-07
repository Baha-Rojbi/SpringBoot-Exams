package tn.esprit.examenlavage.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.examenlavage.Entities.*;
import tn.esprit.examenlavage.Repositories.ReservationRepository;
import tn.esprit.examenlavage.Repositories.VehiculeRepository;
import tn.esprit.examenlavage.Repositories.WashingServiceRepository;
import tn.esprit.examenlavage.Repositories.WorkerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@org.springframework.stereotype.Service
@AllArgsConstructor
@Slf4j
public class Service implements IService {
    private ReservationRepository reservationRepository;
    private VehiculeRepository vehiculeRepository;
    public WashingServiceRepository washingServiceRepository;
    private WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public void addWashingService(List<Washing_Service> washing_service) {
     for (Washing_Service ws:washing_service){
         washingServiceRepository.save(ws);
     }
    }

    @Override
    @Transactional
    public Vehicule addVehiculeReservationAndAffectToWashingservice(Vehicule vehicle, List<Long> idServices) {
        Set<Washing_Service> washingServices = new HashSet<>();
        for (Long id : idServices) {
            Washing_Service service = washingServiceRepository.findById(id).orElse(null);
            washingServices.add(service);
        }

        Vehicule savedVehicle = vehiculeRepository.save(vehicle);


        Reservation reservation = new Reservation();
        reservation.setStatus(Status.PENDING);
        reservation.setWorker(null);
        reservation.setWashingServices(washingServices);
        reservation.setTimeReservation(LocalDateTime.now().plusHours(2)); // System time + 2 hours

        Set<Reservation> reservations = new HashSet<>();
        reservations.add(reservation);
        savedVehicle.setReservationsVehicule(reservations);

        reservationRepository.save(reservation);

        return savedVehicle;
    }

    @Override
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation) {
        Worker worker=workerRepository.findByNic(nic);
        workerRepository.save(worker);
        Set<Reservation> reservations=new HashSet<>();
        for (Long id:idReservation){
            Reservation reservation=reservationRepository.findById(id).orElse(null);
            reservations.add(reservation);

        }
        for(Reservation reservation:reservations){
            if (worker.getReservationsWorker().size()+reservations.size()<=5){
                reservation.setStatus(Status.CONFIRMED);
                reservation.setWorker(worker);
            }
        }
        reservationRepository.saveAll(reservations);
        return worker;
    }

    @Override
    public float calculateTotalIncomePerWorker(String name, Type typeService) {
        float somme=0;
        Worker worker =workerRepository.findByName(name);
        Washing_Service ws=washingServiceRepository.getByType(typeService);
for (Reservation reservation: worker.getReservationsWorker()){
    for (Washing_Service washing_service:reservation.getWashingServices()){
        if(ws==washing_service && reservation.getStatus()==Status.CONFIRMED&& reservation.getTimeReservation().getMonth()==LocalDateTime.now().getMonth()){
            somme+=washing_service.getPrice();
        }
    }
}
        return somme;
    }

    @Override
    public Map<String, Long> getListServiceAndNbreservation() {
        Map<String ,Long> myliste = new HashMap<>();
        for (Washing_Service ws : washingServiceRepository.findAll()) {
            myliste.put(String.valueOf(ws.getType()), ws.getReservationsWashing().stream().count());
        }
        return myliste;
    }
    @Scheduled(fixedRate = 15000)
    public void getReservation(){

        List<Reservation> pendingReservations = reservationRepository.findReservationByStatusOrderByTimeReservation(Status.PENDING);
        for (Reservation reservation : pendingReservations) {
            // Process the reservation or just print it out
            log.info(String.valueOf(reservation.getIdReservation()));
        }
    }
}
