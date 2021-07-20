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
		
		Estado se = new Estado(null, "Sergipe", "SE", 1L, null);
		Estado ba = new Estado(null, "Sergipe", "SE", 1L, null);
		
		estadoRepository.saveAll(Arrays.asList(se, ba));
		
		Cidade a = new Cidade(null, "Lagarto", se);
		Cidade b = new Cidade(null, "Estância", se);
		Cidade c = new Cidade(null, "Salvador", ba);
		Cidade d = new Cidade(null, "Feira de Santana", ba);
		
		cidadeRepository.saveAll(Arrays.asList(a, b, c, d));
		
		
		
		Set<Integer> perfisCli = new HashSet<>();
		perfisCli.add(Perfil.CLIENTE.getCod());
		
		Set<Integer> perfisAdm = new HashSet<>();
		perfisAdm.add(Perfil.ADMIN.getCod());
		
		Set<Integer> perfisAmbos = new HashSet<>();
		perfisAmbos.add(Perfil.ADMIN.getCod());
		perfisAmbos.add(Perfil.CLIENTE.getCod());
		
		Set<String> telefones = new HashSet<>();
		telefones.add("79 99953-0291");

		Cliente cli1 = new Cliente(null, "Adriano Melo", "adrianoshout@gmail.com", "015.001.945-90", TipoCliente.PF,
				pe.encode("123456"), null, telefones, perfisCli , null);

		Endereco end1 = new Endereco(null, "Rua Frei Damião", "852", "Casa", "Cidade Nova", "49200-000", cli1,
				a);
		
		List<Endereco> list = new ArrayList<>();
		list.add(end1);
		
		clienteRepository.save(cli1);
		enderecoRepository.save(end1);
		cli1.setEnderecos(list);
		clienteRepository.save(cli1);
		
		
		Set<String> telefones1 = new HashSet<>();
		telefones.add("79 99953-0291");
		
		
		Cliente cli2 = new Cliente(null, "Priscila Paixão", "priscanew@gmail.com", "054.791.565-94", TipoCliente.PF,
				pe.encode("123456"), null, telefones1, perfisAmbos , null);

		Endereco end2 = new Endereco(null, "Rua Frei Damião", "852", "Casa", "Cidade Nova", "49200-000", cli1,
				a);
		
		List<Endereco> list1 = new ArrayList<>();
		list.add(end2);
		
		clienteRepository.save(cli2);
		enderecoRepository.save(end2);
		cli2.setEnderecos(list1);
		clienteRepository.save(cli2);

	}

}
