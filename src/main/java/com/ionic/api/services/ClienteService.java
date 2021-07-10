package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Cliente;
import com.ionic.api.repositorys.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

}
