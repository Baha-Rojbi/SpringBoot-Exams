package tn.esprit.examenfinal.Entities;

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
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String codeCategorie;
    private String nomCategorie;
    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Evenement> evenements;
}
