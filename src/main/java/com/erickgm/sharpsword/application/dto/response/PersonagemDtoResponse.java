package com.erickgm.sharpsword.application.dto.response;

import java.util.List;

public class PersonagemDtoResponse {

	private String nome;
	private String usuario;
	private String raca;
	private String classe;
	private long nivel;
	private String motivacao;
	private int xp;
	private int pontosVida;
	private int pontosMana;
	private int forca;
	private int agilidade;
	private int inteligencia;
	private int vontade;
	private int cargaBasica;
	private int cargaPesada;
	private int cargaMaxima;
	private int deslocamento;
	private int corrida;
	private int bloqueio;
	private int esquiva;
	private int determinacao;
	private int bonusDeterminacao;
	private int bonusArmadura;
	private int bonusBloqueio;
	private int bonusEsquiva;
	private int dinheiro;
	private List<HabilidadeDtoResponse> habilidades;
	private List<ArmaDtoResponse> armas;
	private List<ArmaduraDtoResponse> armaduras;
	private List<EquipamentoDtoResponse> equipamentos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public long getNivel() {
		return nivel;
	}

	public void setNivel(long nivel) {
		this.nivel = nivel;
	}

	public String getMotivacao() {
		return motivacao;
	}

	public void setMotivacao(String motivacao) {
		this.motivacao = motivacao;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getPontosVida() {
		return pontosVida;
	}

	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}

	public int getPontosMana() {
		return pontosMana;
	}

	public void setPontosMana(int pontosMana) {
		this.pontosMana = pontosMana;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getVontade() {
		return vontade;
	}

	public void setVontade(int vontade) {
		this.vontade = vontade;
	}

	public int getCargaBasica() {
		return cargaBasica;
	}

	public void setCargaBasica(int cargaBasica) {
		this.cargaBasica = cargaBasica;
	}

	public int getCargaPesada() {
		return cargaPesada;
	}

	public void setCargaPesada(int cargaPesada) {
		this.cargaPesada = cargaPesada;
	}

	public int getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(int cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	public int getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}

	public int getCorrida() {
		return corrida;
	}

	public void setCorrida(int corrida) {
		this.corrida = corrida;
	}

	public int getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(int bloqueio) {
		this.bloqueio = bloqueio;
	}

	public int getEsquiva() {
		return esquiva;
	}

	public void setEsquiva(int esquiva) {
		this.esquiva = esquiva;
	}

	public int getDeterminacao() {
		return determinacao;
	}

	public void setDeterminacao(int determinacao) {
		this.determinacao = determinacao;
	}

	public int getBonusDeterminacao() {
		return bonusDeterminacao;
	}

	public void setBonusDeterminacao(int bonusDeterminacao) {
		this.bonusDeterminacao = bonusDeterminacao;
	}

	public int getBonusArmadura() {
		return bonusArmadura;
	}

	public void setBonusArmadura(int bonusArmadura) {
		this.bonusArmadura = bonusArmadura;
	}

	public int getBonusBloqueio() {
		return bonusBloqueio;
	}

	public void setBonusBloqueio(int bonusBloqueio) {
		this.bonusBloqueio = bonusBloqueio;
	}

	public int getBonusEsquiva() {
		return bonusEsquiva;
	}

	public void setBonusEsquiva(int bonusEsquiva) {
		this.bonusEsquiva = bonusEsquiva;
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	public List<HabilidadeDtoResponse> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<HabilidadeDtoResponse> habilidades) {
		this.habilidades = habilidades;
	}

	public List<ArmaDtoResponse> getArmas() {
		return armas;
	}

	public void setArmas(List<ArmaDtoResponse> armas) {
		this.armas = armas;
	}

	public List<ArmaduraDtoResponse> getArmaduras() {
		return armaduras;
	}

	public void setArmaduras(List<ArmaduraDtoResponse> armaduras) {
		this.armaduras = armaduras;
	}

	public List<EquipamentoDtoResponse> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<EquipamentoDtoResponse> equipamentos) {
		this.equipamentos = equipamentos;
	}

}