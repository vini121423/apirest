package br.com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>  {

}
