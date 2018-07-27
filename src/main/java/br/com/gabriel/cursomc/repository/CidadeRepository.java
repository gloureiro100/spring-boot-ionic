package br.com.gabriel.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
