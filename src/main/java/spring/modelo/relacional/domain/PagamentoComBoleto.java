package spring.modelo.relacional.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import spring.modelo.relacional.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataPagamento;

	public PagamentoComBoleto() {}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento tipoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, tipoPagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
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