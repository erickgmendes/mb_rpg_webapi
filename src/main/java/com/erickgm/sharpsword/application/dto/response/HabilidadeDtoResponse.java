package com.erickgm.sharpsword.application.dto.response;

import java.util.List;

public class HabilidadeDtoResponse {

	private Long id;

	private String nome;

	private String tipoHabilidade;

	private List<String> racas;

	private Integer nivel;

	private String descricao;

	private String especial;

	private Integer dificuldade;

	private Integer mana;

	private String requisito;

	private String modificador;

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

	public String getTipoHabilidade() {
		return tipoHabilidade;
	}

	public void setTipoHabilidade(String tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}

	public List<String> getRacas() {
		return racas;
	}

	public void setRacas(List<String> racas) {
		this.racas = racas;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	public Integer getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Integer dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public String getModificador() {
		return modificador;
	}

	public void setModificador(String modificador) {
		this.modificador = modificador;
	}

}