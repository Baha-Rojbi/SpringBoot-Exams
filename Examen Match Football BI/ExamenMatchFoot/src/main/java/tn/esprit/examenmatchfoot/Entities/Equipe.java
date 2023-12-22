package tn.esprit.examenmatchfoot.Entities;

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
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Division division;
    private String pays;
    @JsonIgnore
    @ManyToMany(mappedBy = "equipeMatch")
    private Set<MatchFootball>matchFootballEquipe;
    @JsonIgnore
    @OneToMany(mappedBy = "equipeJoueur")
    private Set<Joueur> joueurEquipe;
}
