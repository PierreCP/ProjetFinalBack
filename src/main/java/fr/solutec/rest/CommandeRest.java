package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.repository.CommandeRepository;
import fr.solutec.entities.*;
@RestController @CrossOrigin("*")
public class CommandeRest {

	@Autowired
	private CommandeRepository commandeRepo;
	
	
	@GetMapping("commandes/{idProd}")
	public List<Commande> getCommandesById(@PathVariable Long idProd){
		Iterable<Commande> allCommandes = commandeRepo.findAll();
		
		List<Commande> commandes = new ArrayList<Commande>();
		
		for (Commande commande : allCommandes) {
			Commande currentCommande = new Commande();
			for (Produit produit : commande.contenuCommande) {
				if (produit.getIdProd() == idProd) {
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
}
