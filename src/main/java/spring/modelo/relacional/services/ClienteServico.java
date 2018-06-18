package spring.modelo.relacional.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.modelo.relacional.domain.Categoria;
import spring.modelo.relacional.domain.Cliente;
import spring.modelo.relacional.repositories.ClienteRepository;

@Service
public class ClienteServico {		//Chamada de serviço
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado id :) "+ id + " Tipo: "+ Cliente.class.getName()));
	}
	
	public void adicionar() {
		
	}
}