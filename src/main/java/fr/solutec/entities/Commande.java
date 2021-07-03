package fr.solutec.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Commande {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Consommateur consom;
	
	@ManyToMany
	public List<Produit> contenuCommande;
	private Date date;
	private boolean recuperee;
	
}
