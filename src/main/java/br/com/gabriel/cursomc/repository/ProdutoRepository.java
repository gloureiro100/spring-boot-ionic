package br.com.gabriel.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
