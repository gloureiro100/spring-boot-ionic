package br.com.gabriel.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
