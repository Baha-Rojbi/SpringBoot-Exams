package tn.esprit.examencinema.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examencinema.Entities.Cinema;
import tn.esprit.examencinema.Entities.Film;
import tn.esprit.examencinema.Entities.GenreFilm;
import tn.esprit.examencinema.Services.IService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
    @PostMapping("/ajoutCinemaetSalles")
    public void ajoutCinemaetSalles(@RequestBody Cinema cinema){
        iService.ajoutCinemaetSalles(cinema);
    }
    @PostMapping("/addFilm")
    public void addFilm (@RequestBody Film film){
        iService.addFilm(film);
    }
    @GetMapping("/getFilmParGenre/{genreFilm}")
    List<Film> getFilmParGenre(@PathVariable GenreFilm genreFilm ){
      return   iService.getFilmParGenre(genreFilm);
    }
    @PostMapping("/affecterFilmSalle/{idFilm}/{idSalle}")
    public void affecterFilmSalle(@PathVariable Long idFilm,@PathVariable Long idSalle){
        iService.affecterFilmSalle(idFilm, idSalle);
    }
    @PutMapping("/supprimerFilms")
    void supprimerFilms(){
        iService.supprimerFilms();
    }
    @DeleteMapping("/suppCinemaAllSalles/{idCinema}")
    public void suppCinemaAllSalles (@PathVariable Long idCinema){
        iService.suppCinemaAllSalles(idCinema);
    }
}
