package fr.solutec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.entities.TypeProduit;
import fr.solutec.repository.PersonRepo;
import fr.solutec.repository.ProduitRepo;
import fr.solutec.repository.TypeProduitRepository;

@SpringBootApplication
public class ProjetFinalApplication implements CommandLineRunner {
	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private ProduitRepo produitRepo;
	@Autowired
	private TypeProduitRepository tpRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalApplication.class, args);
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creation/Update de la BDD");
		
		
		Admin a1 = new Admin(null, "Jean", "Test", "1", "0", 10, "13 rue du test");
		personRepo.save(a1);
		
		Consommateur c1 = new Consommateur(null, "ALBERT", "Geoffrey", "geof", "geof123", 23, "27 rue des sports");
		personRepo.save(c1);
		Consommateur c2 = new Consommateur(null, "CHARPENTIER", "Pierre", "pier", "pier123", 36, "15 avenue de la libération");
		personRepo.save(c2);
		Consommateur c3 = new Consommateur(null, "MORISSET", "Guillaume", "gui", "gui123", 54, "3 rue du code");
		personRepo.save(c3);
		
		Producteur p1 = new Producteur(null, "BANKA", "Joel", "jojo", "jojo123", 84, "87 rue de France");
		personRepo.save(p1);
		Producteur p2 = new Producteur(null, "BONHOMME", "Clovis", "clo", "clo123", 42, "22 rue d'angular");
		personRepo.save(p2);
		Producteur p3 = new Producteur(null, "TERNEYRE", "Benoit", "ben", "ben123", 84, "14 rue de Java");
		personRepo.save(p3);
		
		TypeProduit t1 = new TypeProduit(null, "Légumes", "Ici c'est la catégorie légumes");
		tpRepo.save(t1);
		TypeProduit t2 = new TypeProduit(null, "Fromage", "Ici c'est la catégorie fromages");
		tpRepo.save(t2);
		TypeProduit t3 = new TypeProduit(null, "Alcool", "Ici c'est la catégorie alcool");
		tpRepo.save(t3);
		
		Produit pr1 = new Produit(null, "patate", "Sac 1Kg de pomme de terre de corse", 45, 3.99F, null, t1);
		produitRepo.save(pr1);
		Produit pr2 = new Produit(null, "camembert", "camembert de Normandie extra fondant", 23, 2.54F, null, t2);
		produitRepo.save(pr2);
		Produit pr3 = new Produit(null, "bière", "Bière Cuvée des Trolls 8° 1L", 150, 6.77F, null, t3);
		produitRepo.save(pr3);
		
		
	}

}
