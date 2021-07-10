package com.ionic.api.resouces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.api.entity.Cliente;
import com.ionic.api.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService categoriaSevice;

	@GetMapping
	public List<Cliente> findAll() {
		return categoriaSevice.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return categoriaSevice.findById(id);
	}
}
