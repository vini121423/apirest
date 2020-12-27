package br.com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Integer>{

}
