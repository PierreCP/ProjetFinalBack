package fr.solutec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.repository.PersonRepo;

@SpringBootApplication
public class ProjetFinalApplication implements CommandLineRunner {
	@Autowired
	private PersonRepo pr;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalApplication.class, args);
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creation/Update de la BDD");
		//Produit p1 = new Produit(null, "patate", "dans la terrre", 3, (float) 2.5, "hiver", null);
		//pror.save(p1);
		
		Admin a1 = new Admin(null, "Jean", "Test", "1", "0", 10, "14 rue du test");
		pr.save(a1);
		
	}

}
