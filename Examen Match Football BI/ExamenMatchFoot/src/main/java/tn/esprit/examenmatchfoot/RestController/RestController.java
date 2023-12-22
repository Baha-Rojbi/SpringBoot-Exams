package tn.esprit.examenmatchfoot.RestController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenmatchfoot.Entities.*;
import tn.esprit.examenmatchfoot.Services.IService;

import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/equipe")
    public Equipe ajouterEquipe (@RequestBody Equipe equipe)
    {
        return iService.ajouterEquipe(equipe);
    }
    @PostMapping("/joueurEtAffecterEquipe/{idEquipe}")
    public Joueur ajouterJoueurEtAffecterEquipe(@RequestBody Joueur joueur,@PathVariable Integer idEquipe){
        return iService.ajouterJoueurEtAffecterEquipe(joueur, idEquipe);
    }
    @GetMapping("joueurPosteTaille/{poste}/{taille}")
    public List<Joueur> afficherJoueursParPosteEtTaille (@PathVariable Poste poste,@PathVariable float taille){
        return iService.afficherJoueursParPosteEtTaille(poste, taille);
    }
    @PostMapping("matchEquipe/{idEquipe1}/{idEquipe2}")
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(@RequestBody MatchFootball matchFootball,@PathVariable Integer idEquipe1,@PathVariable Integer idEquipe2){
        return iService.ajouterMatchFootballEtAffecterEquipe(matchFootball, idEquipe1, idEquipe2);
    }
    @GetMapping("joueurDuMatch/{division}/{poste}/{idMatch}")
    public List <Joueur> afficherJoueursDuMatchParDivisionEtPoste (@PathVariable Division division,@PathVariable Poste poste,@PathVariable Integer idMatch){
        return iService.afficherJoueursDuMatchParDivisionEtPoste(division, poste, idMatch);
    }
    @PutMapping("/reporterMatch/{idMatch}/{dateReportee}")
    public MatchFootball reporterMatch(@PathVariable Integer idMatch,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateReportee){
        return iService.reporterMatch(idMatch, dateReportee);
    }
}
