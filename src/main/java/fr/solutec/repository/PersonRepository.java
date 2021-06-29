package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	public Optional<Person> findByLoginAndMdp(String login, String mdp);
}
