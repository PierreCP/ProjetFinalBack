package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	public Iterable<Produit> findBySousCategorieCategorieNom(String categorie);
	public Iterable<Produit> findBySousCategorieNom(String categorie);
	public Produit findByNom(String nom);
	
	//@Query(value = "SELECT p FROM Produit p INNER JOIN Categorie t ON p.id=t.id INNER JOIN SousCategorie st ON p.id=st.id WHERE st.sousCategorie=?1")
	//public List<Produit> getProduitBySousType(String sousCategorie);
	
}
