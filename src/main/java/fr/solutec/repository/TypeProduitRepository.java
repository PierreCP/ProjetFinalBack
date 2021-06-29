package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.TypeProduit;

public interface TypeProduitRepository extends CrudRepository<TypeProduit, Long> {
	public Optional<TypeProduit> findByCategorie(String name);
	
	@Query(value = "SELECT t FROM TypeProduit t WHERE t.categorie=?1")
	public Optional<TypeProduit> getByName(String name); 
}
