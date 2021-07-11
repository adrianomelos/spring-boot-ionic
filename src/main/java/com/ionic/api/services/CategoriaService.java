package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ionic.api.dto.CategoriaDto;
import com.ionic.api.entity.Categoria;
import com.ionic.api.exceptions.DatabaseException;
import com.ionic.api.exceptions.ResourceNotFoundException;
import com.ionic.api.repositorys.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catergoriaRepository;
	
	public List<Categoria> findAll(){
		return catergoriaRepository.findAll();
	}

	public Optional<Categoria> findById(Long id) {
		return catergoriaRepository.findById(id);
	}

	public Categoria save(CategoriaDto dto) {	
		Categoria c = new Categoria(null, dto.getCategoria(), null);	
		return catergoriaRepository.save(c);
	}

	public void delete(Long id) {
		try {
			catergoriaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (Exception e) {
			throw new DatabaseException("");
		}
	}
}
