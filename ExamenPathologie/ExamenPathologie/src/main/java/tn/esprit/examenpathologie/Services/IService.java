package tn.esprit.examenpathologie.Services;

import tn.esprit.examenpathologie.Entities.FamilleActe;
import tn.esprit.examenpathologie.Entities.Pathologie;
import tn.esprit.examenpathologie.Entities.Patient;

public interface IService {
    public Pathologie ajouterPathologie(Pathologie path);
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath);
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte);
    public void affecterActeAPathologie(String codeActe , String codePathologie);
    public float calculerFacture(String identifiant);

}
