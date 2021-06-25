package fr.solutec.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
@Service
public abstract class Person {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private int age;
	private String adresse;
	
	@ManyToOne
	private Admin admin;
	@ManyToOne
	private Consommateur consommateur;
	@ManyToOne
	private Producteur producteur;

}
