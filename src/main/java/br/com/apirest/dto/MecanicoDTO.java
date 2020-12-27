package br.com.apirest.dto;

import java.math.BigDecimal;

import br.com.apirest.model.Cidade;
import br.com.apirest.model.Mecanico;
import lombok.Getter;

@Getter
public class MecanicoDTO {
	private Integer id;
	private String email;
	private String senha;
	private Boolean ativo;
	private String nome_mecanico;
	private String nome_oficina;
	private String endereco;
	private Integer soma_avaliacao;
	private Integer qtde_avaliacao;
	private BigDecimal media;
	private Cidade cidade;

	public Mecanico convertToDTO() {
		return new Mecanico(id, email, senha, ativo, nome_mecanico, nome_oficina, endereco, soma_avaliacao,
				qtde_avaliacao, media, cidade);
	}

}