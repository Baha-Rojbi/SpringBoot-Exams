package tn.esprit.examenlavage.Services;

import tn.esprit.examenlavage.Entities.Type;
import tn.esprit.examenlavage.Entities.Vehicule;
import tn.esprit.examenlavage.Entities.Washing_Service;
import tn.esprit.examenlavage.Entities.Worker;

import java.util.List;
import java.util.Map;

public interface IService {
    public Worker addWorker(Worker worker);
    public void addWashingService(List<Washing_Service> washing_service);
    public Vehicule addVehiculeReservationAndAffectToWashingservice(Vehicule vehicule,List<Long>idService);
    public Worker affectWorkertoReservation(String nic,List<Long>idReservation);
    public float calculateTotalIncomePerWorker(String name, Type typeService);
    public Map<String,Long>getListServiceAndNbreservation();
}
