package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.erickgm.sharpsword.domain.enums.TipoArma;
import com.erickgm.sharpsword.domain.enums.TipoDanoArma;
import com.erickgm.sharpsword.domain.enums.TipoDistanciaArma;

@Entity
@Table(name = "armas")
public class Arma implements Serializable {

	protected Arma() {
		super();
	}

	public Arma(Long id, TipoArma tipoArma, String nome, Double custo, String dano, TipoDanoArma tipoDanoArma,
			String fn, Double peso, TipoDistanciaArma tipoDistanciaArma, String observacoes) {
		
		super();
		
		this.id = id;
		
		modificaValores(tipoArma, nome, custo, dano, tipoDanoArma, fn, peso, tipoDistanciaArma, observacoes);		
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_arma", strategy = GenerationType.AUTO)
	private Long id;

	private TipoArma tipoArma;

	@Column(unique = true)
	private String nome;

	private Double custo;

	private String dano;

	private TipoDanoArma tipoDanoArma;

	private String fn;

	private Double peso;

	private TipoDistanciaArma tipoDistanciaArma;

	@Column(length = 1000)
	private String observacoes;

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setCusto(Double custo) {
		this.custo = custo;
	}

	protected void setDano(String dano) {
		this.dano = dano;
	}

	protected void setTipoDanoArma(TipoDanoArma tipoDanoArma) {
		this.tipoDanoArma = tipoDanoArma;
	}

	protected void setFn(String fn) {
		this.fn = fn;
	}

	protected void setPeso(Double peso) {
		this.peso = peso;
	}

	protected void setTipoDistanciaArma(TipoDistanciaArma tipoDistanciaArma) {
		this.tipoDistanciaArma = tipoDistanciaArma;
	}

	protected void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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

	public String getDano() {
		return dano;
	}

	public TipoDanoArma getTipoDanoArma() {
		return tipoDanoArma;
	}

	public String getFn() {
		return fn;
	}

	public Double getPeso() {
		return peso;
	}

	public TipoDistanciaArma getTipoDistanciaArma() {
		return tipoDistanciaArma;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public TipoArma getTipoArma() {
		return tipoArma;
	}

	protected void setTipoArma(TipoArma tipoArma) {
		this.tipoArma = tipoArma;
	}

	public void modificaValores(TipoArma tipoArma, String nome, Double custo, String dano,
			TipoDanoArma tipoDanoArma, String fn, Double peso, TipoDistanciaArma tipoDistanciaArma,
			String observacoes) {
		this.tipoArma = tipoArma;
		this.nome = nome;
		this.custo = custo;
		this.dano = dano;
		this.tipoDanoArma = tipoDanoArma;
		this.fn = fn;
		this.peso = peso;
		this.tipoDistanciaArma = tipoDistanciaArma;
		this.observacoes = observacoes;		
	}

}
