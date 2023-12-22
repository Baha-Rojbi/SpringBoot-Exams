package tn.esprit.spring.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.MatchFootball;
import tn.esprit.spring.serviceInterfaces.IMatchFootballService;

@RestController
@RequestMapping("/match")
public class MatchRestController {

	@Autowired
	IMatchFootballService matchFootballService;

	@PostMapping("/add-match/{equipeId1}/{equipeId2}")
	@ResponseBody
	public MatchFootball addMatch(@RequestBody MatchFootball matchFootBall,
			@PathVariable("equipeId1") Integer equipeId1, @PathVariable("equipeId2") Integer equipeId2) {
		return matchFootballService.ajouterMatchFootballEtAffecterEquipe(matchFootBall, equipeId1, equipeId2);
	}

	@PutMapping("/reporeterMatchByaDate/{idMatch}/{dateReportee}")
	@ResponseBody
	public void reporeterMatch(@PathVariable("idMatch") Integer idMatch,
			@PathVariable(name = "dateReportee") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateReportee) {
		try {
			matchFootballService.reporterMatch(idMatch, dateReportee);
		} catch (Exception e) {
		}
	}
}