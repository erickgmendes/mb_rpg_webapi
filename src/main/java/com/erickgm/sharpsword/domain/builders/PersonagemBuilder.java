package com.erickgm.sharpsword.domain.builders;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Arma;
import com.erickgm.sharpsword.domain.entities.Armadura;
import com.erickgm.sharpsword.domain.entities.Equipamento;
import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.Municao;
import com.erickgm.sharpsword.domain.entities.Personagem;
import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.domain.entities.Classe;
import com.erickgm.sharpsword.domain.entities.Usuario;

public class PersonagemBuilder {

	private Long id;
	private String nome;
	private Usuario usuario;
	private Raca tipoRaca;
	private Classe tipoClasse;
	private int nivel;
	private String motivacao;
	private List<Habilidade> habilidades;
	private List<Arma> armas;
	private List<Armadura> armaduras;
	private List<Equipamento> equipamentos;
	private List<Municao> municoes;

	public PersonagemBuilder() {
		id = null;
		nome = null;
		usuario = null;
		tipoRaca = null;
		tipoClasse = null;
		nivel = 0;
		motivacao = null;
		habilidades = null;
		armas = null;
		armaduras = null;
		equipamentos = null;
		municoes = null;
	}

	public PersonagemBuilder comId(Long id) {
		this.id = id;
		return this;
	}

	public PersonagemBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public PersonagemBuilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	public PersonagemBuilder comTipoRaca(Raca tipoRaca) {
		this.tipoRaca = tipoRaca;
		return this;
	}

	public PersonagemBuilder comTipoClasse(Classe tipoClasse) {
		this.tipoClasse = tipoClasse;
		return this;
	}

	public PersonagemBuilder comNivel(int nivel) {
		this.nivel = nivel;
		return this;
	}

	public PersonagemBuilder comMotivacao(String motivacao) {
		this.motivacao = motivacao;
		return this;
	}

	public PersonagemBuilder comHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
		return this;
	}

	public PersonagemBuilder comArmas(List<Arma> armas) {
		this.armas = armas;
		return this;
	}

	public PersonagemBuilder comArmaduras(List<Armadura> armaduras) {
		this.armaduras = armaduras;
		return this;
	}

	public PersonagemBuilder comEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
		return this;
	}

	public PersonagemBuilder comMunicoes(List<Municao> municoes) {
		this.municoes = municoes;
		return this;
	}

	public Personagem build() {
		return new Personagem(id, nome, usuario, tipoRaca, tipoClasse, nivel, motivacao, habilidades, armas, armaduras,
				equipamentos, municoes);
	}

}
