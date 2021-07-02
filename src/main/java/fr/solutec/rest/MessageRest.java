package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Message;
import fr.solutec.entities.Person;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.MessageRepository;
import fr.solutec.repository.PersonRepository;

@RestController @CrossOrigin("*")
public class MessageRest {
	
	 @Autowired
	 private MessageRepository mRepo;
	 
	 @Autowired
	 private PersonRepository pRepo;
	 
	 @Autowired
	 private AdminRepository adRepo;
	 
	 
	 @PostMapping("newMessage")
	 public Message newMessage(@RequestBody Message m) {
		 Long e = m.getEmetteur().getId();
		 Long r = m.getReceveur().getId();
		 if (pRepo.findById(e).isPresent() && pRepo.findById(r).isPresent()) {
			 return mRepo.save(m);
		 }
		 else 
			 return null;
		 }
	 
	 
	 @GetMapping("getMessage/{id}")
	 public Optional<Message> getMessage(@PathVariable Long id) {
		 return mRepo.findById(id);
	 }
	 
	 @GetMapping("getAllMessage")
	 public Iterable<Message> getAllMessage() {
		 return mRepo.findAll();
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
	 
	 @GetMapping("getMessage/admin/{id}/{contenu}")
	 public Message newMessageToAdmin(@PathVariable Long id, @PathVariable String contenu) {
		 Message m = new Message();
		 int compteur = (int) adRepo.count();
		 Person a = m.getEmetteur();
		 Iterable<Admin> listeAdmin = adRepo.findAll();
		 List<Admin> liste = new ArrayList<Admin>();
		 for (Admin admin : listeAdmin) {
			 liste.add(admin);
		}
		 Person p = liste.get(compteur-1).getPerson();
		 m.setContenu(contenu);
		 m.setReceveur(p);
		 m.setEmetteur(pRepo.findById(id).get());
		 return mRepo.save(m);
	 }
}
