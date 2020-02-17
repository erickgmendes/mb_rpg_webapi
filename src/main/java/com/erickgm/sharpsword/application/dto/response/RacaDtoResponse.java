package com.erickgm.sharpsword.application.dto.response;

public class RacaDtoResponse {

	private Long id;

	private String nome;

	private Boolean usuarioEscolhe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getUsuarioEscolhe() {
		return usuarioEscolhe;
	}

	public void setUsuarioEscolhe(Boolean usuarioEscolhe) {
		this.usuarioEscolhe = usuarioEscolhe;
	}

}
