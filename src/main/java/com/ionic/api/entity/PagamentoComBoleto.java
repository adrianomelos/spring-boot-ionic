package com.ionic.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.ionic.api.enuns.StatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	
	public PagamentoComBoleto(Long id, StatusPagamento status, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
		super(id, status, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		
	}
}
