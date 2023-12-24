package tn.esprit.examendatacenter.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examendatacenter.Entitites.Datacenter;
import tn.esprit.examendatacenter.Entitites.Utilisateur;
import tn.esprit.examendatacenter.Entitites.VirtualMachine;
import tn.esprit.examendatacenter.Services.IService;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/addUser")
    public void ajouterUser(@RequestBody Utilisateur u)
    {
        iService.ajouterUser(u);
    }
    @PostMapping("/ajouterDc")
    public void ajouterDc(@RequestBody Datacenter datacenter)
    {
       iService.ajouterDc(datacenter);
    }
    @PostMapping("/addVm")
    public int ajouterVm(@RequestBody VirtualMachine vm){
        return iService.ajouterVm(vm);
    }
    @PostMapping("/affecterVmUser/{idvm}/{iduser}")
    public void affecterVmuser(@PathVariable int idvm,@PathVariable int iduser){
        iService.affecterVmuser(idvm,iduser);
    }
    @PutMapping("/affecterVm/{idvm}")
    public void affecterVm(@PathVariable int idvm){
        iService.affecterVm(idvm);
    }
    @PutMapping("/demarrerInstanceUser/{idvm}")
    public void demarrerInstanceUser(@PathVariable int idvm){
        iService.demarrerInstanceUser(idvm);
    }
    @PutMapping("/arreterInstanceUser/{idvm}")
    public void arreterInstanceUser(@PathVariable int idvm){
        iService.arreterInstanceUser(idvm);
    }
}
