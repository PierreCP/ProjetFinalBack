package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.SousTypeProduit;
import fr.solutec.entities.TypeProduit;

public interface SousTypeProduitRepository extends CrudRepository<SousTypeProduit, Long>{
	public Optional<SousTypeProduit> findBySousCategorie(String name);

	@Query(value = "SELECT st FROM SousTypeProduit st WHERE st.sousCategorie=?1")
	public Optional<SousTypeProduit> getByName(String name); 
}
