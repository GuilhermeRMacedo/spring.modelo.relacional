package spring.modelo.relacional.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.modelo.relacional.domain.Pedido;
import spring.modelo.relacional.services.PedidoServico;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {		//Rest
	
	@Autowired
	private PedidoServico service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> buscarId(@PathVariable Integer id) {
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
