package tn.esprit.bus.Entities;

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
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBus;
    private String numImmatriculation;
    @Temporal(TemporalType.DATE)
    private Date dateMiseEnService;
    private int nbreDePlaceMax;
    @ManyToOne
    private Trajet trajet;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Utilisateur chauffeur;
    @OneToMany(mappedBy ="busEtudiant")
    @JsonIgnore
    private Set<Utilisateur> Etudiant;
}
