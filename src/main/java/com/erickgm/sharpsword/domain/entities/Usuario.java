package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	protected Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String login, String senha) {
		super();

		this.id = id;

		modificaValores(nome, login, senha);
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_usuario", strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nome;

	private String login;

	@Column(length = 512)
	private String senha;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void modificaValores(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

}