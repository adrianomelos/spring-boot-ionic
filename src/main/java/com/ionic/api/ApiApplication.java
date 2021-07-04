package com.ionic.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ionic.api.entity.Categoria;
import com.ionic.api.entity.Produto;
import com.ionic.api.repositorys.CategoriaRepository;
import com.ionic.api.repositorys.ProdutoRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática", null);
		Categoria cat2 = new Categoria(null, "Escritório", null);

		Produto p1 = new Produto(null, "Computador", 2000.00, null);
		Produto p2 = new Produto(null, "Impressora", 800.00, null);
		Produto p3 = new Produto(null, "Mouse", 30.00, null);
		
		cat1.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));

		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1, cat2));
		p3.setCategorias(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}