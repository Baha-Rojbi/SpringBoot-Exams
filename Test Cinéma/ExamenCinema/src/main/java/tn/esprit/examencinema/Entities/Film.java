package tn.esprit.examencinema.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;
    private String nomFilm;
    @Enumerated(EnumType.STRING)
    private GenreFilm genre;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToMany(mappedBy = "films")
    private Set<Salle> salleDeFilm;
}
