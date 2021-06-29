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
	private int numéroRue;
	private String nomRue;
	private int codePostal;
	private String nomCommune;
	private double x;
	private double y;
	
	
	public Adress(Long id, int numéroRue, String nomRue, int codePostal, String nomCommune) {
		super();
		this.id = id;
		this.numéroRue = numéroRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.nomCommune = nomCommune;

		
	}
	/*
	public double generateX() {
		double x = 5;
		
		HttpClient client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(
			       URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
			   .header("accept", "application/json")
			   .build();
		
		return x;
	}*/
	
	
}
