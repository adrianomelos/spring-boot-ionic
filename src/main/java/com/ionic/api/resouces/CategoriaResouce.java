package com.ionic.api.resouces;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.api.dto.CategoriaDto;
import com.ionic.api.entity.Categoria;
import com.ionic.api.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResouce {

	@Autowired
	private CategoriaService categoriaSevice;

	@GetMapping
	public List<Categoria> findAll() {
		return categoriaSevice.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Categoria> findById(@PathVariable Long id) {
		return categoriaSevice.findById(id);
	}

	@PostMapping
	public Categoria save(@Valid @RequestBody CategoriaDto dto) {
		return categoriaSevice.save(dto);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		categoriaSevice.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Categoria update(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		return categoriaSevice.update(id, categoria);
	}

	@GetMapping(value = "/page")
	public Page<Categoria> pagefindAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "qtd", defaultValue = "24") Integer qtd,
			@RequestParam(value = "orderBy", defaultValue = "categoria") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		PageRequest paginacao = PageRequest.of(page, qtd, Direction.valueOf(direction), orderBy);
		return categoriaSevice.findPage(paginacao);
	}

}
