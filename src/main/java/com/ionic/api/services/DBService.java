package com.ionic.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ionic.api.entity.Cidade;
import com.ionic.api.entity.Cliente;
import com.ionic.api.entity.Endereco;
import com.ionic.api.entity.Estado;
import com.ionic.api.enuns.TipoCliente;
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
	private BCryptPasswordEncoder pe;

	public void start() {
		
		Estado estado = new Estado(null, "Sergipe", "SE", 1L, null);
		
		estadoRepository.save(estado);
		
		Cidade cidade = new Cidade(null, "Lagarto", estado);
		
		cidadeRepository.save(cidade);

		Cliente c = new Cliente(null, "Adriano Melo", "adrianoshout@gmail.com", "015.001.945-90", TipoCliente.PF,
				pe.encode("123456"), null, null, null);

		Endereco end = new Endereco(null, "Rua Frei Damião", "852", "Casa", "Cidade Nova", "49200-000", c,
				cidade);
		
		clienteRepository.save(c);
		enderecoRepository.save(end);

	}

}
