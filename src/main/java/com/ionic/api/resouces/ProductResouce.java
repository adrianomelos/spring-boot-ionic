package com.ionic.api.resouces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.api.entity.Product;
import com.ionic.api.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductResouce {
	
	@Autowired
	private ProductService productSevice;

	@GetMapping
	public List<Product> findAll() {
		return productSevice.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Product> findById(@PathVariable Long id) {
		return productSevice.findById(id);
	}
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return productSevice.save(product);
	} 
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productSevice.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	public Product update(@PathVariable Long id, @RequestBody Product product) {
		return productSevice.update(id, product);
	}
}
