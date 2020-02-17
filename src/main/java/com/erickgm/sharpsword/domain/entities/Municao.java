package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "municoes")
public class Municao implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Municao() {
		super();
	}

	public Municao(Long id, String nome, Double custo, Double peso, String descricao) {
	
		super();
		
		this.id = id;
		
		modificaValores(nome, custo, peso,descricao);
	}

	@Id
	@GeneratedValue(generator = "seq_municao", strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nome;

	private Double custo;

	private Double peso;

	private String descricao;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getCusto() {
		return custo;
	}

	public Double getPeso() {
		return peso;
	}

	public String getDescricao() {
		return descricao;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setCusto(Double custo) {
		this.custo = custo;
	}

	protected void setPeso(Double peso) {
		this.peso = peso;
	}

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void modificaValores(String nome, Double custo, Double peso, String descricao) {
		this.nome = nome;
		this.custo = custo;
		this.peso = peso;
		this.descricao = descricao;
	}

}