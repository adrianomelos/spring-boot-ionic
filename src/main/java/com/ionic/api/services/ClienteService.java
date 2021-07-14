package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Cliente;
import com.ionic.api.exceptions.DatabaseException;
import com.ionic.api.exceptions.ResourceNotFoundException;
import com.ionic.api.repositorys.ClienteRepository;
import com.ionic.api.repositorys.EnderecoRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	public Cliente save(Cliente cl) {
		Cliente c = new Cliente(null, cl.getNome(), cl.getEmail(), cl.getCpfOuCnpj(), cl.getTipo(), null,
				cl.getTelefones(), null);

		c.setEnderecos(cl.getEnderecos());
		enderecoRepository.saveAll(c.getEnderecos());
		return clienteRepository.save(cl);
	}

	public void delete(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (Exception e) {
			throw new DatabaseException("");
		}
	}

}
