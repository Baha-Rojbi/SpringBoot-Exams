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
public class CentreCommercial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String login;
    private String password;
    @OneToMany(mappedBy ="centreCommercial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Boutique>boutiques;
}
