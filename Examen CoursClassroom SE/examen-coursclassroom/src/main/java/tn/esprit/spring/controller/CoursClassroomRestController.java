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
import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;
import tn.esprit.spring.services.ICoursClassroomService;
@RestController
@Api(tags = "Gestion des coursClassrooms")
@RequestMapping("/coursClassroom")
public class CoursClassroomRestController {

	@Autowired
	ICoursClassroomService coursClassroomService;

	// http://localhost:8089/SpringMVC/coursClassroom/retrieve-all-coursClassrooms
	@ApiOperation(value = "Récupérer la liste des coursClassrooms")
	@GetMapping("/retrieve-all-coursClassrooms")
	public List<CoursClassroom> getCoursClassrooms() {
		List<CoursClassroom> listCoursClassrooms = coursClassroomService.retrieveAllCoursClassrooms();
		return listCoursClassrooms;
	}

	// http://localhost:8089/SpringMVC/coursClassroom/retrieve-coursClassroom/8
	@ApiOperation(value = "Récupérer un coursClassroom par Id")
	@GetMapping("/retrieve-coursClassroom/{coursClassroom-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public CoursClassroom retrieveCoursClassroom(@PathVariable("coursClassroom-id") Integer coursClassroomId) {
		return coursClassroomService.retrieveCoursClassroom(coursClassroomId);
	}

	@PostMapping("/add-coursClassroom/{classe-id}")
	public CoursClassroom addCoursClassroom(@RequestBody CoursClassroom cc, @PathVariable("classe-id") Integer classeId) {
		return coursClassroomService.ajouterCoursClassroom(cc, classeId);
	}

	// http://localhost:8089/SpringMVC/coursClassroom/remove-coursClassroom/{coursClassroom-id}
	@DeleteMapping("/remove-coursClassroom/{coursClassroom-id}")
	public void removeCoursClassroom(@PathVariable("coursClassroom-id") Integer coursClassroomId) {
		coursClassroomService.deleteCoursClassroom(coursClassroomId);
	}

	// http://localhost:8089/SpringMVC/coursClassroom/modify-coursClassroom
	@PutMapping("/modify-coursClassroom")
	public CoursClassroom modifyCoursClassroom(@RequestBody CoursClassroom coursClassroom) {
		return coursClassroomService.updateCoursClassroom(coursClassroom);
	}

	// http://localhost:8089/SpringMVC/coursClassroom//desaffecter-coursClassroom-classe/{coursClassroom-id}/{classe-id}
	@DeleteMapping("/desaffecter-coursClassroom-classe/{coursClassroom-id}")
	public void desaffecterCoursClassroomCLasse(@PathVariable("coursClassroom-id") Integer ccId) {
		coursClassroomService.desaffecterCoursClassroomClasse(ccId);
	}

	// http://localhost:8089/SpringMVC/coursClassroom/nb-heures-par-spec-niv/{spec}/{niv}
	@DeleteMapping("/nb-heures-par-spec-niv/{spec}/{niv}")
	public Integer nbHeuresParSpecEtNiv(@PathVariable("spec") Specialite spec, @PathVariable("niv") Niveau niv) {
		return coursClassroomService.nbHeuresParSpecEtNiv(spec, niv);
	}

	
}
