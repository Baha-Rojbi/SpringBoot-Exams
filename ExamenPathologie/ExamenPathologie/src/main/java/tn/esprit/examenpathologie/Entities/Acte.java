package tn.esprit.examenpathologie.Entities;

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
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActe;
    private String codeActe;
    private int cotationActe;
    private float prixUnitaireActe;
    private String designationActe;
    @ManyToOne(cascade = CascadeType.ALL)
    private FamilleActe familleActe;
    @ManyToMany(mappedBy = "actesPathologie")
    private Set<Pathologie> pathologiesActe;
}
