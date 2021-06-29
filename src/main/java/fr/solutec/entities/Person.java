package fr.solutec.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Person {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private int age;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Adress adresse;
	
}
