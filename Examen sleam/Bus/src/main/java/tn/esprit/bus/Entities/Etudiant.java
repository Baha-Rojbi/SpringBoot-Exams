package tn.esprit.bus.Entities;

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
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @OneToOne(mappedBy = "etudiant")
    private Tuteur tuteur;
    @ManyToMany(mappedBy = "etudiants")
    private Set<Projet> projets ;
}
