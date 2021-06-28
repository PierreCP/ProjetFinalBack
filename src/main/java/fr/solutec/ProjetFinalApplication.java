package fr.solutec;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Person;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.entities.TypeProduit;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.ConsommateurRepository;
import fr.solutec.repository.ProducteurRepository;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.TypeProduitRepository;

@SpringBootApplication
public class ProjetFinalApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private TypeProduitRepository tpRepo;
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private ConsommateurRepository consommateurRepo;
	@Autowired
	private ProducteurRepository producteurRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalApplication.class, args);
		System.out.println("Lancement terminé");
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creation/Update de la BDD");
		
		TypeProduit t1 = new TypeProduit(null, "Légumes", "Ici c'est la catégorie légumes");
		tpRepo.save(t1);
		TypeProduit t2 = new TypeProduit(null, "Fromage", "Ici c'est la catégorie fromages");
		tpRepo.save(t2);
		TypeProduit t3 = new TypeProduit(null, "Alcool", "Ici c'est la catégorie alcool");
		tpRepo.save(t3);
		
		Produit pr1 = new Produit(null, "Patate", "Sac 1Kg de pomme de terre de corse", 45, 3.99F, null, t1);
		produitRepo.save(pr1);
		Produit pr2 = new Produit(null, "Camembert", "camembert de Normandie extra fondant", 23, 2.54F, null, t2);
		produitRepo.save(pr2);
		Produit pr3 = new Produit(null, "Bière", "Bière Cuvée des Trolls 8° 1L", 150, 6.77F, null, t3);
		produitRepo.save(pr3);
		Produit pr4 = new Produit(null, "Vacherin", "Vacherin des montagnes affiné", 2, 4.86F, null, t2);
		produitRepo.save(pr4);
		Produit pr5 = new Produit(null, "Chevre", "Chèvre frais aux épices douces", 10, 3.45F, null, t2);
		produitRepo.save(pr5);
		Produit pr6 = new Produit(null, "Comté", "Comté affiné 18 mois", 8, 8.52F, null, t2);
		produitRepo.save(pr6);
		
		Admin a1 = new Admin(null, new Person(null,"Jean", "Test", "1", "0", 10, "13 rue du test"));
		adminRepo.save(a1);
		
		Consommateur c1 = new Consommateur(null, new Person(null,"ALBERT", "Geoffrey", "geof", "geof123", 23, "27 rue des sports"));
		consommateurRepo.save(c1);
		Consommateur c2 = new Consommateur(null,new Person(null,"CHARPENTIER", "Pierre", "pier", "pier123", 35, "15 rue du Moulin"));
		consommateurRepo.save(c2);
		Consommateur c3 = new Consommateur(null, new Person(null,"MORISSET", "Guillaume", "gui", "gui123", 54, "3 rue du code"));
		consommateurRepo.save(c3);
		
		Producteur p1 = new Producteur(null, "Chez Jojo", new Person(null,"BANKA", "Joel", "jojo", "jojo123", 84, "87 rue de France"), Arrays.asList(pr1));
		producteurRepo.save(p1);
		Producteur p2 = new Producteur(null,"Nos Ancêtres les Gaulois", new Person(null, "BONHOMME", "Clovis", "clo", "clo123", 42, "22 rue d'angular"),Arrays.asList(pr2, pr4, pr5, pr6));
		producteurRepo.save(p2);
		Producteur p3 = new Producteur(null,"Brasserie Terneyre", new Person(null,"TERNEYRE", "Benoit", "ben", "ben123", 84, "14 rue de Java"), Arrays.asList(pr3));
		producteurRepo.save(p3);
		
				
	}

}
