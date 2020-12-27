package br.com.apirest.dto;

import java.util.Date;

import br.com.apirest.model.Servico;
import br.com.apirest.model.Usuario;
import lombok.Getter;

@Getter
public class ServicoDTO {
	private Integer id;
	private String descricao;
	private String titulo;
	private Date datahora;
	private Boolean emergencia;
	private Boolean concluido;
	private Usuario usuario;

	public Servico convertToDTO() {
		return new Servico(id, descricao, titulo, datahora, emergencia, concluido, usuario);
	}
}
