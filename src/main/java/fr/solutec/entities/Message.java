package fr.solutec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Message {
	@Id @GeneratedValue
	private Long id;
	@Column(length=1024)
	private String contenu;
	
	@ManyToOne
	private Person emetteur;
	
	@ManyToOne
	private Person receveur;
}
