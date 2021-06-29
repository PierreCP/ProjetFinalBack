package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Adress;


public interface AdressRepository extends CrudRepository<Adress, Long>{

}
