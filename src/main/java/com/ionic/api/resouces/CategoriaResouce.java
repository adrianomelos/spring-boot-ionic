package com.ionic.api.resouces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.api.entity.Categoria;
import com.ionic.api.resouces.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResouce {
	
	@Autowired
	private CategoriaService categoriaSevice;

	@GetMapping
	public List<Categoria> findAll() {
		return categoriaSevice.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Categoria> findById(@PathVariable Long id) {
		return categoriaSevice.findById(id);
	}
}
