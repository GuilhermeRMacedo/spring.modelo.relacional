package spring.modelo.relacional.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.modelo.relacional.domain.Cliente;
import spring.modelo.relacional.services.ClienteServico;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {		//Rest
	
	@Autowired
	private ClienteServico service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> buscarId(@PathVariable Integer id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//PUT, ATUALIZAR
	//DELETE, DELETAR
	//GET, TODOS CLIENTES
	//GET, TODOS OS CLIENTES COM PAGINAÇÃO
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Cliente> update(@PathVariable Integer id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Void> findAll(@PathVariable Integer id){
		
		return null;
	}
	
	@RequestMapping(value="/page", method=RequestMethod.DELETE)
	public ResponseEntity<Void> findPage(@PathVariable Integer id){
		
		return null;
	}
	
	
}
