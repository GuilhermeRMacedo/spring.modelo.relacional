package spring.modelo.relacional.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.modelo.relacional.domain.Categoria;
import spring.modelo.relacional.services.CategoriaServico;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {		//Rest
	
	@Autowired
	private CategoriaServico service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarId(@PathVariable Integer id) {
		Categoria obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
