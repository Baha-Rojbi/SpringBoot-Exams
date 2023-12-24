package tn.esprit.examencinema.Services;

import tn.esprit.examencinema.Entities.Cinema;
import tn.esprit.examencinema.Entities.Film;
import tn.esprit.examencinema.Entities.GenreFilm;

import java.util.List;

public interface IService {
    public void ajoutCinemaetSalles(Cinema cinema);
    public void addFilm (Film film);
    List<Film> getFilmParGenre(GenreFilm genreFilm );
    public void affecterFilmSalle(Long idFilm, Long idSalle);
    void supprimerFilms();
    public void suppCinemaAllSalles (Long idCinema);


}
