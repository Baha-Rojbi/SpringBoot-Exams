package tn.esprit.examencoursclassroom.Entities;

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

public class CoursClassroom implements Serializable {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours;
@Enumerated(EnumType.STRING)
private Specialite specialite;
private String nom;
private Integer nbHeures;
private Boolean archieve;
@ManyToOne
private Classe classe;
}
