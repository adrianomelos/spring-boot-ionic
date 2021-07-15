package com.ionic.api.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Cliente;
import com.ionic.api.enuns.Perfil;
import com.ionic.api.exceptions.DatabaseException;
import com.ionic.api.exceptions.ResourceNotFoundException;
import com.ionic.api.repositorys.ClienteRepository;
import com.ionic.api.repositorys.EnderecoRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	public Cliente save(Cliente cl) {
		
		Set<Integer> perfis = new HashSet<>();
		perfis.add(Perfil.CLIENTE.getCod());
		
		Cliente c = new Cliente(null, cl.getNome(), cl.getEmail(), cl.getCpfOuCnpj(), cl.getTipo(), pe.encode(cl.getSenha()) , null,
				cl.getTelefones(), perfis, null);

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
