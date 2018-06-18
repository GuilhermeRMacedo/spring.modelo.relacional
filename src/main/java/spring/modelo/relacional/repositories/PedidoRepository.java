package spring.modelo.relacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.modelo.relacional.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{		//Camada de acesso de dados
	
}
