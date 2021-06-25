package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Person;
import fr.solutec.repository.PersonRepo;



@RestController @CrossOrigin("*")
public class PersonRest {

	@Autowired
	private PersonRepo pr;

	@PostMapping("person")
	public Person savePerson(@RequestBody Person p) {
		return pr.save(p);
	}

	@GetMapping("person")
	public Iterable<Person> getAllPerson() {
		return pr.findAll();
	}

	@GetMapping("person/{id}")
	public Optional<Person> getOnePerson(@PathVariable Long id) {
		return pr.findById(id);
	}

	@DeleteMapping("person/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		if(pr.findById(id).isPresent()) {
			pr.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PutMapping("person/{id}")
	public Person putPerson(@RequestBody Person p, @PathVariable Long id) {
		if (pr.findById(id).isPresent()) {
			p.setId(id);
			return pr.save(p);
		}
		else {
			return null;
		}
	}
	
	@PostMapping("login")
	public Optional<Person> connexion(@RequestBody Person p) {
		return pr.findByLoginAndMdp(p.getLogin(), p.getMdp());
	}

	
}
