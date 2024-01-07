package tn.esprit.examenlavage.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenlavage.Entities.Type;
import tn.esprit.examenlavage.Entities.Vehicule;
import tn.esprit.examenlavage.Entities.Washing_Service;
import tn.esprit.examenlavage.Entities.Worker;
import tn.esprit.examenlavage.Services.IService;

import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/addWorker")
    public Worker addWorker(@RequestBody Worker worker){
        return iService.addWorker(worker);
    }
    @PostMapping("/addWashingService")
    public void addWashingService(@RequestBody List<Washing_Service> washing_service){
        iService.addWashingService(washing_service);
    }
    @PostMapping("/addVehicule/{idService}")
    public Vehicule addVehiculeReservationAndAffectToWashingservice(@RequestBody Vehicule vehicule,@PathVariable List<Long>idService){
        return iService.addVehiculeReservationAndAffectToWashingservice(vehicule,idService);
    }
    @PutMapping("/affecterWorkerReservation/{nic}/{idReservation}")
    public Worker affectWorkertoReservation(@PathVariable String nic,@PathVariable List<Long>idReservation){
        return iService.affectWorkertoReservation(nic,idReservation);
    }
    @GetMapping("/calculerIncome/{name}/{typeService}")
    public float calculateTotalIncomePerWorker(@PathVariable String name,@PathVariable Type typeService){
        return iService.calculateTotalIncomePerWorker(name,typeService);
    }
    @GetMapping("/getListServiceAndNbreservation")
    public Map<String, Long> getListServiceAndNbreservation(){
        return iService.getListServiceAndNbreservation();
    }
}
