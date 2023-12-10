package tn.esprit.bus.Services;

import tn.esprit.bus.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public void ajouterEtudiant(Etudiant etudiant);
    public void affecterEtudiantProjet(int idEtudiant, int idProjet);
    public List<String> listerCollegues(int idEtudiant, int idProjet);
    public void modifierEtudiants();
}
