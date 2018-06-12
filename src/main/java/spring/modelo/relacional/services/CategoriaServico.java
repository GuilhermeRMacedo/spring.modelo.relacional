package spring.modelo.relacional.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.modelo.relacional.domain.Categoria;
import spring.modelo.relacional.repositories.CategoriaRepository;

@Service
public class CategoriaServico {		//Chamada de serviço
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscarId(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public void adicionar() {
		
	}
}
