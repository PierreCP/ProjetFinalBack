package fr.solutec.entities;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	/*
	public double generateX() {
		double x = 5;
		
		HttpClient client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(
			       URI.create("https://api-adresse.data.gouv.fr/search/?q=" + this.numéroRue + "+" + this.nomRue + "&postcode=" + this.codePostal))
			   .header("accept", "application/json")
			   .build();
		
		return x;
	}*/
	

		

	
	
}
