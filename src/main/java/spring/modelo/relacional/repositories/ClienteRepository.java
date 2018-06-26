package spring.modelo.relacional.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.modelo.relacional.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{		//Camada de acesso de dados
	
	
	Cliente findByEmail(String email);
	
}
