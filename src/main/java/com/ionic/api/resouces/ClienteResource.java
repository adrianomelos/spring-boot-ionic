package com.ionic.api.resouces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.api.entity.Cliente;
import com.ionic.api.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteSevice;

	@GetMapping
	public List<Cliente> findAll() {
		return clienteSevice.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return clienteSevice.findById(id);
	}

	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteSevice.save(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteSevice.delete(id);
	}

}
