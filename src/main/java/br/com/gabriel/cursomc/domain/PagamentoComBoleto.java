package br.com.gabriel.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import br.com.gabriel.cursomc.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable{

	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		super();
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date dataPagamento ) {
		super(id, estado, pedido);
		this.dataPagamento = dataVencimento;
		this.dataVencimento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
}
