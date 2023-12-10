package tn.esprit.bus.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.bus.Entities.Etudiant;
import tn.esprit.bus.Entities.Tuteur;
import tn.esprit.bus.Repositories.EtudiantRepositories;
import tn.esprit.bus.Repositories.TuteurRepositories;

@Service
@AllArgsConstructor
public class TuteurServiceImp implements ITuteurService {
    private TuteurRepositories tuteurRepositories;
    private EtudiantRepositories etudiantRepositories;

    @Override
    public void ajouterEtAffecterTuteur(Tuteur tuteur, int idEtudiant) {
        Etudiant etudiant=etudiantRepositories.findById(idEtudiant).orElse(null);
        tuteur.setEtudiant(etudiant);
        tuteurRepositories.save(tuteur);
    }
}
