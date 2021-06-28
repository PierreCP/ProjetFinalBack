package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.Produit;
import fr.solutec.repository.ProduitRepository;

@RestController @CrossOrigin("*")
public class ProduitRest {
	
	@Autowired ProduitRepository produitRepo;
	
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
		return produitRepo.findByTypeCategorie(categorieType);
	}

}
