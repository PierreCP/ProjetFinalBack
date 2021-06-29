package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Consommateur;

public interface ConsommateurRepository extends CrudRepository<Consommateur, Long>{
	public Optional<Consommateur> findByPersonId(Long id);
}
