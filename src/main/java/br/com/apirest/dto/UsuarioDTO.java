package br.com.apirest.dto;

import br.com.apirest.model.Cidade;
import br.com.apirest.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioDTO {
   private Integer id;
   private String nome;
   private String sexo;
   private String email;
   private String senha;
   private Boolean ativo;
   private Cidade cidade;
   
   public Usuario convertToDTO() {
	   return new Usuario(id,nome,sexo,email,senha,ativo,cidade);
   }
}
