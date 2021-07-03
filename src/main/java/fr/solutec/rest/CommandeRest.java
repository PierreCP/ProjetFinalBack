package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.repository.CommandeRepository;
import fr.solutec.repository.PanierRepository;
import fr.solutec.repository.ProducteurRepository;
import fr.solutec.entities.*;
@RestController @CrossOrigin("*")
public class CommandeRest {

	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private ProducteurRepository prodRepo;
	@Autowired
	private PanierRepository panierRepo;
	
	
	@GetMapping("commandes/{idPers}")
	public List<Commande> getCommandesById(@PathVariable Long idPers){
		Iterable<Commande> allCommandes = commandeRepo.findAll();
		Producteur prod = prodRepo.findByPersonId(idPers).get();
		List<Commande> commandes = new ArrayList<Commande>();
		
		for (Commande commande : allCommandes) {
			Commande currentCommande = new Commande();
			for (Produit produit : commande.contenuCommande) {
				if (produit.getIdProd() == prod.getId()) {
					if (currentCommande.getId() == null) {
						currentCommande.setId(commande.getId());
						currentCommande.setDate(commande.getDate());
						currentCommande.setRecuperee(commande.isRecuperee());
						currentCommande.setConsom(commande.getConsom());
						currentCommande.setContenuCommande(new ArrayList<Produit>());
					}
					currentCommande.contenuCommande.add(produit);
				}
				
			}
			if (currentCommande.getId() == null) {	
			}
			commandes.add(currentCommande);
		}
		
		return commandes;
	}
	
	
	@GetMapping("commandes-valide/{idPers}")
	public List<Commande> getCommandesValideById(@PathVariable Long idPers){
		Iterable<Commande> allCommandes = commandeRepo.findAll();
		Producteur prod = prodRepo.findByPersonId(idPers).get();
		List<Commande> commandes = new ArrayList<Commande>();
		
		for (Commande commande : allCommandes) {
			if (commande.isRecuperee()) {
				
			
			Commande currentCommande = new Commande();
			for (Produit produit : commande.contenuCommande) {
				if (produit.getIdProd() == prod.getId()) {
					if (currentCommande.getId() == null) {
						currentCommande.setId(commande.getId());
						currentCommande.setDate(commande.getDate());
						currentCommande.setRecuperee(commande.isRecuperee());
						currentCommande.setConsom(commande.getConsom());
						currentCommande.setContenuCommande(new ArrayList<Produit>());
					}
					currentCommande.contenuCommande.add(produit);
				}
				
			}
			if (currentCommande.getId() == null) {	
			}
			commandes.add(currentCommande);
		}
		}
		return commandes;
	}
	
	
	@GetMapping("commandes-nouvelles/{idPers}")
	public List<Commande> getCommandesNouvellesById(@PathVariable Long idPers){
		Iterable<Commande> allCommandes = commandeRepo.findAll();
		Producteur prod = prodRepo.findByPersonId(idPers).get();
		List<Commande> commandes = new ArrayList<Commande>();
		
		for (Commande commande : allCommandes) {
			if (!commande.isRecuperee()) {
				
			
			Commande currentCommande = new Commande();
			for (Produit produit : commande.contenuCommande) {
				if (produit.getIdProd() == prod.getId()) {
					if (currentCommande.getId() == null) {
						currentCommande.setId(commande.getId());
						currentCommande.setDate(commande.getDate());
						currentCommande.setRecuperee(commande.isRecuperee());
						currentCommande.setConsom(commande.getConsom());
						currentCommande.setContenuCommande(new ArrayList<Produit>());
					}
					currentCommande.contenuCommande.add(produit);
				}
				
			}
			if (currentCommande.getId() == null) {	
			}
			commandes.add(currentCommande);
		}
		}
		return commandes;
	}
	
	
	@GetMapping("valider-commande/{idCom}")
	public void validerCommande(@PathVariable Long idCom) {
		Commande c = commandeRepo.findById(idCom).get();
		c.setRecuperee(true);
		commandeRepo.save(c);
	}
	
	
	@GetMapping("validation-panier/{idPanier}")
	public void validationPanier(@PathVariable Long idPanier) {
		Panier panier = panierRepo.findById(idPanier).get();
		Commande commande = new Commande(null, panier.getConsommateur(), panier.produits, new java.util.Date(), false);
		panier.produits = new ArrayList<Produit>();
		commandeRepo.save(commande);
		panierRepo.save(panier);
		
	}
	
}
