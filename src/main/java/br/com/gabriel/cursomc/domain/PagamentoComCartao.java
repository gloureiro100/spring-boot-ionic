package br.com.gabriel.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.gabriel.cursomc.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento implements Serializable{

	private Integer numeroDeParcelas;
	
	public PagamentoComCartao(){		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
	
}
