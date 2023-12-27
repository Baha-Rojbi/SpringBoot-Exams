package tn.esprit.examendatacenter.Entitites;

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
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String login;
    private String pwd;
    @OneToMany
    private Set<VirtualMachine> virtualMachinesUser;
}
