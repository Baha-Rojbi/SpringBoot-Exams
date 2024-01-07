package tn.esprit.parking.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.parking.Entities.Parking;
import tn.esprit.parking.Entities.Personnel;
import tn.esprit.parking.Entities.Poste;
import tn.esprit.parking.Entities.Zone;
import tn.esprit.parking.Repositories.ParkingRepositories;
import tn.esprit.parking.Repositories.PersonnelRepositories;
import tn.esprit.parking.Repositories.ZoneRepositories;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServicesImp implements IServices{
    private ParkingRepositories parkingRepositories;
    private PersonnelRepositories personnelRepositories;
    private ZoneRepositories zoneRepositories;

    @Override
    public void ajouterPersonnel(Personnel personnel) {
        personnelRepositories.save(personnel);
    }

    @Override
    public void ajoutParkingetZones(Parking parking, List<Zone> listeZones) {
        Parking savedParking = parkingRepositories.save(parking);
        for (Zone zone : listeZones) {
            zone.setParking(savedParking);
            zoneRepositories.save(zone);
        }

    }

    @Override
    public List<Personnel> listerPersonnel() {
        return personnelRepositories.findAll();
    }

    @Override
    public void affecterPersonnelZone(int idzone, int idGarde, Poste poste) {
        Zone zone=zoneRepositories.findById(idzone).orElse(null);
        Personnel personnel=personnelRepositories.findById(idGarde).orElse(null);
        personnel.setZone(zone);
personnelRepositories.save(personnel);
    }
}
