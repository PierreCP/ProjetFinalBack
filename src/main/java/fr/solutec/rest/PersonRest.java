package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Person;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.ConsommateurRepository;
import fr.solutec.repository.PersonRepository;
import fr.solutec.repository.ProducteurRepository;



@RestController @CrossOrigin("*")
public class PersonRest {

	@Autowired
	private PersonRepository pr;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private ConsommateurRepository consRepo;
	
	@Autowired
	private ProducteurRepository prodRepo;

	@PostMapping("person")
	public Person savePerson(@RequestBody Person p) {
		return pr.save(p);
	}

	@GetMapping("person")
	public Iterable<Person> getAllPerson() {
		return pr.findAll();
	}

	@GetMapping("person/{id}")
	public Optional<Person> getOnePerson(@PathVariable Long id) {
		return pr.findById(id);
	}
	
	@GetMapping("producteur")
	public Iterable<Producteur> getAllProducteur() {
		return prodRepo.findAll();
	}
	
	@GetMapping("producteur/{id}")
	public Optional<Producteur> getOneProducteur(@PathVariable Long id) {
		return prodRepo.findById(id);
	}
	

	@GetMapping("producteur/produits/{id}")
	public Iterable<Produit> getProduitProducteur(@PathVariable Long id) {
		if (prodRepo.findById(id).isPresent()) {
			Producteur p = prodRepo.findById(id).get();
			return p.getProduits();
		}
		else {
			return null;
		}	
	}
	
	@GetMapping("person/type/{id}")
	public String getPersonType(@PathVariable Long id){
		if (pr.findById(id).isPresent()) {
			String reponse = "";
			if (adminRepo.findByPersonId(id).isPresent()) {
				reponse = "Admin";
			}
			else if (consRepo.findByPersonId(id).isPresent()) {
				reponse = "Consommateur";
			}
			else if (prodRepo.findByPersonId(id).isPresent()) {
				reponse = "Producteur";
			}
			return reponse;
		}
		else {
			return null;
		}
	}

	@DeleteMapping("person/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		if(pr.findById(id).isPresent()) {
			pr.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PutMapping("person/{id}")
	public Person putPerson(@RequestBody Person p, @PathVariable Long id) {
		if (pr.findById(id).isPresent()) {
			p.setId(id);
			return pr.save(p);
		}
		else {
			return null;
		}
	}
	
	@PostMapping("login")
	public Optional<Person> connexion(@RequestBody Person p) {
		return pr.findByLoginAndMdp(p.getLogin(), p.getMdp());
	}

	
}
