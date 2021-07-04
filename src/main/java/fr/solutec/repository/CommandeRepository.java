package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Commande;
import fr.solutec.entities.Consommateur;

public interface CommandeRepository extends CrudRepository<Commande, Long>{
	public Iterable<Commande> findAllByConsomId(Long id);
}
