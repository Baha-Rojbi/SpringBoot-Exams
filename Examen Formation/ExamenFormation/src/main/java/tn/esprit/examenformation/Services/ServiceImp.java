package tn.esprit.examenformation.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenformation.Entities.Apprenant;
import tn.esprit.examenformation.Entities.Formateur;
import tn.esprit.examenformation.Entities.Formation;
import tn.esprit.examenformation.Repositories.ApprenantRepository;
import tn.esprit.examenformation.Repositories.FormateurRepository;
import tn.esprit.examenformation.Repositories.FormationRepository;

import java.text.Normalizer;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
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
if(formation.getApprenants().size()<formation.getNbrMaxParticipant()){
 formation.getApprenants().add(apprenant);
 formationRepository.save(formation);
}
    }

    @Override
    public Integer calculateRemuneration(Integer idFormateur, Date dateDebut, Date dateFin) {
        int nbreHeure= formationRepository.sumFormationHoursForFormateur(idFormateur,dateDebut,dateFin);
        Formateur formateur=formateurRepository.findById(idFormateur).orElse(null);
        return nbreHeure*formateur.getTarifHoraire();
    }

    @Override
    public Integer getRevenuByFormation(Integer idFormation) {
        Formation formation=formationRepository.findById(idFormation).orElse(null);
        return formation.getApprenants().size()*formation.getFrais();
    }
    @Scheduled(fixedRate = 30000)
    public void getNbrApprenantByFormation (){
List<Formation> formations=formationRepository.findAll();
for (Formation formation:formations){
    log.info("La formation : "+formation.getTitre()+" contient : "+ formation.getApprenants().size()+" apprenants");
}
    }
}
