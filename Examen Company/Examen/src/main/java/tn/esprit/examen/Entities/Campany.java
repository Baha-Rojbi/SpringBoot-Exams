package tn.esprit.examen.Entities;

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
public class Campany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campanyId;
    private String campanyName;
    private String adress;
    @OneToMany(mappedBy = "campany")
    private Set<Employe> employes;
}
