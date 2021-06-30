package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.ConsommateurRepository;
import fr.solutec.repository.PersonRepository;
import fr.solutec.repository.ProducteurRepository;
import fr.solutec.repository.ProduitRepository;

@RestController @CrossOrigin("*")
public class ProduitRest {
	
	@Autowired ProduitRepository produitRepo;
	
	@Autowired
	private PersonRepository pr;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private ConsommateurRepository consRepo;
	
	@Autowired
	private ProducteurRepository prodRepo;
	
	@GetMapping("produit")
	public Iterable<Produit> getAllProduit() {
		return produitRepo.findAll();
	}
	
	@GetMapping("produit/{id}")
	public Optional<Produit> getOneProduit(@PathVariable Long id) {
		return produitRepo.findById(id);
	}
	
	@GetMapping("produit/categorie/{categorieType}")
	public Iterable<Produit> getAllProduitByCategorie(@PathVariable String categorieType) {
		return produitRepo.findBySousCategorieCategorieNom(categorieType);
	}

	@GetMapping("produit/sous_categorie/{categorieSousType}")
	public Iterable<Produit> getAllProduitBySousCategorie(@PathVariable String categorieSousType) {
		return produitRepo.findBySousCategorieNom(categorieSousType);
	}
	

	
	

}
