package com.ionic.api.resouces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.api.entity.Pedido;
import com.ionic.api.services.PedidoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResouce {

	@Autowired
	private PedidoService pedidoSevice;

	@GetMapping
	public List<Pedido> findAll() {
		return pedidoSevice.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Pedido> findById(@PathVariable Long id) {
		return pedidoSevice.findById(id);
	}

	@PostMapping
	public Pedido save(@RequestBody Pedido pedido) {
		return pedidoSevice.save(pedido);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pedidoSevice.delete(id);
	}

}
