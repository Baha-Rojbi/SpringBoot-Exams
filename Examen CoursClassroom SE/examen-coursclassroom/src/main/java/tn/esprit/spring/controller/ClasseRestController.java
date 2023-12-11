package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Classe;
import tn.esprit.spring.services.IClasseService;
@RestController
@Api(tags = "Gestion des classes")
@RequestMapping("/classe")
public class ClasseRestController {

	@Autowired
	IClasseService classeService;

	// http://localhost:8089/SpringMVC/classe/retrieve-all-classes
	@ApiOperation(value = "Récupérer la liste des classes")
	@GetMapping("/retrieve-all-classes")
	public List<Classe> getClasses() {
		List<Classe> listClasses = classeService.retrieveAllClasses();
		return listClasses;
	}

	// http://localhost:8089/SpringMVC/classe/retrieve-classe/8
	@ApiOperation(value = "Récupérer un classe par Id")
	@GetMapping("/retrieve-classe/{classe-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Classe retrieveClasse(@PathVariable("classe-id") Integer classeId) {
		return classeService.retrieveClasse(classeId);
	}

	@PostMapping("/add-classe")
	public Classe addClasse(@RequestBody Classe c) {
		return classeService.ajouterClasse(c);
	}

	// http://localhost:8089/SpringMVC/classe/remove-classe/{classe-id}
	@DeleteMapping("/remove-classe/{classe-id}")
	public void removeClasse(@PathVariable("classe-id") Integer classeId) {
		classeService.deleteClasse(classeId);
	}

	// http://localhost:8089/SpringMVC/classe/modify-classe
	@PutMapping("/modify-classe")
	public Classe modifyClasse(@RequestBody Classe classe) {
		return classeService.updateClasse(classe);
	}

	// http://localhost:8089/SpringMVC/classe/add-classe-assign-coursclassroom/{coursclassroom-id}
	@PostMapping("/add-classe-assign-coursclassroom/{coursclassroom-id}")
	public Classe addClasse(@RequestBody Classe c, @PathVariable("coursclassroom-id") Integer coursClassroomId) {
		 return classeService.AjouterClasseEtAffecterCoursClasse(c, coursClassroomId);
	}
	
}
