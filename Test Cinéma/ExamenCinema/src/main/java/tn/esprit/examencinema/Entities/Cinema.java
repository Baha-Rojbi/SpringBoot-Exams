package tn.esprit.examencinema.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Cinema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCinema;
    private String adresse;
    private String nomCinema;
    @OneToMany(mappedBy = "cinema")
    private Set<Salle>salles;
}
