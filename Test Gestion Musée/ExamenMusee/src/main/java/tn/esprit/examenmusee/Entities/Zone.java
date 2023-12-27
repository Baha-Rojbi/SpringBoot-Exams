package tn.esprit.examenmusee.Entities;

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
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZone;
    private String code;
    private String libelle;
    @Enumerated(EnumType.STRING)
    private Direction direction;
    private Boolean actif;
    @ManyToOne
    private Musee musee;
    @OneToMany(mappedBy = "zone")
    private Set<OeuvreArt> oeuvreArts;
    @OneToOne
    private Personnel personnel;
    @OneToMany(mappedBy = "zonePersonnel")
    private Set<Personnel>personnels;
}
