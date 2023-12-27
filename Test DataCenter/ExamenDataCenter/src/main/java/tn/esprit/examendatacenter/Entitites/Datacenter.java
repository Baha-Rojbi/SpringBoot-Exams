package tn.esprit.examendatacenter.Entitites;

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
public class Datacenter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDs;
    private String region;
    @Temporal(TemporalType.DATE)
    private Date dateFabrication;
    private int capaciteDisque;
    private int espaceLibreDisque;
    @OneToMany(mappedBy = "datacenter",fetch = FetchType.EAGER)
    private Set<VirtualMachine> virtualMachines;
}
