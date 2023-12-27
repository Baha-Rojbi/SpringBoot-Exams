package tn.esprit.examenmusee.Entities;

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
public class Musee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusee;
    @Temporal(TemporalType.DATE)
    private Date dateInauguration;
    private String designation;
    private String adresse;
    @OneToMany(mappedBy = "musee")
    private Set<Zone> zones;
}
