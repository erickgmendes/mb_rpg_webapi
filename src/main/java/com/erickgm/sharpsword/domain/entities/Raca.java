package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Raca implements Serializable {

	protected Raca() {
		super();
	}

	public Raca(Long id, String nome, Boolean usuarioEscolhe) {
		
		super();
		
		this.id = id;
		
		modificaValores(nome, usuarioEscolhe);
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_raca", strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;

	private Boolean usuarioEscolhe;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getUsuarioEscolhe() {
		return usuarioEscolhe;
	}

	protected void setUsuarioEscolhe(Boolean usuarioEscolhe) {
		this.usuarioEscolhe = usuarioEscolhe;
	}

	public void modificaValores(String nome, Boolean usuarioEscolhe) {
		this.nome = nome;
		this.usuarioEscolhe = usuarioEscolhe;
	}

}