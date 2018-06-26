package spring.modelo.relacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.modelo.relacional.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> { // Camada de acesso de dados

	@Transactional(readOnly=true) 
	Cliente findByEmail(String email);

}
