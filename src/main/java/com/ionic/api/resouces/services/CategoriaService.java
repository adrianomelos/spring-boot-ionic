package com.ionic.api.resouces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Categoria;
import com.ionic.api.resouces.repositorys.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catergoriaRepository;
	
	public List<Categoria> findAll(){
		return catergoriaRepository.findAll();
	}

}
