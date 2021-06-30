package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Panier;
import fr.solutec.entities.Produit;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.panierRepository;

@RestController
@CrossOrigin("*")
public class PanierRest {
	@Autowired
	private panierRepository panierRepo;
	@Autowired
	private ProduitRepository produitRepo;

	@GetMapping("panier/{id}")
	private Optional<Panier> getPanierFromConsommateur(@PathVariable Long id) {
		return panierRepo.findById(id);
	}

	@DeleteMapping("panier/produit/{idpro}/{idpa}")
	public boolean deleteProduit(@PathVariable Long idpro, @PathVariable Long idpa) {
		if (panierRepo.findById(idpa).isPresent()) {
			Panier panier = panierRepo.findById(idpa).get();
			Produit produit = produitRepo.findById(idpro).get();
			panier.produits.remove(produit);
			panierRepo.save(panier);
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("panier/{idpa}")
	public boolean setProduitToPanier(@RequestBody Produit p, @PathVariable Long idpa) {
		System.out.println("idpa " + idpa);		
		Optional<Panier> panier = panierRepo.findById(idpa);
		if(panier.isPresent()) {
			Optional<Produit> pdt = produitRepo.findById(p.getId());
			if(pdt.isPresent()) {
				panier.get().produits.add(pdt.get());
				 panierRepo.save(panier.get());	
				 return true;
			}
			else {
				return false;
			}
		}
		else {
			System.err.println("panier non trouvé");
			return false;
		}
		
	}

}
