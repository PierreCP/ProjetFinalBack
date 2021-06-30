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
import fr.solutec.entities.Adress;
import fr.solutec.entities.Consommateur;
import fr.solutec.entities.Image;
import fr.solutec.entities.Person;
import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;
import fr.solutec.entities.SousCategorie;
import fr.solutec.entities.Categorie;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.AdressRepository;
import fr.solutec.repository.ConsommateurRepository;
import fr.solutec.repository.ImageRepository;
import fr.solutec.repository.ProducteurRepository;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.SousCategorieRepository;
import fr.solutec.repository.CategorieRepository;

@SpringBootApplication
public class ProjetFinalApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private CategorieRepository tpRepo;
	@Autowired
	private SousCategorieRepository stpRepo;
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

	// x12
	/*
	 * public void addSousTypeToType(String typeName, String sousTypeName) {
	 * Optional<Categorie> type = tpRepo.getByName(typeName);
	 * Optional<SousCategorie> sousType = stpRepo.getByName(sousTypeName); if
	 * (type.isPresent() && sousType.isPresent()) { Categorie type1 = type.get();
	 * SousCategorie sousType1 = sousType.get();
	 * 
	 * type1.getSousCategorie().add(sousType1); //
	 * type.get().getSousCategorie().add(sousType.get()); tpRepo.save(type.get()); }
	 * else { System.out.println("Ca n'a pas marché"); }
	 * 
	 * }
	 */

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creation/Update de la BDD");



		Categorie ct1 = new Categorie(null, "Fruits", "Ici c'est la catégorie Fruits");
		tpRepo.save(ct1);
		Categorie ct2 = new Categorie(null, "Légumes", "Ici c'est la catégorie Légumes");
		tpRepo.save(ct2);
		Categorie ct3 = new Categorie(null, "Fromages", "Ici c'est la catégorie Fromages");
		tpRepo.save(ct3);
		Categorie ct4 = new Categorie(null, "Vins", "Ici c'est la catégorie Vins");
		tpRepo.save(ct4);
		Categorie ct5 = new Categorie(null, "Bières", "Ici c'est la catégorie Bières");
		tpRepo.save(ct5);
		Categorie ct6 = new Categorie(null, "Autres", "Ici c'est la catégorie Autres");
		tpRepo.save(ct6);

		SousCategorie st1 = new SousCategorie(null, "Drupes","Ici c'est la sous-catégorie drupes", ct1);
		stpRepo.save(st1);
		SousCategorie st2 = new SousCategorie(null, "Baies","Ici c'est la sous-catégorie baies", ct1);
		stpRepo.save(st2);
		SousCategorie st3 = new SousCategorie(null, "Pommes et poires","Ici c'est la sous-catégorie pommes et poires", ct1);
		stpRepo.save(st3);
		SousCategorie st4= new SousCategorie(null, "Agrumes","Ici c'est la sous-catégorie agrumes", ct1);
		stpRepo.save(st4);
		SousCategorie st5 = new SousCategorie(null, "Pepos","Ici c'est la sous-catégorie pepos", ct1);
		stpRepo.save(st5);
		SousCategorie st6 = new SousCategorie(null, "Tropicaux","Ici c'est la sous-catégorie des fruits tropicaux", ct1);
		stpRepo.save(st6);
		SousCategorie st7 = new SousCategorie(null, "Légumes racines, tubercules et tiges","Ici c'est la catégorie Légumes racines, tubercules et tiges", ct2);
		stpRepo.save(st7);
		SousCategorie st8 = new SousCategorie(null, "Choux","Ici c'est la catégorie des choux", ct2);
		stpRepo.save(st8);
		SousCategorie st9 = new SousCategorie(null, "Courges","Ici c'est la catégorie des courges", ct2);
		stpRepo.save(st9);
		SousCategorie st10 = new SousCategorie(null, "Champignons","Ici c'est la catégorie des champignons", ct2);
		stpRepo.save(st10);
		SousCategorie st11 = new SousCategorie(null, "Aromatiques","Ici c'est la catégorie aromatiques.", ct2);
		stpRepo.save(st11);
		SousCategorie st12= new SousCategorie(null, "Légumes fruits","Ici c'est la catégorie légumes fruits", ct2);
		stpRepo.save(st12);
		SousCategorie st13 = new SousCategorie(null, "Salades","Ici c'est la catégorie salades", ct2);
		stpRepo.save(st13);
		SousCategorie st14 = new SousCategorie(null, "Légumes feuilles","Ici c'est la catégorie légumes feuilles", ct2);
		stpRepo.save(st14);
		SousCategorie st15 = new SousCategorie(null, "Haricots, pois, légumes secs, graines germées","Ici c'est la catégorie des légumes secs et autres", ct2);
		stpRepo.save(st15);
		SousCategorie st16 = new SousCategorie(null, "Vins rouges", "Ici c'est la sous-catégorie vins rouges", ct4);
		stpRepo.save(st16);
		SousCategorie st17 = new SousCategorie(null, "Vins blancs", "Ici c'est la sous-catégorie vins blancs", ct4);
		stpRepo.save(st17);
		SousCategorie st18 = new SousCategorie(null, "Vins rosés", "Ici c'est la sous-catégorie vins rosés", ct4);
		stpRepo.save(st18);
		SousCategorie st19 = new SousCategorie(null, "Champagnes", "Ici c'est la catégorie champagnes", ct4);
		stpRepo.save(st19);
		SousCategorie st20 = new SousCategorie(null, "Bières blanches", "Ici c'est la catégorie bières blanches", ct5);
		stpRepo.save(st20);
		SousCategorie st21 = new SousCategorie(null, "Bières blondes", "Ici c'est la catégorie bières blondes", ct5);
		stpRepo.save(st21);
		SousCategorie st22 = new SousCategorie(null, "Bières ambrées ou rousse", "Ici c'est la catégorie bières ambrées ou rousse", ct5);
		stpRepo.save(st22);
		SousCategorie st23 = new SousCategorie(null, "Bières brunes", "Ici c'est la catégorie bières brunes", ct5);
		stpRepo.save(st23);
		SousCategorie st24 = new SousCategorie(null, "Fromages", "", ct3);
		stpRepo.save(st24);



		Produit pr1 = new Produit(null, "Patate", "Sac 1Kg de pomme de terre de corse", 45, 3.99F, null, st7);
		produitRepo.save(pr1);
		Produit pr2 = new Produit(null, "Camembert", "camembert de Normandie extra fondant", 23, 2.54F, null, st24);
		produitRepo.save(pr2);
		Produit pr3 = new Produit(null, "Bière", "Bière Cuvée des Trolls 8° 1L", 150, 6.77F, null, st21);
		produitRepo.save(pr3);
		Produit pr4 = new Produit(null, "Vacherin", "Vacherin des montagnes affiné", 2, 4.86F, null, st24);
		produitRepo.save(pr4);
		Produit pr5 = new Produit(null, "Chevre", "Chèvre frais aux épices douces", 10, 3.45F, null, st24);
		produitRepo.save(pr5);
		Produit pr6 = new Produit(null, "Comté", "Comté affiné 18 mois", 8, 8.52F, null, st24);
		produitRepo.save(pr6);
		Produit pr7 = new Produit(null, "Champagne ALBERT", "Champagne 1995", 15, 22.52F, null, st19);
		produitRepo.save(pr7);
		Produit pr8 = new Produit(null, "Abricot", "Abricots délicieux", 15, 1.52F, null, st1);
		produitRepo.save(pr8);
		Produit pr9 = new Produit(null, "Raisin", "", 15, 1.52F, null, st2);
		produitRepo.save(pr9);
		Produit pr10 = new Produit(null, "Pommes", "", 15, 1.52F, null, st3);
		produitRepo.save(pr10);
		Produit pr11 = new Produit(null, "Mandarine", "", 15, 1.52F, null, st4);
		produitRepo.save(pr11);
		Produit pr12 = new Produit(null, "Melon", "", 15, 1.52F, null, st5);
		produitRepo.save(pr12);
		Produit pr13 = new Produit(null, "Ananas", "", 15, 1.52F, null, st6);
		produitRepo.save(pr13);
		Produit pr14 = new Produit(null, "Choux-fleur", "", 15, 1.52F, null, st8);
		produitRepo.save(pr14);
		Produit pr15 = new Produit(null, "Potiron", "", 15, 1.52F, null, st9);
		produitRepo.save(pr15);
		Produit pr16 = new Produit(null, "Champignon de paris", "", 15, 1.52F, null, st10);
		produitRepo.save(pr16);
		Produit pr17 = new Produit(null, "Vin rouge de SQY", "Vin rouge d'exception de 1995", 15, 1.52F, null, st16);
		produitRepo.save(pr17);
		Produit pr18 = new Produit(null, "Pêche", "", 15, 1.52F, null, st1);
		produitRepo.save(pr18);

		Admin a1 = new Admin(null, new Person(null, "Jean", "Test", "1", "0", 10, 
				new Adress(null, 13, "Rue du Test", "75007", "Paris", 132, 1542)));
		adminRepo.save(a1);

		Consommateur c1 = new Consommateur(null,
				new Person(null, "ALBERT", "Geoffrey", "geof", "geof123", 23, 
						new Adress(null, 27, "Rue des Sports", "78150", "Le Chesnay-Rocquencourt",1515, 1515)));
		consommateurRepo.save(c1);
		Consommateur c2 = new Consommateur(null,
				new Person(null, "CHARPENTIER", "Pierre", "pier", "pier123", 35, 
						new Adress(null, 15, "Rue du Moulin", "92800", "Puteaux", 1646, 15161)));
		consommateurRepo.save(c2);
		Consommateur c3 = new Consommateur(null,
				new Person(null, "MORISSET", "Guillaume", "gui", "gui123", 54, 
						new Adress(null, 3, "Rue du Code", "07400", "Alba-la-Romaine", 46313, 15652)));
		consommateurRepo.save(c3); 

		Producteur p1 = new Producteur(null, "Chez Jojo", new Person(null, "BANKA", "Joel", "jojo", "jojo123", 84, new Adress(null, 87, "Rue de France", "06000", "Nice", 21615, 4153)), Arrays.asList(pr12, pr2, pr3, pr4, pr5, pr7, pr8, pr18));
		producteurRepo.save(p1);
		Producteur p2 = new Producteur(null, "Nos Ancêtres les Gaulois",new Person(null, "BONHOMME", "Clovis", "clo", "clo123", 42, new Adress(null, 22, "Rue Anguleuse", "67100", "Strasbourg",416, 1615)),Arrays.asList(pr2, pr4, pr5, pr6));
		producteurRepo.save(p2);
		Producteur p3 = new Producteur(null, "Brasserie Terneyre", new Person(null, "TERNEYRE", "Benoit", "ben", "ben123", 84, 
						new Adress(null, 14, "Rue de Java", "45000", "Orléans", 4646,4512)), Arrays.asList(pr3, pr8, pr16, pr17, pr15, pr12));

		producteurRepo.save(p3);

		/*
		 * String mysqlUrl = "jdbc:mysql://localhost/projet-final"; Connection con =
		 * DriverManager.getConnection(mysqlUrl, "root", ""); String query =
		 * "INSERT INTO Image(id,titre,commentaire, img) VALUES (?, ?, ?, ?)";
		 * PreparedStatement pstmt = con.prepareStatement(query); pstmt.setInt(1, 1159);
		 * pstmt.setString(2, "Fromage"); pstmt.setString(3, "Mon plus beau gruyère");
		 * FileInputStream image = new
		 * FileInputStream("C:\\Users\\stagiaire\\Desktop\\fromage.jpg");
		 * pstmt.setBlob(4, image); pstmt.execute();
		 * 
		 * Statement stmt = con.createStatement(); ResultSet rs =
		 * stmt.executeQuery("select * from image"); int i = 1; while(rs.next()) {
		 * System.out.println(rs.getString("titre")); Blob blob = rs.getBlob("img");
		 * byte byteArray[] = blob.getBytes(1,(int)blob.length());
		 * 
		 * @SuppressWarnings("resource") FileOutputStream outPutStream = new
		 * FileOutputStream("C:\\Users\\stagiaire\\Desktop\\blob_output"+i+".jpg");
		 * outPutStream.write(byteArray);
		 * System.out.println("C:\\Users\\stagiaire\\Desktop\\blob_output"+i+".jpg");
		 * System.out.println(); i++; }
		 * 
		 * FileInputStream imgFromage = new
		 * FileInputStream("C:\\Users\\stagiaire\\Desktop\\fromage.jpg"); Image i1 = new
		 * Image(null, "Fromage", "Mon plus beau gruyère", imgFromage);
		 * imageRepo.save(i1);
		 */

	}

}
