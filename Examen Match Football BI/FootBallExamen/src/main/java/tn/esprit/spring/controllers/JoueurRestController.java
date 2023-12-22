package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Division;
import tn.esprit.spring.entities.Joueur;
import tn.esprit.spring.entities.Poste;
import tn.esprit.spring.serviceInterfaces.IJoueurService;

@RestController
@RequestMapping("/joueur")
public class JoueurRestController {

	@Autowired
	IJoueurService joueurService;

	@PostMapping("/add-joueur/{equipe-id}")
	@ResponseBody
	public Joueur addJoueur(@RequestBody Joueur joueur, @PathVariable("equipe-id") Integer equipeId) {
		return joueurService.ajouterJoueurEtAffecterEquipe(joueur, equipeId);
	}

	@GetMapping("/retrieveJoueurPosteTaille/{poste}/{taille}")
	@ResponseBody
	public List<Joueur> retrieveJoueurPosteTaille(@PathVariable("poste") Poste poste,
			@PathVariable("taille") float taille) {
		return joueurService.afficherJoueursParPosteEtTaille(poste, taille);
	}

	@GetMapping("/afficherDivisionEtPoste/{division}/{poste}/{idMatch}")
	public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(@PathVariable Division division,
			@PathVariable Poste poste, @PathVariable Integer idMatch) {

		return joueurService.afficherJoueursDuMatchParDivisionEtPoste(division, poste, idMatch);
	}

}