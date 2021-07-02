package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Long>{

}
