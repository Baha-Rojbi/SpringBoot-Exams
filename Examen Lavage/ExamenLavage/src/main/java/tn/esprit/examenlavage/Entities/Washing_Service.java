package tn.esprit.examenlavage.Entities;

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
public class Washing_Service  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private float price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @JsonIgnore
    @ManyToMany(mappedBy = "washingServices",fetch = FetchType.EAGER)
    private Set<Reservation> reservationsWashing;
}
