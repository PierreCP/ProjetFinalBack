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
	private int quantiteCons;
	
	// Juste rajouté pour traiter lagestion des stocks mais pas lié à la base de données
	private Long idProd;
	
	@ManyToOne
	private SousCategorie sousCategorie;

	public Produit(Long id, String nom, String description, int quantite, float prix, String saison,
			SousCategorie sousCategorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
		this.saison = saison;
		this.sousCategorie = sousCategorie;
	}
	
	
	@Lob
	private byte[] image;

	
	

}
