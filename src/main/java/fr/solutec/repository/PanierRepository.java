package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Panier;

public interface PanierRepository extends CrudRepository<Panier, Long>{
	public Optional<Panier> findByConsommateurId(Long id);
}
