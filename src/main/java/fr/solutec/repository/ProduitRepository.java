package fr.solutec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	public Iterable<Produit> findByTypeCategorie(String categorie);
	
	//@Query(value = "SELECT p FROM Produit p INNER JOIN TypeProduit t ON p.id=t.id INNER JOIN SousTypeProduit st ON p.id=st.id WHERE st.sousCategorie=?1")
	//public List<Produit> getProduitBySousType(String sousCategorie);
	
}
