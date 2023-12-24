package tn.esprit.examendatacenter.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examendatacenter.Entitites.Datacenter;
import tn.esprit.examendatacenter.Entitites.Etat;
import tn.esprit.examendatacenter.Entitites.Utilisateur;
import tn.esprit.examendatacenter.Entitites.VirtualMachine;
import tn.esprit.examendatacenter.Repositories.DatacenterRepository;
import tn.esprit.examendatacenter.Repositories.UtilisateurRepository;
import tn.esprit.examendatacenter.Repositories.VirtualMachineRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private DatacenterRepository datacenterRepository;
    private UtilisateurRepository utilisateurRepository;
    private VirtualMachineRepository virtualMachineRepository;
    @Override
    public void ajouterUser(Utilisateur u) {
        utilisateurRepository.save(u);
    }

    @Override
    public void ajouterDc(Datacenter datacenter) {
        datacenterRepository.save(datacenter);
    }

    @Override
    public int ajouterVm(VirtualMachine vm) {
        virtualMachineRepository.save(vm);
        return vm.getIdVm();
    }

    @Override
    public void affecterVmuser(int idvm, int iduser) {
        Utilisateur utilisateur=utilisateurRepository.findById(iduser).orElse(null);
        VirtualMachine virtualMachine=virtualMachineRepository.findById(idvm).orElse(null);
        utilisateur.getVirtualMachinesUser().add(virtualMachine);
        utilisateurRepository.save(utilisateur);

    }

    @Override
    public void affecterVm(int idvm) {
        VirtualMachine vm = virtualMachineRepository.findById(idvm).orElse(null);
        for(Datacenter dc : datacenterRepository.findAll()){
            if(dc.getEspaceLibreDisque()>vm.getTailleDisque()){
                vm.setDatacenter(dc);
                dc.setEspaceLibreDisque(dc.getEspaceLibreDisque()-vm.getTailleDisque());
                datacenterRepository.save(dc);
                virtualMachineRepository.save(vm);
            }else{
                log.info("virtual machine Complete");
            }
        }
    }

    @Override
    public void demarrerInstanceUser(int idvm) {
        VirtualMachine vm=virtualMachineRepository.findById(idvm).orElse(null);
        vm.setEtat(Etat.RUNNING);
        virtualMachineRepository.save(vm);
    }

    @Override
    public void arreterInstanceUser(int idvm) {
        VirtualMachine vm=virtualMachineRepository.findById(idvm).orElse(null);
        vm.setEtat(Etat.STOPPED);
        virtualMachineRepository.save(vm);
    }
    @Scheduled(fixedRate = 30000)
    public List<Datacenter> listerDatacenter(){
        // Create a LocalDate instance from a string
        LocalDate localDate = LocalDate.parse("2019-11-01");

        // Convert LocalDate to Date
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Now you can use the date to call the repository method
        List<Datacenter> datacenters = datacenterRepository.findByDateFabricationAfter(date);
        for (Datacenter datacenter : datacenters){
            log.info((" DataCenter: "+ datacenter.getRegion()+" conatins the virtualmachines"));
            for (VirtualMachine vm: datacenter.getVirtualMachines()){
                log.info(vm.getOs());
            }
        }
        return datacenters;
    }
}
