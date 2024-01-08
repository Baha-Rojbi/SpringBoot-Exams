package tn.esprit.examenfinal.Entities;

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
public class Internaute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternaute;
    private String identifiant;
    @Enumerated(EnumType.STRING)
    private TrancheAge trancheAge;
    @JsonIgnore
    @OneToMany(mappedBy = "internaute")
    private Set<Ticket> ticketsInternaute;
}
