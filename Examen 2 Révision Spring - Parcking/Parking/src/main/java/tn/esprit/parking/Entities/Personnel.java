package tn.esprit.parking.Entities;

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
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private Date dateDeRecrutement;
    private String login;
    private String Password;
    private Poste poste;
    @OneToOne(mappedBy = "responsable")
    private Zone zoneResponsable;
    @ManyToOne
    private Zone zone;

}
