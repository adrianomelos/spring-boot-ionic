package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Pagamento;
import com.ionic.api.exceptions.DatabaseException;
import com.ionic.api.exceptions.ResourceNotFoundException;
import com.ionic.api.repositorys.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	public List<Pagamento> findAll() {
		return pagamentoRepository.findAll();
	}

	public Optional<Pagamento> findById(Long id) {
		return pagamentoRepository.findById(id);
	}

	public Pagamento save(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}

	public void delete(Long id) {
		try {
			pagamentoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (Exception e) {
			throw new DatabaseException("");
		}
	}

}
