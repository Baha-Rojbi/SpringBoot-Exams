package tn.esprit.examenmatchfoot.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Joueur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJoueur;
    private String nom;
    private float taille;
    @Enumerated(EnumType.STRING)
    private Poste poste;
    private boolean blessure;
    private Integer nbButsEnCarrire;
    @ManyToOne
    private Equipe equipeJoueur;
}
