package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "racas")
public class Raca implements Serializable {

	protected Raca() {
		super();
	}

	public Raca(Long id, String nome, int valorForca, int valorAgilidade, int valorInteligencia, int valorVontade) {
		this.id = id;
		this.nome = nome;
		this.valorForca = valorForca;
		this.valorAgilidade = valorAgilidade;
		this.valorInteligencia = valorInteligencia;
		this.valorVontade = valorVontade;
	}

	@Id
	@GeneratedValue(generator = "seq_raca", strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;

	@Column(nullable = false)
	private int valorForca;

	@Column(nullable = false)
	private int valorAgilidade;

	@Column(nullable = false)
	private int valorInteligencia;

	@Column(nullable = false)
	private int valorVontade;

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

	public int getValorForca() {
		return valorForca;
	}

	protected void setValorForca(int valorForca) {
		this.valorForca = valorForca;
	}

	public int getValorAgilidade() {
		return valorAgilidade;
	}

	protected void setValorAgilidade(int valorAgilidade) {
		this.valorAgilidade = valorAgilidade;
	}

	public int getValorInteligencia() {
		return valorInteligencia;
	}

	protected void setValorInteligencia(int valorInteligencia) {
		this.valorInteligencia = valorInteligencia;
	}

	public int getValorVontade() {
		return valorVontade;
	}

	protected void setValorVontade(int valorVontade) {
		this.valorVontade = valorVontade;
	}
}