package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	public Iterable<Produit> findByTypeCategorie(String categorie);
	
}
