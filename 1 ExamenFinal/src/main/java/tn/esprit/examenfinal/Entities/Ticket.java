package tn.esprit.examenfinal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String codeTicket;
    private Double prixTicket;
    @Enumerated(EnumType.STRING)
    private TypeTicket typeTicket;
    @JsonIgnore
    @ManyToOne
    private Evenement evenement;
    @JsonIgnore
    @ManyToOne
    private Internaute internaute;
}
