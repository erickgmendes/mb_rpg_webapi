package com.erickgm.sharpsword.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "racas")
public class Raca implements Serializable {

	@Id
	@GeneratedValue(generator = "seq_raca", strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean comum;

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

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "raca")
	private List<HabilidadeRaca> habilidadesRacas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isComum() {
		return comum;
	}

	public void setComum(boolean comum) {
		this.comum = comum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValorForca() {
		return valorForca;
	}

	public void setValorForca(int valorForca) {
		this.valorForca = valorForca;
	}

	public int getValorAgilidade() {
		return valorAgilidade;
	}

	public void setValorAgilidade(int valorAgilidade) {
		this.valorAgilidade = valorAgilidade;
	}

	public int getValorInteligencia() {
		return valorInteligencia;
	}

	public void setValorInteligencia(int valorInteligencia) {
		this.valorInteligencia = valorInteligencia;
	}

	public int getValorVontade() {
		return valorVontade;
	}

	public void setValorVontade(int valorVontade) {
		this.valorVontade = valorVontade;
	}

	public List<HabilidadeRaca> getHabilidadesRacas() {
		return habilidadesRacas;
	}

	public void setHabilidadesRacas(List<HabilidadeRaca> habilidadesRacas) {
		this.habilidadesRacas = habilidadesRacas;
	}

}