package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Equipe;
import tn.esprit.spring.serviceInterfaces.IEquipeService;

@RestController
@RequestMapping("/equipe")
public class EquipeRestController {
	@Autowired
	IEquipeService equipeService;

	@PostMapping("/add-equipe")
	@ResponseBody
	public Equipe addEquipe(@RequestBody Equipe s) {
		return equipeService.ajouterEquipe(s);
	}

}