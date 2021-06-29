package fr.solutec;


import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Adress;
import fr.solutec.entities.Consommateur;
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

		
		Categorie ct1 = new Categorie(null, "Légumes", "Ici c'est la catégorie Légumes");
		tpRepo.save(ct1);
		Categorie ct2 = new Categorie(null, "Fromages", "Ici c'est la catégorie Fromages");
		tpRepo.save(ct2);
		Categorie ct3 = new Categorie(null, "Bières", "Ici c'est la catégorie Bières");
		tpRepo.save(ct3);
		Categorie ct4 = new Categorie(null, "Vins", "Ici c'est la catégorie Vins");
		tpRepo.save(ct4);
		Categorie ct5 = new Categorie(null, "Fruits", "Ici c'est la catégorie Fruits");
		tpRepo.save(ct5);
		Categorie ct6 = new Categorie(null, "Autres", "Ici c'est la catégorie Autres");
		tpRepo.save(ct6);

		SousCategorie st1 = new SousCategorie(null, "Légumes racines, tubercules et tiges",
				"Ici c'est la catégorie Légumes racines, tubercules et tiges", ct1);
		stpRepo.save(st1);
		SousCategorie st2 = new SousCategorie(null, "Bières blondes", "Ici c'est la catégorie Bières blondes", ct3);
		stpRepo.save(st2);
		SousCategorie st3 = new SousCategorie(null, "Champagnes", "Ici c'est la catégorie Champagnes", ct4);
		stpRepo.save(st3);
		SousCategorie st4 = new SousCategorie(null, "Baies", "Ici c'est la catégorie Baies", ct5);
		stpRepo.save(st4);
		SousCategorie st5 = new SousCategorie(null, "Bières rousses", "Ici c'est la catégorie Bières rousses", ct3);
		stpRepo.save(st5);
		SousCategorie st6 = new SousCategorie(null, "Champignons", "Ici c'est la catégorie Champignons", ct1);
		stpRepo.save(st6);
		SousCategorie st7 = new SousCategorie(null, "Salades", "Ici c'est la catégorie Salades", ct1);
		stpRepo.save(st7);

		// x12
		/*
		 * addSousTypeToType("Légumes", "Salades"); addSousTypeToType("Bières",
		 * "Bières blondes");
		 */

		Produit pr1 = new Produit(null, "Patate", "Sac 1Kg de pomme de terre de corse", 45, 3.99F, null, st1);
		produitRepo.save(pr1);
		Produit pr2 = new Produit(null, "Camembert", "camembert de Normandie extra fondant", 23, 2.54F, null, null);
		produitRepo.save(pr2);
		Produit pr3 = new Produit(null, "Bière", "Bière Cuvée des Trolls 8° 1L", 150, 6.77F, null, st2);
		produitRepo.save(pr3);
		Produit pr4 = new Produit(null, "Vacherin", "Vacherin des montagnes affiné", 2, 4.86F, null, st3);
		produitRepo.save(pr4);
		Produit pr5 = new Produit(null, "Chevre", "Chèvre frais aux épices douces", 10, 3.45F, null, st3);
		produitRepo.save(pr5);
		Produit pr6 = new Produit(null, "Comté", "Comté affiné 18 mois", 8, 8.52F, null, st5);
		produitRepo.save(pr6);
		Produit pr7 = new Produit(null, "Champagne ALBERT", "Champagne 1995", 15, 22.52F, null, st7);
		produitRepo.save(pr7);

		Admin a1 = new Admin(null, new Person(null, "Jean", "Test", "1", "0", 10, 
				new Adress(null, 13, "Rue du Test", "75007", "Paris")));
		adminRepo.save(a1);

		Consommateur c1 = new Consommateur(null,
				new Person(null, "ALBERT", "Geoffrey", "geof", "geof123", 23, 
						new Adress(null, 27, "Rue des Sports", "78150", "Le Chesnay-Rocquencourt")));
		consommateurRepo.save(c1);
		Consommateur c2 = new Consommateur(null,
				new Person(null, "CHARPENTIER", "Pierre", "pier", "pier123", 35, 
						new Adress(null, 15, "Rue du Moulin", "92800", "Puteaux")));
		consommateurRepo.save(c2);
		Consommateur c3 = new Consommateur(null,
				new Person(null, "MORISSET", "Guillaume", "gui", "gui123", 54, 
						new Adress(null, 4, "rue du haras", "44119", "Treillieres")));
		consommateurRepo.save(c3); 

		Producteur p1 = new Producteur(null, "Chez Jojo",
				new Person(null, "BANKA", "Joel", "jojo", "jojo123", 84, 
						new Adress(null, 87, "Rue de France", "06000", "Nice")), Arrays.asList(pr1));
		producteurRepo.save(p1);
		Producteur p2 = new Producteur(null, "Nos Ancêtres les Gaulois",
				new Person(null, "BONHOMME", "Clovis", "clo", "clo123", 42, 
						new Adress(null, 22, "Rue Anguleuse", "67100", "Strasbourg")),Arrays.asList(pr2, pr4, pr5, pr6));
		producteurRepo.save(p2);
		Producteur p3 = new Producteur(null, "Brasserie Terneyre",
				new Person(null, "TERNEYRE", "Benoit", "ben", "ben123", 84, 
						new Adress(null, 14, "Rue de Java", "45000", "Orléans")), Arrays.asList(pr3));
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
