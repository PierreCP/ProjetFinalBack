package fr.solutec.rest;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.*;
import fr.solutec.repository.*;

@RestController @CrossOrigin("*")
public class AdressRest {
	@Autowired
	private AdressRepository adRepo;
	@Autowired
	private PersonRepository pr;
	
	
	@GetMapping("nullAdress")
	public Adress getNullAdress(){
		return new Adress(); 
	}
	
	@PostMapping("newAdress")
	public Adress newAdress(@RequestBody Adress a) {
		return adRepo.save(a);
	}
	
	@GetMapping("adress/{id}")
	public Optional<Adress> getAdressById(@PathVariable Long id){
		return adRepo.findById(id); 
	}
	
	@GetMapping("dist/{id1}/{id2}")
	public double getDistance(@PathVariable Long id1, @PathVariable Long id2) {
		double x1 = pr.findById(id1).get().getAdresse().getX();
		double x2 = pr.findById(id2).get().getAdresse().getX();
		double y1 = pr.findById(id1).get().getAdresse().getY();
		double y2 = pr.findById(id2).get().getAdresse().getY();
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}
	
	@GetMapping("getX/{id1}")
	public Person getX(@PathVariable Long id1) {
		return pr.findById(id1).get();
	}
	


}
