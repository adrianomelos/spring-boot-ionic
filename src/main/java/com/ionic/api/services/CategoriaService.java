package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Categoria save(@Valid CategoriaDto dto) {	
		Categoria c = new Categoria(null, dto.getNome(), null);	
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

	public Categoria update(Long id, Categoria categoria) {
		Optional<Categoria> obj =  catergoriaRepository.findById(id);
		obj.get().setNome(categoria.getNome());
		return catergoriaRepository.save(obj.get());
	}
	
	public Page<Categoria> findPage(Pageable paginacao){
		return catergoriaRepository.findAll(paginacao);
	}
}
