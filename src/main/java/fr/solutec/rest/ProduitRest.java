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
import fr.solutec.entities.SousCategorie;
import fr.solutec.repository.ProducteurRepository;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.SousCategorieRepository;

@RestController @CrossOrigin("*")
public class ProduitRest {

	@Autowired ProduitRepository produitRepo;

	@Autowired ProducteurRepository producteurRepo;
	
	@Autowired SousCategorieRepository souscatRepo;


	@GetMapping("produit")
	public Iterable<Produit> getAllProduit() {
		return produitRepo.findAll();
	}

	@GetMapping("produit/{id}")
	public Optional<Produit> getOneProduit(@PathVariable Long id) {
		return produitRepo.findById(id);
	}

	@GetMapping("produit/{nom}")
	public Produit getOneProduitByNom(@PathVariable String nom) {
		return produitRepo.findByNom(nom);
	}

	@GetMapping("produit/categorie/{categorieType}")
	public Iterable<Produit> getAllProduitByCategorie(@PathVariable String categorieType) {
		return produitRepo.findBySousCategorieCategorieNom(categorieType);
	}

	@GetMapping("produit/sous_categorie/{categorieSousType}")
	public Iterable<Produit> getAllProduitBySousCategorie(@PathVariable String categorieSousType) {
		return produitRepo.findBySousCategorieNom(categorieSousType);
	}
	
	@PostMapping("produit/id")
	public Long saveProduitGetId(@RequestBody Produit p) {
		produitRepo.save(p);
		return p.getId();
	}
	/*
	@GetMapping("lier/{id_produit}/{id_producteur}")
	@Modifying
	@Query(value ="INSERT INTO producteur_produits(produits_id, producteur_id) VALUES (:id_produit, :id_producteur)",
	  nativeQuery = true)
	public void lierProduitProducteur(@Param("id_produit") Long id_produit, @Param("id_producteur") Long id_producteur) {
		
	}
	*/

	@GetMapping("SousCategorie/{nom}")
	public Optional<SousCategorie> findSousCategorie(@PathVariable String nom) {
		return souscatRepo.findByNom(nom);
	}

	@GetMapping("lier/{id_producteur}/{id_produit}")
	public boolean lierProduitProducteur(@PathVariable Long id_produit, @PathVariable Long id_producteur) {
		Optional<Producteur> producteur = producteurRepo.findById(id_producteur);
		Optional<Produit> produit = produitRepo.findById(id_produit);
		if(producteur.isPresent() && produit.isPresent()) {
				producteur.get().produits.add(produit.get());
				producteurRepo.save(producteur.get());
				return true;
		} else {
				return false;
		}
		
	}
	
	@GetMapping("sousCategorie")
	public List<String> getAllSC() {
		Iterable<SousCategorie> sc = souscatRepo.findAll();
		List<String> noms = new ArrayList<String>();
		for (SousCategorie sousCat : sc) {
			noms.add(sousCat.getNom());
		} 
		return noms;
	}


	@PostMapping("produit")
	public Produit saveProduit(@RequestBody Produit p) {
		return produitRepo.save(p);
	}










}
