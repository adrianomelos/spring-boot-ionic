package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Product;
import com.ionic.api.exceptions.DatabaseException;
import com.ionic.api.exceptions.ResourceNotFoundException;
import com.ionic.api.repositorys.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (Exception e) {
			throw new DatabaseException("");
		}
	}

	public Product update(Long id, Product product) {
		Optional<Product> obj =  productRepository.findById(id);
		obj.get().setName(product.getName());
		obj.get().setPrice(product.getPrice());
		return productRepository.save(obj.get());
	}
}
