package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.SousCategorie;

public interface SousCategorieRepository extends CrudRepository<SousCategorie, Long>{
	
	public Optional<SousCategorie> findByNom(String nom);
	//x12
	/*public Optional<SousCategorie> findBySousCategorie(String name);

	@Query(value = "SELECT st FROM SousCategorie st WHERE st.sousCategorie=?1")
	public Optional<SousCategorie> getByName(String name); */
}
