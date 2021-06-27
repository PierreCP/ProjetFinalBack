package fr.solutec.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor @AllArgsConstructor @Data

public class Admin extends Person{
	@Id @GeneratedValue
	private Long id;

	public Admin(Long id, String nom, String prenom, String login, String mdp, int age, String adresse) {
		super(id, nom, prenom, login, mdp, age, adresse);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
