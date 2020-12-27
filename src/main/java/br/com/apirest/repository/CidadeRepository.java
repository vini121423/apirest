package br.com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}
