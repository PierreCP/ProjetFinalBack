package fr.solutec.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("P")
@AllArgsConstructor @NoArgsConstructor @Data
public class Producteur extends Person{
	@Id @GeneratedValue
	private Long id;
	private String nomMagasin;

}
