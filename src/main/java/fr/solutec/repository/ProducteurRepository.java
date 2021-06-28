package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Producteur;
import fr.solutec.entities.Produit;

public interface ProducteurRepository extends CrudRepository<Producteur, Long>{
	
}
