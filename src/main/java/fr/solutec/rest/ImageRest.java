package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Image;
import fr.solutec.repository.ImageRepository;

@RestController @CrossOrigin("*")
public class ImageRest {

	@Autowired
	private ImageRepository ir;
	
	@PutMapping("image/{id}")
	public Optional<Image> putImage(@RequestBody Long id) {
		Optional<Image> image = ir.findById(id);
		return image;
		
	}
	
}
