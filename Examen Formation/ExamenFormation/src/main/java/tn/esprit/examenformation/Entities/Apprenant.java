package tn.esprit.examenformation.Entities;

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

public class Apprenant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApprenant;
    private String nom;
    private String prenom;
    private Integer telephone ;
    private String email;
    @JsonIgnore
    @ManyToMany(mappedBy = "apprenants")
    private Set<Formation> formationSet;
}
