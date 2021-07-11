package com.ionic.api.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Long qtdParcelas;
	
	
	public PagamentoComCartao(Long id, StatusPagamento status, Pedido pedido, Long qtdParcelas) {
		super(id, status, pedido);
		this.qtdParcelas = qtdParcelas;
		
	}
	
	

}
