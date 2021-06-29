package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Producteur;

public interface ProducteurRepository extends CrudRepository<Producteur, Long>{
	public Optional<Producteur> findByPersonId(Long id);
}
