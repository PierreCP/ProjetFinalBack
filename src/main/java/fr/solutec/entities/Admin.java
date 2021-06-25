package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class Admin extends Person{
	@Id @GeneratedValue
	private Long id;

}
