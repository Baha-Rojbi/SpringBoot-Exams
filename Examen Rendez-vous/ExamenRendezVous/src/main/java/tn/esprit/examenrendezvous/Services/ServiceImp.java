package tn.esprit.examenrendezvous.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenrendezvous.Entities.*;
import tn.esprit.examenrendezvous.Repositories.CliniqueRepository;
import tn.esprit.examenrendezvous.Repositories.MedecinRepository;
import tn.esprit.examenrendezvous.Repositories.PatientRepository;
import tn.esprit.examenrendezvous.Repositories.RendezVousRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private CliniqueRepository cliniqueRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;
    private RendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Transactional
    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);

        if (clinique == null) {
            // Handle the case where the clinique doesn't exist
            throw new RuntimeException("Clinique with id: " + cliniqueId + " not found");
        }

        // Assuming Medecin and Clinique have the correct ManyToMany mappings,
        // you might need to add the Clinique to the Medecin's set of Cliniques
        // and vice versa because of the bidirectional relationship.

        // Likewise, you should update the Clinique's set of Medecins
        clinique.getMedecinsClinique().add(medecin);

        // Save the updated Medecin object with the relation to the Clinique
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
Medecin medecin=medecinRepository.findById(idMedecin).orElse(null);
    Patient patient=patientRepository.findById(idPatient).orElse(null);
    rdv.setMedecin(medecin);
    rdv.setPatient(patient);
rendezVousRepository.save(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepository.findRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        int nbre = medecin.getRendezVous().size();
        return nbre;
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        List<RendezVous> rendezVous =rendezVousRepository.findAllByMedecinIdMedecinAndDateRDVBetween(idMedecin,startDate,endDate);
        int nbrRdv=rendezVous.size();
        Medecin medecin=medecinRepository.findById(idMedecin).orElse(null);
        return nbrRdv*medecin.getPrixConsultation();
    }
@Scheduled(fixedRate = 15000)
    public void retrieveRendezVous(){
        List<RendezVous> RDVs = rendezVousRepository.findAll();
        for (RendezVous r:RDVs){
            if (r.getDateRDV().before(new Date())){
                log.info("La Liste des Rendez vous : "+r.getDateRDV()+" : Medecin : "+ r.getMedecin().getNomMedecin()+" : Patient : "+r.getPatient().getNomPatient());

            }
        }
    }
}
