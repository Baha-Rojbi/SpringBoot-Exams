package tn.esprit.examenmusee.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class OeuvreArt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOeuvreArt;
    private String artiste;
    private String titreTableau;
    @ManyToOne
    private Zone zone;
}
