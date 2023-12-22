package tn.esprit.examenmatchfoot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MatchFootball implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatch;
    private String libelle;
    private String pays;
    @Temporal(TemporalType.DATE)
    private Date dateMatch;
    @JsonIgnore
    @ManyToMany
    private Set<Equipe>equipeMatch;
}
