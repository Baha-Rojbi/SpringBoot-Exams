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
public class FamilleActe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFA;
    private String codeFA;
    private String libelle;
    private String description;
    @OneToMany(mappedBy = "familleActe",cascade = CascadeType.ALL)
    private Set<Acte> actes ;
}
