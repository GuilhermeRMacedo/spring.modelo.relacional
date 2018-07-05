package spring.modelo.relacional.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import spring.modelo.relacional.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		
		pagto.setDataVencimento(cal.getTime());
		
		
		//Em uma situação real trocar essa implementação por uma chamada de webservice que gera o boleto e pega o vencimento dele
	}
}
