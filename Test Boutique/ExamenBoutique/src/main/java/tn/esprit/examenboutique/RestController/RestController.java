package tn.esprit.examenboutique.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examenboutique.Entities.Boutique;
import tn.esprit.examenboutique.Entities.Categorie;
import tn.esprit.examenboutique.Entities.CentreCommercial;
import tn.esprit.examenboutique.Entities.Client;
import tn.esprit.examenboutique.Services.IService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/ajoutCentre")
    void ajoutCentre(@RequestBody CentreCommercial centre) {
        System.out.println(centre.getBoutiques()); // Ajoutez cette ligne pour le débogage
        iService.ajoutCentre(centre);
    }
    @PostMapping("/boutiques/{idCentre}")
    public void ajouterEtAffecterlisteBoutiques(@RequestBody List<Boutique> listeBoutiques, @PathVariable Long idCentre) {
        iService.ajouterEtAffecterlisteBoutiques(listeBoutiques, idCentre);
    }
    @PostMapping("/clientBoutique/{idBoutiques}")
    public void ajouterEtAffecterClientBoutiques(@RequestBody Client client, @PathVariable List<Long> idBoutiques) {
        iService.ajouterEtAffecterClientBoutiques(client,idBoutiques);
    }
    @GetMapping("/clients/{idBoutique}")
    public List<Client> listeClients(@PathVariable Long idBoutique){
        return iService.listeClients(idBoutique);
    }
    @GetMapping("/boutiques/{idCentre}")
    public List<Boutique> listeBoutiques(@PathVariable Long idCentre){
        return iService.listeBoutiques(idCentre);
    }
    @GetMapping("/parCategorie/{categorie}")
    public List<Client> listeDeClientsParCategorie(@PathVariable Categorie categorie) {
        return iService.listeDeClientsParCategorie(categorie);
    }
}
