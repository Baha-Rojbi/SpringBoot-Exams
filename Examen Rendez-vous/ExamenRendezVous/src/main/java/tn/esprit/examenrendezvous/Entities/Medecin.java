package tn.esprit.examenrendezvous.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private int telephone ;
    private int prixConsultation;
    @JsonIgnore
    @ManyToMany(mappedBy = "medecinsClinique")
    private Set<Clinique>cliniquesMedecin;
    @JsonIgnore
    @OneToMany(mappedBy = "medecin")
    private Set<RendezVous>rendezVous;
}
