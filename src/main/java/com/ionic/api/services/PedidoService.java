package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Pedido;
import com.ionic.api.exceptions.DatabaseException;
import com.ionic.api.exceptions.ResourceNotFoundException;
import com.ionic.api.repositorys.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public Optional<Pedido> findById(Long id) {
		return pedidoRepository.findById(id);
	}

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void delete(Long id) {
		try {
			pedidoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (Exception e) {
			throw new DatabaseException("");
		}
	}

}
