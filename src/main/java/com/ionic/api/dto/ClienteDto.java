package com.ionic.api.dto;

import java.util.HashSet;
import java.util.Set;

import com.ionic.api.enuns.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
	
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private TipoCliente tipo;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private Long cidadeId;
	
	@Builder.Default
	private Set<String> telefones = new HashSet<>();

}
