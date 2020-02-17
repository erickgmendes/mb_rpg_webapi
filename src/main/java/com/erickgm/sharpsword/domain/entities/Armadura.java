package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Armadura implements Serializable {

	protected Armadura() {
		super();
	}

	public Armadura(Long id, String nome, int custo, String defesa, int fn, double peso, String observacoes) {

		super();
		
		this.id = id;
		
		modificaValores(nome, custo, defesa, fn, peso, observacoes);
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_armadura", strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nome;

	private int custo;

	private String defesa;

	private int fn;

	private double peso;

	@Column(length = 1000)
	private String observacoes;

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	public int getCusto() {
		return custo;
	}

	protected void setCusto(int custo) {
		this.custo = custo;
	}

	public double getPeso() {
		return peso;
	}

	protected void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDefesa() {
		return defesa;
	}

	protected void setDefesa(String defesa) {
		this.defesa = defesa;
	}

	public int getFn() {
		return fn;
	}

	protected void setFn(int fn) {
		this.fn = fn;
	}

	public String getObservacoes() {
		return observacoes;
	}

	protected void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void modificaValores(String nome, int custo, String defesa, int fn, double peso, String observacoes) {
		this.nome = nome;
		this.custo = custo;
		this.defesa = defesa;
		this.fn = fn;
		this.peso = peso;
		this.observacoes = observacoes;
	}

}