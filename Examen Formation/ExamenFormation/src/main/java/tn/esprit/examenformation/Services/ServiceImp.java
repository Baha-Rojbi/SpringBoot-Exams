package tn.esprit.examenformation.Services;

import tn.esprit.examenformation.Entities.Apprenant;
import tn.esprit.examenformation.Entities.Formateur;
import tn.esprit.examenformation.Entities.Formation;
import tn.esprit.examenformation.Repositories.ApprenantRepository;
import tn.esprit.examenformation.Repositories.FormateurRepository;
import tn.esprit.examenformation.Repositories.FormationRepository;

public class ServiceImp implements IServices{
    private ApprenantRepository apprenantRepository;
    private FormationRepository formationRepository;
    private FormateurRepository formateurRepository;

    @Override
    public void ajouterFormateur(Formateur formateur) {
        formateurRepository.save(formateur);
    }

    @Override
    public void ajouterApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant);
    }

    @Override
    public void ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur) {
        Formateur formateur=formateurRepository.findById(idFormateur).orElse(null);
        formation.setFormateur(formateur);
        formationRepository.save(formation);
    }

    @Override
    public void affecterApprenantFormation(Integer idApprenant, Integer idFormation) {
        Apprenant apprenant=apprenantRepository.findById(idApprenant).orElse(null);
        Formation formation=formationRepository.findById(idFormation).orElse(null);
        // Check for max participants
        if (formation.getNbrMaxParticipant() != null && formation.getApprenants().size() >= formation.getNbrMaxParticipant()) {
            throw new IllegalStateException("Maximum number of participants reached");
        }
        // Everything is okay; now we can add the apprenant to the formation
        formation.getApprenants().add(apprenant);
        formationRepository.save(formation); // Persist the changes in the database
    }
}
