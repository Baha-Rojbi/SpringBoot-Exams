package tn.esprit.examen.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.Entities.Campany;
import tn.esprit.examen.Entities.Donation;
import tn.esprit.examen.Entities.DonationType;
import tn.esprit.examen.Entities.Employe;
import tn.esprit.examen.Repositories.CampanyRepository;
import tn.esprit.examen.Repositories.DonationRepository;
import tn.esprit.examen.Repositories.EmployeRepository;
import tn.esprit.examen.Repositories.RedCrescentRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceImp implements IService{
    private CampanyRepository campanyRepository;
    private DonationRepository donationRepository;
    private EmployeRepository employeRepository;
    private RedCrescentRepository redCrescentRepository;

    @Override
    public Campany addCampany(Campany campany) {
        return campanyRepository.save(campany );
    }

    @Override
    public Employe addEmployeAndAssignToCampany(Employe employe, String campanyName) {
        Campany campany=campanyRepository.findByCampanyName(campanyName);
        employe.setCampany(campany);
        return employeRepository.save(employe);
    }

    @Override
    public Donation addDonation(Donation donation) {
        if(donation.getType()!=DonationType.MONETARY){
            donation.setAmount(0);
        }
        return donationRepository.save(donation);
    }

    @Override
    public Set<Donation> getDonationByType(DonationType type) {
        return donationRepository.findByTypeOrderByDate(type);
    }

    @Override
    public List<Employe> getEmployeByArea(String companyName, String area) {
        return null;
    }

    @Override
    public Float getTotalDonation(Date date1, Date date2) {
        return null;
    }
    @Scheduled()
    public void getEmployeByDonation(){

    }
}
