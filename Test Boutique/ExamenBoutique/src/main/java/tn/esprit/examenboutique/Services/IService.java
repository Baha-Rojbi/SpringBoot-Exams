package tn.esprit.examenboutique.Services;

import tn.esprit.examenboutique.Entities.Boutique;
import tn.esprit.examenboutique.Entities.Categorie;
import tn.esprit.examenboutique.Entities.CentreCommercial;
import tn.esprit.examenboutique.Entities.Client;

import java.util.List;

public interface IService {
    void ajoutCentre(CentreCommercial centre);
    void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
    List<Client> listeClients(Long idBoutique);
    List<Boutique> listeBoutiques(Long idCentre);
    List<Client> listeDeClientsParCategorie(Categorie categorie);



}
