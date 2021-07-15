package com.ionic.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Categoria;
import com.ionic.api.entity.Cidade;
import com.ionic.api.entity.Cliente;
import com.ionic.api.entity.Endereco;
import com.ionic.api.entity.Estado;
import com.ionic.api.enuns.Perfil;
import com.ionic.api.enuns.TipoCliente;
import com.ionic.api.repositorys.CategoriaRepository;
import com.ionic.api.repositorys.CidadeRepository;
import com.ionic.api.repositorys.ClienteRepository;
import com.ionic.api.repositorys.EnderecoRepository;
import com.ionic.api.repositorys.EstadoRepository;

@Service
public class DBService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	public void start() {
		
		Categoria cat1 = new Categoria(null, "Informática", null);
		Categoria cat2 = new Categoria(null, "Escritório", null);
		Categoria cat3 = new Categoria(null, "Cama, Mesa e Banho", null);
		Categoria cat4 = new Categoria(null, "Eletrônicos", null);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		
		Estado estado = new Estado(null, "Sergipe", "SE", 1L, null);
		
		estadoRepository.save(estado);
		
		Cidade cidade = new Cidade(null, "Lagarto", estado);
		
		cidadeRepository.save(cidade);
		
		Set<Integer> perfis = new HashSet<>();
		perfis.add(Perfil.CLIENTE.getCod());
		
		Set<String> telefones = new HashSet<>();
		telefones.add("79 99953-0291");

		Cliente c = new Cliente(null, "Adriano Melo", "adrianoshout@gmail.com", "015.001.945-90", TipoCliente.PF,
				pe.encode("123456"), null, telefones, perfis , null);

		Endereco end = new Endereco(null, "Rua Frei Damião", "852", "Casa", "Cidade Nova", "49200-000", c,
				cidade);
		
		List<Endereco> list = new ArrayList<>();
		list.add(end);
		
		clienteRepository.save(c);
		enderecoRepository.save(end);
		c.setEnderecos(list);
		clienteRepository.save(c);

	}

}
