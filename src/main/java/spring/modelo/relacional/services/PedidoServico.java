package spring.modelo.relacional.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.modelo.relacional.domain.Categoria;
import spring.modelo.relacional.domain.ItemPedido;
import spring.modelo.relacional.domain.PagamentoComBoleto;
import spring.modelo.relacional.domain.Pedido;
import spring.modelo.relacional.domain.enums.EstadoPagamento;
import spring.modelo.relacional.repositories.ItemPedidoRepository;
import spring.modelo.relacional.repositories.PagamentoRepository;
import spring.modelo.relacional.repositories.PedidoRepository;

@Service
public class PedidoServico {		//Chamada de serviço
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoServico produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteServico clienteService;
	
	@Autowired
	private EmailService emailService;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado id :) "+ id + " Tipo: "+ Categoria.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);			//dados do pedido
		obj.setInstante(new Date());
		
		obj.setCliente(clienteService.findById(obj.getCliente().getId()));	//procura no banco pelo id, se não é null por passa só id
		
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj); 		//pedido conhece pagamanto assim como pagamento conhece obj
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		obj = repo.save(obj);	//Salvou obj, falta o pagamento
		pagamentoRepository.save(obj.getPagamento());	//salvou pagamento
		
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			
			ip.setProduto(produtoService.findById(ip.getProduto().getId()));	//procura no banco pelo id, se não é null por passa só id
			
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		//emailService.sendOrderConfirmationHtmlEmail(obj);
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
}
