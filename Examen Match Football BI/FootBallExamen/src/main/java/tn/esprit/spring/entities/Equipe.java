package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipe;
	private String nomEquipe;
	@Enumerated(EnumType.STRING)
	private Division division;
	private String pays;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipe" , cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<Joueur> Joueurs;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "equipes", fetch = FetchType.EAGER)
	private Set<MatchFootball> matchs;
	

}
