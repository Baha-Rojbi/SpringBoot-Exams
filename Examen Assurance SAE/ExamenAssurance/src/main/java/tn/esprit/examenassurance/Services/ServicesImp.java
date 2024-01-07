package tn.esprit.examenassurance.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenassurance.Entities.Assurance;
import tn.esprit.examenassurance.Entities.Beneficiaire;
import tn.esprit.examenassurance.Entities.Contrat;
import tn.esprit.examenassurance.Entities.TypeContrat;
import tn.esprit.examenassurance.Repositories.AssuranceRepository;
import tn.esprit.examenassurance.Repositories.BeneficiaireRepository;
import tn.esprit.examenassurance.Repositories.ContratRepository;

import java.util.*;
import java.util.Map.Entry;

@Slf4j
@Service
@AllArgsConstructor
public class ServicesImp implements IServices{
    private AssuranceRepository assuranceRepository;
    private BeneficiaireRepository beneficiaireRepository;
    private ContratRepository contratRepository;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireRepository.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Beneficiaire beneficiaire=beneficiaireRepository.findByCin(cinBf);
        Contrat contrat=contratRepository.findByMatricule(matricule);
        a.setBeneficiaire(beneficiaire);
        a.setContrat(contrat);
        return assuranceRepository.save(a);
    }
/*    public Contrat getContratBf(int idBf) {
        List<Assurance> assurances = assuranceRepository.findByBeneficiaireIdBenef(idBf);

        return assurances.stream()
                .map(Assurance::getContrat)
                .filter(c -> c != null)
                .distinct()
                .sorted(Comparator.comparing(Contrat::getDateEffet))
                .findFirst()
                .orElse(null);
    }*/
    @Override
    public Contrat getContratBf(int idBf) {
        List<Assurance> assurances = assuranceRepository.findAssurancesByBeneficiaireIdOrderByContratDateEffetAsc(idBf);

            // Since the list is ordered by date, the first element is the oldest contract
            return assurances.get(0).getContrat();

    }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {
        return assuranceRepository.findBeneficiairesByContratType(typeContrat);
    }

    @Override
    public float getMontantBf(int cinBf) {

        Beneficiaire beneficiaire = beneficiaireRepository.findByCin(cinBf);

        float montantContrat = 0;
        for (Assurance ass : beneficiaire.getAssurances()) {
            if (ass.getContrat().getType() == TypeContrat.Mensuel) {
                montantContrat += ass.getMontant() * 12;
            } else if (ass.getContrat().getType() == TypeContrat.Semestriel) {
                montantContrat += ass.getMontant() * 2;
            } else {
                montantContrat += ass.getMontant();
            }
        }
        return montantContrat;
    }
    @Scheduled(fixedRate = 60000)
    @Transactional
    public void statistiques() {

        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());

        for (Beneficiaire b : beneficiaireRepository.findAll()) {
            myStat.put(b.getAssurances().size(), b.getCin());
        }
        for (Entry<Integer, Integer> va : myStat.entrySet()) {
            log.info(("Nombre d assurances ")+va.getKey() + "| Cin du beneficiaire" + va.getValue());
        }
    }
    }

