package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Message;
import fr.solutec.entities.Person;
import fr.solutec.repository.MessageRepository;
import fr.solutec.repository.PersonRepository;

@RestController @CrossOrigin("*")
public class MessageRest {
	
	 @Autowired
	 private MessageRepository mRepo;
	 
	 @Autowired
	 private PersonRepository pRepo;
	 
	  
	 @PostMapping("newMessage")
	 public Message newMessage(@RequestBody Message m) {
		 Long e = m.getEmetteur().getId();
		 Long r = m.getReceveur().getId();
		 if (pRepo.findById(e).isPresent() && pRepo.findById(r).isPresent()) {
			 return mRepo.save(m);
		 }
		 else {
			 return null;
		 }
	 }
	 
	 @GetMapping("getMessage/{id}")
	 public Optional<Message> getMessage(@PathVariable Long id) {
		 return mRepo.findById(id);
	 }
	 
	 @GetMapping("messagerie/boiteReception/{id}")
	 public Iterable<Message> boiteReception(@PathVariable Long id){
		 return mRepo.findByReceveurId(id);
	 }
	 
	 @GetMapping("messagerie/boiteEnvoi/{id}")
	 public Iterable<Message> boiteEnvoi(@PathVariable Long id){
		 return mRepo.findByEmetteurId(id);
	 }
	 
	 @DeleteMapping("deleteMessage/{id}")
		public boolean deleteMessage(@PathVariable Long id) {
			if(mRepo.findById(id).isPresent()) {
				mRepo.deleteById(id);
				return true;
			}
			else {
				return false;
			}
		}
}
