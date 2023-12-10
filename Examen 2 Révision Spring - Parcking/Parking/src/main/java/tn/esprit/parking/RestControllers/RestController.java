package tn.esprit.parking.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.parking.Entities.Parking;
import tn.esprit.parking.Entities.Personnel;
import tn.esprit.parking.Entities.Zone;
import tn.esprit.parking.Services.IServices;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IServices iServices;
    @PostMapping("/ajouterPersonnel")
    public void ajouterPersonnel(@RequestBody Personnel personnel){
        iServices.ajouterPersonnel(personnel);
    }
    @PostMapping("/ajoutParkingetZones")
    public void ajoutParkingetZones(@RequestBody Parking parking,@RequestBody List<Zone> listeZones){
        iServices.ajoutParkingetZones(parking,listeZones);
    }
}
