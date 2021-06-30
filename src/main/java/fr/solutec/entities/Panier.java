package fr.solutec.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Panier {
	
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToMany
	public List<Produit> produits;
	
	@OneToOne
	private Consommateur consommateur;

}
