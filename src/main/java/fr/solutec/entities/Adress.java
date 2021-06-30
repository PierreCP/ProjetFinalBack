package fr.solutec.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Adress {
	@Id @GeneratedValue
	private Long id;
	private int numeroRue;
	private String nomRue;
	private String codePostal;
	private String nomCommune;
	private double x;
	private double y;
	
	

	public Adress(Long id, int numéroRue, String nomRue, String codePostal, String nomCommune) {
		super();
		this.id = id;
		this.numeroRue = numéroRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.nomCommune = nomCommune;
}

	
	

		

	
	
}
