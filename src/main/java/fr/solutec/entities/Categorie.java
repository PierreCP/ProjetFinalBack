package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Categorie {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String description;

	//x12
	/*@OneToMany(fetch = FetchType.EAGER)
	private Collection<SousCategorie> sousCategorie; */
	
}
