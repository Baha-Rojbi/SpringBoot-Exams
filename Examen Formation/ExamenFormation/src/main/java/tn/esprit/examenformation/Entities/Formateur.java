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
public class Formateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormateur;
    private String nom;
    private String prenom;
    private Integer tarifHoraire;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "formateur")
    private Set<Formation> formations;

}
