package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classe implements Serializable {

	protected Classe() {
		super();
	}
	
	public Classe(Long id, String nome) {
		
		super();
		
		this.id = id;
		
		modificaValores(nome);
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_classe", strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	public void modificaValores(String nome) {
		this.nome = nome;		
	}

/*
	TODAS(0L, "Todas"), 
	BARDO(1L, "Bardo"), 
	DRUIDA(2L, "Druida"), 
	ESPADACHIM(3L, "Espadachim"), 
	FEITICEIRO(4L, "Feiticeiro"),
	GUERREIRO(5L, "Guerreiro"), 
	LADINO(6L, "Ladino"), 
	PALADINO(7L, "Paladino"), 
	PATRULHEIRO(8L, "Patrulheiro"),
	RUNICO(9L, "R�nico"), 
	SACERDOTE(10L, "Sacerdote"), 
	XAMA(11L, "Xam�");

*/

}