package tn.esprit.examenassurance.Entities;

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
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAssurance;
    private String designation;
    private float montant;
    @ManyToOne
    private Beneficiaire beneficiaire;
    @ManyToOne
    private Contrat contrat;
}