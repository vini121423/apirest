package br.com.apirest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
	private BigDecimal media;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	@JsonIgnore
	@OneToMany(mappedBy = "mecanico")
	private List<Avaliados> avaliado = new ArrayList<>();
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome_mecanico() {
		return nome_mecanico;
	}

	public void setNome_mecanico(String nome_mecanico) {
		this.nome_mecanico = nome_mecanico;
	}

	public String getNome_oficina() {
		return nome_oficina;
	}

	public void setNome_oficina(String nome_oficina) {
		this.nome_oficina = nome_oficina;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getSoma_avaliacao() {
		return soma_avaliacao;
	}

	public void setSoma_avaliacao(Integer soma_avaliacao) {
		this.soma_avaliacao = soma_avaliacao;
	}

	public Integer getQtde_avaliacao() {
		return qtde_avaliacao;
	}

	public void setQtde_avaliacao(Integer qtde_avaliacao) {
		this.qtde_avaliacao = qtde_avaliacao;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Avaliados> getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(List<Avaliados> avaliado) {
		this.avaliado = avaliado;
	}

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