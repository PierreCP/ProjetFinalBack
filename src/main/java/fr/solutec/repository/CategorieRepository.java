package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Categorie;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
	//x12
	/*public Optional<Categorie> findByCategorie(String name);
	
	@Query(value = "SELECT t FROM Categorie t WHERE t.categorie=?1")
	public Optional<Categorie> getByName(String name); */
}
