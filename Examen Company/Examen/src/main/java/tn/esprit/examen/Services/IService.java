package tn.esprit.examen.Services;

import tn.esprit.examen.Entities.Campany;
import tn.esprit.examen.Entities.Donation;
import tn.esprit.examen.Entities.DonationType;
import tn.esprit.examen.Entities.Employe;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IService {
    public Campany addCampany(Campany campany);
    public Employe addEmployeAndAssignToCampany(Employe employe ,String  campanyName);
    public Donation addDonation(Donation donation);
    public Set<Donation> getDonationByType(DonationType type);
    public List<Employe> getEmployeByArea(String companyName,String area);
    public Float getTotalDonation(Date date1,Date date2);
}
