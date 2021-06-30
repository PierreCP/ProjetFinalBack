package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Adress;
import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Person;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.AdressRepository;
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
	
	@Autowired
	private AdressRepository adressRepo;

	@PostMapping("person")
	public Person savePerson(@RequestBody Person p) {
		Adress a = p.getAdresse();
		adressRepo.save(a);
		return pr.save(p);
	}
	
	@PostMapping("consommateur")
	public Consommateur saveConsommateur(@RequestBody Consommateur c) {
		Person p = c.getPerson();
		pr.save(p);
		return consRepo.save(c);
	}
	
	@PostMapping("producteur")
	public Producteur saveProducteur(@RequestBody Producteur p) {
		Person u = p.getPerson();
		pr.save(u);
		return prodRepo.save(p);
	}
	
	@GetMapping("person/null")
	public static Person getNullPerson(){
		return new Person();
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
	
	@GetMapping("producteurWithDist/{idperson}")
	public Iterable<Producteur> getAllProducteurWithDist(@PathVariable Long idperson) {
		Iterable<Producteur> listProd = prodRepo.findAll();
		double x1 = pr.findById(idperson).get().getAdresse().getX();
		double y1 = pr.findById(idperson).get().getAdresse().getY();
		double x2;
		double y2;
		
		for (Producteur producteur : listProd) {
			x2 = producteur.getPerson().getAdresse().getX();
			y2 = producteur.getPerson().getAdresse().getX();
			producteur.setDistance(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));			
			}
		return listProd;
	}
	
	@GetMapping("producteur/{id}")
	public Optional<Producteur> getOneProducteur(@PathVariable Long id) {
		return prodRepo.findById(id);
	}
	
	@GetMapping("producteur/person/{id}")
	public Optional<Producteur> getProducteurByIdPerson(@PathVariable Long id) {
		 return prodRepo.findByPersonId(id);

	}
	
	@GetMapping("producteur/produit/{id}")
	public Iterable<Produit> getProduitProducteur(@PathVariable Long id) {
		if (prodRepo.findById(id).isPresent()) {
			Producteur p = prodRepo.findById(id).get();
			return p.getProduits();
		}
		else {
			return null;
		}	
	}
	
	@GetMapping("person/produit/{id}")
	public Iterable<Produit> getAllProduitProducteurByIdPerson(@PathVariable Long id) {
		if (prodRepo.findByPersonId(id).isPresent()) {
			Producteur p = prodRepo.findByPersonId(id).get();
			List<Produit> prod = new ArrayList<Produit>();
			for (Produit produit : p.getProduits()) {
				 	prod.add(produit);
				}	
			return prod;
		}
		else {
			return null;
		}
	}
	
	
	@GetMapping("producteur/produit/{id}/{sousCategorie}")
	public Iterable<Produit> getSousCategorieProduitsProducteur(@PathVariable Long id, @PathVariable String sousCategorie) {
		if (prodRepo.findById(id).isPresent()) {
			Producteur p = prodRepo.findById(id).get();
			List<Produit> prod = new ArrayList<Produit>();
			for (Produit produit : p.getProduits()) {
				if (produit.getSousCategorie().getNom().equals(sousCategorie)) {
					prod.add(produit);
				}	
			}
			return prod;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("person/produit/{id}/{sousCategorie}")
	public Iterable<Produit> getSousCategorieProduitsOfProducteurByIdPerson(@PathVariable Long id, @PathVariable String sousCategorie) {
		if (prodRepo.findByPersonId(id).isPresent()) {
			Producteur p = prodRepo.findByPersonId(id).get();
			List<Produit> prod = new ArrayList<Produit>();
			for (Produit produit : p.getProduits()) {
				if (produit.getSousCategorie().getNom().equals(sousCategorie)) {
					prod.add(produit);
				}	
			}
			return prod;
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
