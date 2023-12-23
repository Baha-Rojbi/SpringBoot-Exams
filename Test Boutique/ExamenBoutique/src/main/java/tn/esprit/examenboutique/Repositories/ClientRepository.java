package tn.esprit.examenboutique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenboutique.Entities.Categorie;
import tn.esprit.examenboutique.Entities.Client;
import tn.esprit.examenboutique.Entities.Genre;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c " +
            "JOIN c.boutiquesClient boutiques " +
            "WHERE boutiques.categorie = :categorie")
    List<Client> findClientsByBoutiquesCategorie(@Param("categorie") Categorie categorie);

    int countByGenre(Genre genre);
}
