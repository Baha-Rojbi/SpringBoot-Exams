package tn.esprit.examenpathologie.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.examenpathologie.Entities.Acte;
import tn.esprit.examenpathologie.Entities.FamilleActe;
import tn.esprit.examenpathologie.Entities.Pathologie;
import tn.esprit.examenpathologie.Entities.Patient;
import tn.esprit.examenpathologie.Repositories.ActeRepository;
import tn.esprit.examenpathologie.Repositories.FamillieActeRepository;
import tn.esprit.examenpathologie.Repositories.PathologieRepository;
import tn.esprit.examenpathologie.Repositories.PatientRepository;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private ActeRepository acteRepository;
    private FamillieActeRepository famillieActeRepository;
    private PathologieRepository pathologieRepository;
    private PatientRepository patientRepository;

    @Override
    public Pathologie ajouterPathologie(Pathologie path) {
        path.setArchive(false);
        return pathologieRepository.save(path);
    }

    @Override
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath) {
        Pathologie pathologie=pathologieRepository.findByCodePath(codePath);
        p.getPathologies().add(pathologie);
        return patientRepository.save(p);
    }

    @Override
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte) {
        return famillieActeRepository.save(facte);
    }

    @Override
    public void affecterActeAPathologie(String codeActe, String codePathologie) {
        Acte acte=acteRepository.findByCodeActe(codeActe);
        Pathologie pathologie=pathologieRepository.findByCodePathAndArchiveIsFalse(codePathologie);
        pathologie.getActesPathologie().add(acte);
        pathologieRepository.save(pathologie);
    }

    @Override
    public float calculerFacture(String identifiant) {
        Pathologie pathologie=pathologieRepository.findByCodePathOrLibel(identifiant);
        float somme=0;
        if (!pathologie.getArchive()){
            for (Acte acte:pathologie.getActesPathologie()) {
                somme+=acte.getCotationActe()*acte.getPrixUnitaireActe();
            }
        }
        return somme;
    }
    @Scheduled
    public void calculerNombreActesParPathologie(){
        List<Pathologie> pathologies =pathologieRepository.findAll();
        for (Pathologie pathologie:pathologies){
            log.info("Pathologie : "+ pathologie.getLibelle()+" a "+pathologie.getActesPathologie().size());
        }
    }
}
