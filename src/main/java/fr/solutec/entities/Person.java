package fr.solutec.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor  @Data
public class Person {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private int age;
	
	/*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
	@PrimaryKeyJoinColumn
	private Consommateur consomateur;*/
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Adress adresse;

	/*public Person(Long id, String nom, String prenom, String login, String mdp, int age, Adress adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.age = age;
		this.adresse = adresse;
	}*/
	

	
	
	
}
