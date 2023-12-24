package tn.esprit.examendatacenter.Services;

import tn.esprit.examendatacenter.Entitites.Datacenter;
import tn.esprit.examendatacenter.Entitites.Utilisateur;
import tn.esprit.examendatacenter.Entitites.VirtualMachine;

public interface IService {
    public void ajouterUser(Utilisateur u);
    public void ajouterDc(Datacenter datacenter);
    public int ajouterVm(VirtualMachine vm);
    public void affecterVmuser(int idvm, int iduser);
    public void affecterVm(int idvm);
    public void demarrerInstanceUser(int idvm);
    public void arreterInstanceUser(int idvm);
}
