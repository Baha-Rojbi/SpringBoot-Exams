package tn.esprit.examenformation.Services;

import tn.esprit.examenformation.Entities.Apprenant;
import tn.esprit.examenformation.Entities.Formateur;
import tn.esprit.examenformation.Entities.Formation;

public interface IServices {
    public void ajouterFormateur(Formateur formateur);
    public void ajouterApprenant (Apprenant apprenant);
    public void ajouterEtAffecterFormationAFormateur (Formation formation, Integer idFormateur);
    public void affecterApprenantFormation (Integer idApprenant, Integer idFormation);
}
