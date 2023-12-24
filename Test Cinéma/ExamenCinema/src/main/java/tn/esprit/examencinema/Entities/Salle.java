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
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;
    private String nomSalle;
    private Integer nombre_personnes;
    @ManyToOne
    private Cinema cinema;
    @ManyToMany
    private Set<Film> films;
}
