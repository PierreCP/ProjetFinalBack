package fr.solutec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data

public class Consommateur{
	@Id@Column(name = "person_id")
	private Long id;
	
	@OneToOne/*(fetch = FetchType.LAZY, optional = false)*/
	@MapsId
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	

	
}
