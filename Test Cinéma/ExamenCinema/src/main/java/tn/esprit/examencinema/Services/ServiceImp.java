package tn.esprit.examencinema.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examencinema.Entities.Cinema;
import tn.esprit.examencinema.Entities.Film;
import tn.esprit.examencinema.Entities.GenreFilm;
import tn.esprit.examencinema.Entities.Salle;
import tn.esprit.examencinema.Repositories.CinemaRepository;
import tn.esprit.examencinema.Repositories.FilmRepository;
import tn.esprit.examencinema.Repositories.SalleRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImp implements IService{
    private CinemaRepository cinemaRepository;
    private FilmRepository filmRepository;
    private SalleRepository salleRepository;
    @Override
    public void ajoutCinemaetSalles(Cinema cinema) {
        cinemaRepository.save(cinema);
        for (Salle salle: cinema.getSalles()){
            salle.setCinema(cinema);
            salleRepository.save(salle);
        }
    }

    @Override
    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public List<Film> getFilmParGenre(GenreFilm genreFilm) {
        return filmRepository.findByGenre(genreFilm);
    }

    @Override
    public void affecterFilmSalle(Long idFilm, Long idSalle) {
    Film film=filmRepository.findById(idFilm).orElse(null);
    Salle salle=salleRepository.findById(idSalle).orElse(null);
        salle.getFilms().add(film); // Assuming there is a bidirectional relationship and Salle has a collection of Films.
        film.getSalleDeFilm().add(salle); // Assuming Film has a reference to Salle.

        salleRepository.save(salle);
        // filmRepository.save(film); // This line may be optional if the relationship is correctly mapped

    }

    @Override
    public void supprimerFilms() {
List<Salle> salles=salleRepository.findAll();
List<Film> films=filmRepository.findAll();
for (Film film:films){
    if (film.getSalleDeFilm().size()==1){
        log.info(" il n existe pas");
        film.setSalleDeFilm(null);
        film.getSalleDeFilm().add(salleRepository.findByNomSalle("c"));
    }
}
    }

    @Override
    public void suppCinemaAllSalles(Long idCinema) {
        Cinema cinema=cinemaRepository.findById(idCinema).orElse(null);
        for (Salle salle:cinema.getSalles()){
            salleRepository.delete(salle);
        }
        cinemaRepository.delete(cinema);
    }
    @Scheduled(fixedRate = 30000)
    String retrieveFilms()
    {
        List<Film> films=filmRepository.findAll();
        String Noms="";
        for (Film film :films){
            if (film.getDate().before(new Date())){
                log.info("LEs Films qui sont depssé sont Films = " + film.getNomFilm());
                 String.join(Noms,film.getNomFilm());

            }
        }
        return Noms;
    }
}
