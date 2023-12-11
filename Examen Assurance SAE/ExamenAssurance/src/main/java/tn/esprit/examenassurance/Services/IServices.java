package tn.esprit.examenassurance.Services;

import tn.esprit.examenassurance.Entities.Assurance;
import tn.esprit.examenassurance.Entities.Beneficiaire;
import tn.esprit.examenassurance.Entities.Contrat;
import tn.esprit.examenassurance.Entities.TypeContrat;

import java.util.Set;

public interface IServices {
    public Beneficiaire ajouterBeneficiaire (Beneficiaire bf);
    public Contrat ajouterContrat (Contrat c);
    public Assurance ajouterAssurance (Assurance a, int cinBf, String matricule);
    public Contrat getContratBf (int idBf);
    public Set<Beneficiaire> getBeneficairesByType (TypeContrat typeContrat);
    public float getMontantBf (int cinBf);

}
