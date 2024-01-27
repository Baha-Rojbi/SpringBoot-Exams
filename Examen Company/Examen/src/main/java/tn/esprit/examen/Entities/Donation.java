package tn.esprit.examen.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Donation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donId;
    private float amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private DonationType type;
@ManyToOne
    private Employe employe;
}
