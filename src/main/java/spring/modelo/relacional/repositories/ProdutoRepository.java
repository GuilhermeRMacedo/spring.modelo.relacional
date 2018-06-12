package spring.modelo.relacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.modelo.relacional.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{		//Camada de acesso de dados
	
}
