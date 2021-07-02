package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Produit {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String description;
	private int quantite;
	private float prix;
	private String saison;
	
	@ManyToOne
	private SousCategorie sousCategorie;
	
	@Lob
	private byte[] image;

	
	

}
