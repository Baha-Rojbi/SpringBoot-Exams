package tn.esprit.examenboutique.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenboutique.Entities.*;
import tn.esprit.examenboutique.Repositories.BoutiqueRepository;
import tn.esprit.examenboutique.Repositories.CentreCommercialRepository;
import tn.esprit.examenboutique.Repositories.ClientRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private BoutiqueRepository boutiqueRepository;
    private CentreCommercialRepository centreCommercialRepository;
    private ClientRepository clientRepository;
    @Override
    public void ajoutCentre(CentreCommercial centre) {
    centreCommercialRepository.save(centre);
    for (Boutique boutique: centre.getBoutiques())
    {
     boutique.setCentreCommercial(centre);
     boutiqueRepository.save(boutique);
    }
    }





    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommercial centreCommercial = centreCommercialRepository.findById(idCentre).orElse(null);
        for(Boutique boutique:lb){
            boutique.setCentreCommercial(centreCommercial);

        }
        boutiqueRepository.saveAll(lb);
    }

    @Override
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
       List<Boutique> boutiques= boutiqueRepository.findAllById(idBoutiques);
        Set<Boutique> set = new HashSet<>(boutiques);
           client.setBoutiquesClient(set);
        clientRepository.save(client);
    }

    @Override
    public List<Client> listeClients(Long idBoutique) {
        Boutique boutique=boutiqueRepository.findById(idBoutique).orElse(null);
        return boutique.getClients().stream().toList();
    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        CentreCommercial centreCommercial =centreCommercialRepository.findById(idCentre).orElse(null);
        return centreCommercial.getBoutiques().stream().toList();
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
        return clientRepository.findClientsByBoutiquesCategorie(categorie);
    }
@Scheduled(fixedRate = 30000)
    void nbreClientParGenre(){
        int nbreFeminin = clientRepository.countByGenre(Genre.FEMININ);
        int nbreMasculin = clientRepository.countByGenre(Genre.MASCULIN);
log.info("nbreFeminin " + nbreFeminin  );
log.info("nbreMasculin " + nbreMasculin);
    }
}

