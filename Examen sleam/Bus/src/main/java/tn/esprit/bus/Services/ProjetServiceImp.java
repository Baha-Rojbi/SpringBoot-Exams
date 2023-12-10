package tn.esprit.bus.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.bus.Entities.Projet;
import tn.esprit.bus.Repositories.ProjetRepositories;

@Service
@AllArgsConstructor
public class ProjetServiceImp implements IProjetService{
    private ProjetRepositories projetRepositories;
    @Override
    public void ajouterProjet(Projet projet) {
        projetRepositories.save(projet);
    }
}
