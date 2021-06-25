package fr.solutec.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("C")
@AllArgsConstructor @NoArgsConstructor @Data

public class Consommateur extends Person{
	@Id @GeneratedValue
	private Long id;

	public Consommateur(Long id, String nom, String prenom, String login, String mdp, int age, String adresse) {
		super(id, nom, prenom, login, mdp, age, adresse);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
