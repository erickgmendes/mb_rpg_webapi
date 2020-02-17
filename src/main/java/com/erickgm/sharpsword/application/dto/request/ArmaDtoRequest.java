package com.erickgm.sharpsword.application.dto.request;

public class ArmaDtoRequest {

	private String tipoArma;

	private String nome;

	private Double custo;

	private String dano;

	private String tipoDanoArma;

	private String fn;

	private Double peso;

	private String tipoDistanciaArma;

	private String observacoes;
	
	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public String getDano() {
		return dano;
	}

	public void setDano(String dano) {
		this.dano = dano;
	}

	public String getTipoDanoArma() {
		return tipoDanoArma;
	}

	public void setTipoDanoArma(String tipoDanoArma) {
		this.tipoDanoArma = tipoDanoArma;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getTipoDistanciaArma() {
		return tipoDistanciaArma;
	}

	public void setTipoDistanciaArma(String tipoDistanciaArma) {
		this.tipoDistanciaArma = tipoDistanciaArma;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}