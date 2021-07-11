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

import com.ionic.api.entity.Pagamento;
import com.ionic.api.services.PagamentoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResouce {

	@Autowired
	private PagamentoService pagamentoSevice;

	@GetMapping
	public List<Pagamento> findAll() {
		return pagamentoSevice.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Pagamento> findById(@PathVariable Long id) {
		return pagamentoSevice.findById(id);
	}

	@PostMapping
	public Pagamento save(@RequestBody Pagamento pagamento) {
		return pagamentoSevice.save(pagamento);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pagamentoSevice.delete(id);
	}

}
