package fr.solutec.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor @AllArgsConstructor
public class Admin extends Person{
	@Id @GeneratedValue
	private Long id;

	public Admin(Long id, String nom, String prenom, String login, String mdp, int age, String adresse, Admin admin,
			Consommateur consommateur, Producteur producteur) {
		super(id, nom, prenom, login, mdp, age, adresse, admin, consommateur, producteur);
		// TODO Auto-generated constructor stub
	}
	
	
}
