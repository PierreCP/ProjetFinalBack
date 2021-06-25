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

public class Consommateur{
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Person person;
	

	
}
