package tn.esprit.examencoursclassroom.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeClasse;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private Set<CoursClassroom> coursClassrooms;
}
