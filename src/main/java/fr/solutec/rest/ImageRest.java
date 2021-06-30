package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Image;
import fr.solutec.repository.ImageRepository;

@RestController @CrossOrigin("*")
public class ImageRest {

	@Autowired
	private ImageRepository ir;
	
	@GetMapping("image/{id}")
	public Optional<Image> getImage(@PathVariable Long id) {
			return ir.findById(id);
	}
	
	@GetMapping("image")
	public Iterable<Image> getAllImage() {
		return ir.findAll();
	}
	
	@PostMapping("upload")
	public Image upload(@RequestBody Image i) {
		return ir.save(i);
	}
	
}