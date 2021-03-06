package fr.solutec.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Producteur{
	@Id @GeneratedValue
	private Long id;
	private String nomMagasin;
	private double distance;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Person person;
	
	@ManyToMany
	public List<Produit> produits;

	public Producteur(Long id, String nomMagasin, Person person, List<Produit> produits) {
		super();
		this.id = id;
		this.nomMagasin = nomMagasin;
		this.person = person;
		this.produits = produits;
	}
	
	

}
