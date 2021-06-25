package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@OneToOne
	private Person person;
	
	@ManyToOne
	private Produit produit;
	

}
