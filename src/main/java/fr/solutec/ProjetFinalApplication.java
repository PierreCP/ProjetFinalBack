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
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.type.SerializableToBlobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Image;
import fr.solutec.entities.Person;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.entities.SousTypeProduit;
import fr.solutec.entities.TypeProduit;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.ConsommateurRepository;
import fr.solutec.repository.ImageRepository;
import fr.solutec.repository.ProducteurRepository;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.SousTypeProduitRepository;
import fr.solutec.repository.TypeProduitRepository;

@SpringBootApplication
public class ProjetFinalApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private TypeProduitRepository tpRepo;
	@Autowired
	private SousTypeProduitRepository stpRepo;
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private ConsommateurRepository consommateurRepo;
	@Autowired
	private ProducteurRepository producteurRepo;
	@Autowired
	private ImageRepository imageRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalApplication.class, args);
		System.out.println("Lancement terminé");
		
	}
	
	public void addSousTypeToType(String typeName, String sousTypeName) {
		Optional<TypeProduit> type = tpRepo.getByName(typeName);
		Optional<SousTypeProduit> sousType = stpRepo.getByName(sousTypeName);
		if (type.isPresent() && sousType.isPresent()) {
			TypeProduit type1 = type.get();
			SousTypeProduit sousType1 = sousType.get();
			
			type1.getSousCategorie().add(sousType1);
			//  type.get().getSousCategorie().add(sousType.get());
			tpRepo.save(type.get());
		}
		else {
			System.out.println("Ca n'a pas marché");
		}
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creation/Update de la BDD");
		
		
		TypeProduit t1 = new TypeProduit(null, "Légumes", "Ici c'est la catégorie Légumes", null);
		tpRepo.save(t1);
		TypeProduit t2 = new TypeProduit(null, "Fromages", "Ici c'est la catégorie Fromages", null);
		tpRepo.save(t2);
		TypeProduit t3 = new TypeProduit(null, "Bières", "Ici c'est la catégorie Bières", null);
		tpRepo.save(t3);
		TypeProduit t4 = new TypeProduit(null, "Vins", "Ici c'est la catégorie Vins", null);
		tpRepo.save(t4);
		TypeProduit t5 = new TypeProduit(null, "Fruits", "Ici c'est la catégorie Fruits", null);
		tpRepo.save(t5);
		TypeProduit t6 = new TypeProduit(null, "Autres", "Ici c'est la catégorie Autres", null);
		tpRepo.save(t6);
		
		SousTypeProduit st1 = new SousTypeProduit(null, "Légumes racines, tubercules et tiges", "Ici c'est la catégorie Légumes racines, tubercules et tiges");
		stpRepo.save(st1);
		SousTypeProduit st2 = new SousTypeProduit(null, "Bières blondes", "Ici c'est la catégorie Bières blondes");
		stpRepo.save(st2);
		SousTypeProduit st3 = new SousTypeProduit(null, "Champagnes", "Ici c'est la catégorie Champagnes");
		stpRepo.save(st3);
		SousTypeProduit st4 = new SousTypeProduit(null, "Baies", "Ici c'est la catégorie Baies");
		stpRepo.save(st4);
		SousTypeProduit st5 = new SousTypeProduit(null, "Bières rousses", "Ici c'est la catégorie Bières rousses");
		stpRepo.save(st5);
		SousTypeProduit st6 = new SousTypeProduit(null, "Champignons", "Ici c'est la catégorie Champignons");
		stpRepo.save(st6);
		SousTypeProduit st7 = new SousTypeProduit(null, "Salades", "Ici c'est la catégorie Salades");
		stpRepo.save(st7);
		
		addSousTypeToType("Légumes", "Salades");
		addSousTypeToType("Bières", "Bières blondes");
		
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
		Produit pr7 = new Produit(null, "Champagne ALBERT", "Champagne 1995", 15, 22.52F, null, t4);
		produitRepo.save(pr7);
		
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
		
		Optional<TypeProduit> ty = tpRepo.getByName("Légumes");
		if (ty.isPresent()) {
			System.out.println("Le type récupéré est : " + ty.get().getCategorie());
		}
		else {
			System.out.println("Aucun type produit à ce nom");
		}
		
		
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
