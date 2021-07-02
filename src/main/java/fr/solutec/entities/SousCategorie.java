package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class SousCategorie {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String description;

	@ManyToOne
	private Categorie categorie;
}
