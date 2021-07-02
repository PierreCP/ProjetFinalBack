package fr.solutec.rest;

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
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Panier;
import fr.solutec.entities.Person;
import fr.solutec.entities.Produit;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.PanierRepository;
import fr.solutec.repository.PersonRepository;

@RestController
@CrossOrigin("*")
public class PanierRest {
	@Autowired
	private PanierRepository panierRepo;
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private PersonRepository personRepo;

	@GetMapping("panier/{id}")
	private Optional<Panier> getPanierFromIdPanier(@PathVariable Long id) {
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

	@PutMapping("panier/{idpa}")
	public boolean setProduitToPanier(@RequestBody Produit p, @PathVariable Long idpa) {
		System.out.println("idpa " + idpa);
		Optional<Panier> panier = panierRepo.findById(idpa);
		if (panier.isPresent()) {
			Optional<Produit> pdt = produitRepo.findById(p.getId());
			if (pdt.isPresent()) {
				panier.get().produits.add(pdt.get());
				panierRepo.save(panier.get());
				return true;
			} else {
				return false;
			}
		} else {
			System.err.println("panier non trouvé");
			return false;
		}

	}
	
	@GetMapping("panier/produit/{idpa}/{id}")
	public boolean setProduitToPanier(@PathVariable Long id, @PathVariable Long idpa) {
		Optional<Panier> panier = panierRepo.findById(idpa);
		if (panier.isPresent()) {
			Optional<Produit> pdt = produitRepo.findById(id);
			if (pdt.isPresent()) {
				if (panier.get().produits.contains(pdt.get())) {
					int q = pdt.get().getQuantite();
					pdt.get().setQuantite(q+1);
					panierRepo.save(panier.get());
					return true;
				} else {
					pdt.get().setQuantite(1);
					panier.get().produits.add(pdt.get());
					panierRepo.save(panier.get());
					return true;	
				}
			} else {
				return false;
			}
		} else {
			System.err.println("panier non trouvé");
			return false;
		}
	}


	@PostMapping("panier")
	public Panier savePanier(@RequestBody Panier p) {
		return panierRepo.save(p);
	}

	/*
	 * @GetMapping("panier/user/{id}") public Long getOneProduit(@PathVariable Long
	 * id) { Optional<Panier> panier = Optional.ofNullable(new Panier()); panier =
	 * panierRepo.findByConsommateurId(id); return panier.get().getId(); }
	 */

	@GetMapping("panier/produit/{id}")
	public List<Produit> getOneProduit(@PathVariable Long id) {
		Panier panier = panierRepo.findById(id).get();
		return panier.getProduits();
	}

	@GetMapping("panier/user/{id}")
	public Optional<Panier> getOnePanier(@PathVariable Long id) {
		return panierRepo.findByConsommateurId(id);
	}

}
