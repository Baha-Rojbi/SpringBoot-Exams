package tn.esprit.examencinema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examencinema.Entities.Film;
import tn.esprit.examencinema.Entities.GenreFilm;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Long> {
    List<Film> findByGenre (GenreFilm genreFilm);
    @Query("SELECT f FROM Film f WHERE (SELECT COUNT(s) FROM Salle s WHERE :film MEMBER OF s.films) = 1")
    List<Film> findFilmsWithOnlyOneSalle();
}
