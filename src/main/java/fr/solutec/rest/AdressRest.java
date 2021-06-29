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
	

}
