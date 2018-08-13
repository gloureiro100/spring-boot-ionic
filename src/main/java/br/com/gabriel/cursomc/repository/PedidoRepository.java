package br.com.gabriel.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
