package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Person;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	public Optional<Admin> findByPersonId(Long id);
}
