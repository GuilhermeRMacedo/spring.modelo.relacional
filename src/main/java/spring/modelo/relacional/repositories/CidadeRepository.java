package spring.modelo.relacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.modelo.relacional.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{		//Camada de acesso de dados
	
}
