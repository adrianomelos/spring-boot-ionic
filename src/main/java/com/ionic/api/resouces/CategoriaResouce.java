package com.ionic.api.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
