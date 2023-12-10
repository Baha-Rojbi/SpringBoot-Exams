package tn.esprit.parking.Entities;

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
    private int id;
    private String ref;
    private float dimension;
    @ManyToOne
    private Parking parking;
    @OneToOne
    private Personnel responsable;
    @OneToMany(mappedBy = "zone")
    private Set<Personnel> gardes;
}
