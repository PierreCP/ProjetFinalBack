package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.solutec.entities.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{
	public Optional<Person> findByLoginAndMdp(String login, String mdp);
}
