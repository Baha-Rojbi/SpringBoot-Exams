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
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String lastName;
    private String firstName;
    private String position;

    @ManyToOne
    private Campany campany;
    @OneToMany(mappedBy = "employe")
    private Set<Donation> donations;
}
