package tn.esprit.bus.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.bus.Entities.Etudiant;
import tn.esprit.bus.Entities.Projet;
import tn.esprit.bus.Repositories.EtudiantRepositories;
import tn.esprit.bus.Repositories.ProjetRepositories;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiantService{
    private EtudiantRepositories etudiantRepositories;
    private ProjetRepositories projetRepositories;
    @Override
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiantRepositories.save(etudiant);
    }

    @Override
    public void affecterEtudiantProjet(int idEtudiant, int idProjet) {
       Etudiant etudiant= etudiantRepositories.findById(idEtudiant).orElse(null);
        Projet projet=projetRepositories.findById(idProjet).orElse(null);
        projet.getEtudiants().add(etudiant);
        projetRepositories.save(projet);
    }

    @Override
    public List<String> listerCollegues(int idEtudiant, int idProjet) {
        return etudiantRepositories.findColleaguesLogins(idEtudiant,idProjet);
    }

    @Override
    public void modifierEtudiants() {
        // Récupérer le projet ERP avec idProjet=3
        Projet projetERP = projetRepositories.findById(3).orElse(null);
        // Trouver tous les étudiants qui sont associés à exactement un projet
        List<Etudiant> etudiantsUnSeulProjet = etudiantRepositories.findAll().stream()
                .filter(etudiant -> etudiant.getProjets() != null && etudiant.getProjets().size() == 1)
                .collect(Collectors.toList());
        //methode avec JPARepositories au lieu du code Java
        ///List<Etudiant> etudiantsUnSeulProjet = etudiantRepository.findEtudiantsWithOnlyOneProjet();
        // Ajouter ces étudiants au projet ERP
        etudiantsUnSeulProjet.forEach(etudiant -> {
            projetERP.getEtudiants().add(etudiant);
            // Dans le cas où la relation est gérée par l'autre côté:
            etudiant.getProjets().add(projetERP);
        });
        projetRepositories.save(projetERP);
    }
}
