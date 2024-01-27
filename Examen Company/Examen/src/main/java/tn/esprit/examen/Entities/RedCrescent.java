package tn.esprit.examen.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

public class RedCrescent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long redCId;
    private String area;
    @OneToMany
    private Set<Donation> donations;
}
