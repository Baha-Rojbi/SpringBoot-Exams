package tn.esprit.examenpathologie.Entities;

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
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    @Enumerated(EnumType.STRING)
    private TypePierceIdentite typePierceIdentite;
    private String identifiantPieceIdentite;
    @Temporal(TemporalType.DATE)
    private Date dateEmission;
    private String nompP;
    private String prenomP;
    @ManyToMany
    private Set<Pathologie> pathologies;
}
