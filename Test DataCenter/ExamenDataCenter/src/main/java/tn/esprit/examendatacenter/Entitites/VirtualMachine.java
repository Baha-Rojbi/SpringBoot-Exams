package tn.esprit.examendatacenter.Entitites;

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
public class VirtualMachine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVm;
    private String os;
    private int tailleDisque;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @ManyToOne
    private Datacenter datacenter;
}
