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

import com.ionic.api.dto.ProdutoDto;
import com.ionic.api.entity.Produto;
import com.ionic.api.services.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResouce {
	
	@Autowired
	private ProdutoService produtoSevice;

	@GetMapping
	public List<Produto> findAll() {
		return produtoSevice.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Produto> findById(@PathVariable Long id) {
		return produtoSevice.findById(id);
	}
	
	@PostMapping
	public Produto save(@RequestBody Produto produto) {
		return produtoSevice.save(produto);
	} 
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produtoSevice.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
		return produtoSevice.update(id, produto);
	}
}
