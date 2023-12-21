package tn.esprit.bus.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateDebutAbonnement;
    @Temporal(TemporalType.DATE)
    private Date dateFinAbonnement;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    private Bus busEtudiant;
}
