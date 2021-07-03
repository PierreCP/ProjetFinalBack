package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Image;
import fr.solutec.entities.Produit;
import fr.solutec.repository.ImageRepository;
import fr.solutec.repository.ProduitRepository;

@RestController @CrossOrigin("*")
public class ImageRest {

	@Autowired
	private ImageRepository ir;
	
	@Autowired
	private ProduitRepository pr;
	
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
	
	@PutMapping("image/{id}")
	public Produit setImageProduit(@RequestBody byte[] img, @PathVariable Long id) {
		pr.findById(id).get().setImage(img);
		return pr.save(pr.findById(id).get());
	}
}