package com.ionic.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ionic.api.enuns.Perfil;
import com.ionic.api.enuns.TipoCliente;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Length(min = 5, max = 80)
	private String nome;
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String cpfOuCnpj;
	private TipoCliente tipo;

	@JsonIgnore
	private String senha;

	
	@OneToMany
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "tb_telefone")
	private Set<String> telefones = new HashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tb_perfil")
	private Set<Integer> perfis = new HashSet<>();

	@OneToMany
	private List<Pedido> pedidos = new ArrayList<>();

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Long id, @NotEmpty @Length(min = 5, max = 80) String nome, @Email @NotEmpty String email,
			@NotEmpty String cpfOuCnpj, TipoCliente tipo, String senha, List<Endereco> enderecos, Set<String> telefones,
			Set<Integer> perfis, List<Pedido> pedidos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		this.senha = senha;
		this.enderecos = enderecos;
		this.telefones = telefones;
		this.perfis = perfis;
		this.pedidos = pedidos;
		addPerfil(Perfil.CLIENTE);
	}
	
	

}
