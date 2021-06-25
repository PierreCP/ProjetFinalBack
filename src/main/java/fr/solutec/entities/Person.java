package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public abstract class Person {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private int age;
	private String adresse;

}
