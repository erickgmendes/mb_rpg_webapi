package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.erickgm.sharpsword.domain.enums.TipoHabilidade;

@Entity
@Table(name = "habilidades")
public class Habilidade implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Habilidade() {
		super();
	}

	public Habilidade(Long id, String nome, TipoHabilidade tipoHabilidade, List<Raca> racas, List<Classe> classes, Integer nivel, String descricao, String especial, Integer dificuldade, Integer mana, String requisito, String modificador) {
		this.id = id;
		this.nome = nome;
		this.tipoHabilidade = tipoHabilidade;
		this.racas = racas;
		this.classes = classes;
		this.nivel = nivel;
		this.descricao = descricao;
		this.especial = especial;
		this.dificuldade = dificuldade;
		this.mana = mana;
		this.requisito = requisito;
		this.modificador = modificador;
	}

	@Id
	@GeneratedValue(generator = "seq_habilidade", strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;

	private TipoHabilidade tipoHabilidade;

	@ManyToMany
	private List<Raca> racas;

	@ManyToMany
	private List<Classe> classes;

	private Integer nivel;

	@Column(length = 2000)
	private String descricao;
	
	private String especial;

	private Integer dificuldade;

	private Integer mana;

	private String requisito;

	private String modificador;

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

	public Integer getDificuldade() {
		return dificuldade;
	}

	protected void setDificuldade(Integer dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Integer getMana() {
		return mana;
	}

	protected void setMana(Integer mana) {
		this.mana = mana;
	}

	public List<Raca> getRacas() {
		return racas;
	}

	protected void setRacas(List<Raca> racas) {
		this.racas = racas;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	protected void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public TipoHabilidade getTipoHabilidade() {
		return tipoHabilidade;
	}

	protected void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}

	public Integer getNivel() {
		return nivel;
	}

	protected void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEspecial() {
		return especial;
	}

	protected void setEspecial(String especial) {
		this.especial = especial;
	}

	public String getRequisito() {
		return requisito;
	}

	protected void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public String getModificador() {
		return modificador;
	}

	protected void setModificador(String modificador) {
		this.modificador = modificador;
	}
}