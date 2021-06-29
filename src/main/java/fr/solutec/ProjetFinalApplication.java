package fr.solutec;


import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.type.SerializableToBlobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Adress;
import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Image;
import fr.solutec.entities.Person;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.entities.TypeProduit;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.AdressRepository;
import fr.solutec.repository.ConsommateurRepository;
import fr.solutec.repository.ImageRepository;
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
	@Autowired
	private AdressRepository adressRepo;
	@Autowired
	private ImageRepository imageRepo;
	
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
		
		Admin a1 = new Admin(null, new Person(null,"Jean", "Test", "1", "0", 10, new Adress(null, 13, "Rue du Test", "75007", "Paris")));
		adminRepo.save(a1);
		
		Consommateur c1 = new Consommateur(null, new Person(null,"ALBERT", "Geoffrey", "geof", "geof123", 23, new Adress(null, 27, "Rue des Sports", "78150", "Le Chesnay-Rocquencourt")));
		consommateurRepo.save(c1);
		Consommateur c2 = new Consommateur(null,new Person(null,"CHARPENTIER", "Pierre", "pier", "pier123", 35, new Adress(null, 15, "Rue du Moulin", "92800", "Puteaux")));
		consommateurRepo.save(c2);
		Consommateur c3 = new Consommateur(null, new Person(null,"MORISSET", "Guillaume", "gui", "gui123", 54, new Adress(null, 3, "Rue du Code", "07400", "Alba-la-Romaine")));
		consommateurRepo.save(c3);
		
		Producteur p1 = new Producteur(null, "Chez Jojo", new Person(null,"BANKA", "Joel", "jojo", "jojo123", 84, new Adress(null, 87, "Rue de France", "06000", "Nice")), Arrays.asList(pr1));
		producteurRepo.save(p1);
		Producteur p2 = new Producteur(null,"Nos Ancêtres les Gaulois", new Person(null, "BONHOMME", "Clovis", "clo", "clo123", 42, new Adress(null, 22, "Rue Anguleuse", "67100", "Strasbourg")),Arrays.asList(pr2, pr4, pr5, pr6));
		producteurRepo.save(p2);
		Producteur p3 = new Producteur(null,"Brasserie Terneyre", new Person(null,"TERNEYRE", "Benoit", "ben", "ben123", 84, new Adress(null, 14, "Rue de Java", "45000", "Orléans")), Arrays.asList(pr3));
		producteurRepo.save(p3);
		
		/*
		String mysqlUrl = "jdbc:mysql://localhost/projet-final";
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
		String query = "INSERT INTO Image(id,titre,commentaire, img) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 1159);
		pstmt.setString(2, "Fromage");
		pstmt.setString(3, "Mon plus beau gruyère");
		FileInputStream image = new FileInputStream("C:\\Users\\stagiaire\\Desktop\\fromage.jpg");
		pstmt.setBlob(4, image);
		pstmt.execute();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from image");
		int i = 1;
		while(rs.next()) {
			System.out.println(rs.getString("titre"));
			Blob blob = rs.getBlob("img");
			byte byteArray[] = blob.getBytes(1,(int)blob.length());
			@SuppressWarnings("resource")
			FileOutputStream outPutStream = new FileOutputStream("C:\\Users\\stagiaire\\Desktop\\blob_output"+i+".jpg");
			outPutStream.write(byteArray);
			System.out.println("C:\\Users\\stagiaire\\Desktop\\blob_output"+i+".jpg");
			System.out.println();
			i++;
		}
		
		FileInputStream imgFromage = new FileInputStream("C:\\Users\\stagiaire\\Desktop\\fromage.jpg");
		Image i1 = new Image(null, "Fromage", "Mon plus beau gruyère", imgFromage);
		imageRepo.save(i1);
		*/
		
				
	}

}
