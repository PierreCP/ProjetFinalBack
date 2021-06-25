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
}
