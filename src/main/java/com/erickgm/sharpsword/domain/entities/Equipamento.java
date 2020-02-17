package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "equipamentos")
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	public Equipamento() {
		super();
	}

	public Equipamento(Long id, String nome, int custo, double peso, String descricao) {

		super();
		
		this.id = id;
		
		modificaValores(nome, custo, peso, descricao);
	}

	@Id
	@GeneratedValue(generator = "seq_equipamento", strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nome;

	private int custo;

	private double peso;

	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void modificaValores(String nome, int custo, double peso, String descricao) {
		this.nome = nome;
		this.custo = custo;
		this.peso = peso;
		this.descricao = descricao;
	}

}