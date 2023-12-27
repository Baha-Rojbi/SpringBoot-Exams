package tn.esprit.examenmusee.Entities;

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
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereAffectation;
    @Enumerated(EnumType.STRING)
    private TypePersonnel typePersonnel;
    @OneToOne
    private Zone zone;
    @ManyToOne
    private Zone zonePersonnel;
}
