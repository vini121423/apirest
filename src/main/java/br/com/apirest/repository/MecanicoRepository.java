package br.com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.model.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Integer> {
  
}
