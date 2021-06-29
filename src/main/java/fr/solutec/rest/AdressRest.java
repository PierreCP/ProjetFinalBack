package fr.solutec.rest;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.*;
import fr.solutec.repository.*;

@RestController @CrossOrigin("*")
public class AdressRest {
	@Autowired
	private AdressRepository adRepo;
	
	
	@GetMapping("nullAdress")
	public static Adress getNullAdress(){
		return new Adress(); 
	}
}
