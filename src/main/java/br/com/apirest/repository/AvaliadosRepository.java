package br.com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.model.Avaliados;

@Repository
public interface AvaliadosRepository extends JpaRepository<Avaliados,Integer> {

}
