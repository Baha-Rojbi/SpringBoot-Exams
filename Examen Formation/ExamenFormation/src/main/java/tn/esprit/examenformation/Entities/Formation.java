package tn.esprit.examenformation.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormation;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private Integer nbrHeures;
    private Integer nbrMaxParticipant;
    private Integer frais;
    @ManyToOne
    private Formateur formateur;
    @JsonIgnore
    @ManyToMany(fetch =FetchType.EAGER)
    private Set<Apprenant> apprenants;
}
