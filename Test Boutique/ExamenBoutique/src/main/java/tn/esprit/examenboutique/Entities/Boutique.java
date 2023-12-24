package tn.esprit.examenboutique.Entities;

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
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @ManyToOne
    @JsonIgnore
    private CentreCommercial centreCommercial;
    @JsonIgnore
    @ManyToMany(mappedBy = "boutiquesClient")
    private Set<Client> clients;
}
