package com.erickgm.sharpsword.application.dto.request;

public class RacaDtoRequest {

	private String nome;

	private Boolean usuarioEscolhe;

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