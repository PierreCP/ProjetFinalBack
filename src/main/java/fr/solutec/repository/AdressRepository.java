package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Adress;
import fr.solutec.entities.Person;


public interface AdressRepository extends CrudRepository<Adress, Long>{
	public Optional<Adress> findById(Long id);
}
