package tn.esprit.parking.Services;

import tn.esprit.parking.Entities.Parking;
import tn.esprit.parking.Entities.Personnel;
import tn.esprit.parking.Entities.Poste;
import tn.esprit.parking.Entities.Zone;

import java.util.List;

public interface IServices {
    void ajouterPersonnel(Personnel personnel);
    void ajoutParkingetZones(Parking parking, List<Zone> listeZones);
    List<Personnel> listerPersonnel();
    void affecterPersonnelZone(int idzone, int idGarde, Poste poste);
}
