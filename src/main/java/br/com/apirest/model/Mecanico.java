package br.com.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mecanico")
public class Mecanico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "ativo")
	private Boolean ativo;

	@Column(name = "nome_mecanico")
	private String nome_mecanico;

	@Column(name = "nome_oficina")
	private String nome_oficina;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "soma_avaliacao")
	private Integer soma_avaliacao;

	@Column(name = "qtde_avaliacao")
	private Integer qtde_avaliacao;

	@Column(name = "media")
	private Long media;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mecanico other = (Mecanico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}