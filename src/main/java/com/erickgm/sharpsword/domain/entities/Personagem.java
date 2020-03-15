package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "personagens")
public class Personagem implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Personagem() {
		super();
	}

	public Personagem(Long id, String nome, Usuario usuario, Raca raca, Classe classe, int nivel,
					  String motivacao, List<Habilidade> habilidades, List<Arma> armas, List<Armadura> armaduras,
					  List<Equipamento> equipamentos, List<Municao> municoes) {
		
		super();
		
		this.id = id;
		
		modificaValores(nome, usuario, raca, classe, nivel, motivacao, habilidades, armas, armaduras, equipamentos,
				municoes);

		
		this.calcularInformacoesIniciais();
	}

	@Id
	@GeneratedValue(generator = "seq_personagem", strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToOne
	private Raca raca;
	
	@OneToOne
	private Classe classe;
	
	private int nivel;
	
	private String motivacao;

	private int xp;
	
	private int pontosVida;
	
	private int pontosMana;
	
	private int forca;
	
	private int agilidade;
	
	private int inteligencia;
	
	private int vontade;

	// Carga
	private int cargaBasica;
	
	private int cargaPesada;
	
	private int cargaMaxima;

	private int deslocamento;
	
	private int corrida;

	// Defesa
	private int bloqueio;
	
	private int esquiva;
	
	private int determinacao;

	//Bônus
	private int bonusDeterminacao;
	
	private int bonusArmadura;
	
	private int bonusBloqueio;
	
	private int bonusEsquiva;

	private int dinheiro;

	@OneToMany
	private List<Habilidade> habilidades;
	
	@OneToMany
	private List<Arma> armas;
	
	@OneToMany
	private List<Armadura> armaduras;
	
	@OneToMany
	private List<Equipamento> equipamentos;
	
	@OneToMany
	private List<Municao> municoes;

	private void calcularInformacoesIniciais() {
		forca = 0;
		agilidade = 0;
		inteligencia = 0;
		vontade = 0;

		calcularRaca();
		calcularClasse();
		calcularCargas();
		calcularDeterminacao();
		calcularEsquiva();
		calcularDeslocamento();
		calcularBloqueio();
		calcularDinheiro();
		calcularNivel();
	}

	private void calcularClasse() {
		if (classe == null) {
			return;
		}
		
		String nomeClasse = classe.getNome(); 

		if ("Bardo".equals(nomeClasse)) {
			agilidade++;
			vontade++;
		} else if ("Druida".equals(nomeClasse) || "Feiticeiro".equals(nomeClasse) || "Sacerdote".equals(nomeClasse)) {
			inteligencia++;
			vontade++;
		} else if ("Espadachim".equals(nomeClasse) || "Guerreiro".equals(nomeClasse)) {
			forca++;
			agilidade++;
		} else if ("Ladino".equals(nomeClasse) || "Patrulheiro".equals(nomeClasse)) {
			agilidade++;
			inteligencia++;
		} else if ("Paladino".equals(nomeClasse) || "Xamã".equals(nomeClasse)) {
			forca++;
			vontade++;
		} else if ("Runico".equals(nomeClasse)) {
			forca++;
			inteligencia++;
		}
	}

	private void calcularRaca() {
		if (raca == null) {
			return;
		}

		String nomeRaca = raca.getNome();
		
		if ("Aesir".equals(nomeRaca) || "Anão".equals(nomeRaca)) {
			forca = 4;
			agilidade = 2;
			inteligencia = 3;
			vontade = 3;
		} else if ("Elfo".equals(nomeRaca) || "Tailox".equals(nomeRaca)) {
			forca = 2;
			agilidade = 4;
			inteligencia = 3;
			vontade = 3;
		} else if ("Faen".equals(nomeRaca)) {
			forca = 2;
			agilidade = 4;
			inteligencia = 3;
			vontade = 2;
		} else if ("Fauno".equals(nomeRaca) || "Fira".equals(nomeRaca) || "Humano".equals(nomeRaca)) {
			forca = 3;
			agilidade = 3;
			inteligencia = 3;
			vontade = 3;
		} else if ("Juban".equals(nomeRaca)) {
			forca = 4;
			agilidade = 2;
			inteligencia = 3;
			vontade = 4;
		} else if ("Levent".equals(nomeRaca)) {
			forca = 2;
			agilidade = 3;
			inteligencia = 3;
			vontade = 3;
		} else if ("Mahok".equals(nomeRaca)) {
			forca = 5;
			agilidade = 2;
			inteligencia = 2;
			vontade = 3;
		}
	}

	private void calcularCargas() {
		int forcaCarga = calcularHabilidadeAutomaticaAnoes();
		cargaBasica = forcaCarga * 7;
		cargaPesada = cargaBasica * 5;
		cargaMaxima = cargaBasica * 10;
	}

	private int calcularHabilidadeAutomaticaAnoes() {
		// Habilidade automática para anões: "Coração da Montanha"
		// +2 na força na hora de calcular carga
		return "Anão".equals(raca.getNome()) ? forca + 2 : forca;
	}

	private void calcularBloqueio() {
		bloqueio = 5 + forca + bonusArmadura + bonusBloqueio;
	}

	private void calcularEsquiva() {
		esquiva = 5 + agilidade + bonusArmadura + bonusEsquiva;
	}

	private void calcularDeslocamento() {
		int fatorDeslocamento = calcularHabilidadeAutomaticaFaunos();
		deslocamento = 5 + Math.floorDiv(agilidade, 2) + fatorDeslocamento;
		corrida = deslocamento * 4;
	}

	private int calcularHabilidadeAutomaticaFaunos() {
		// Habilidade automática para faunos: "Patas com Cascos"
		// +1 no deslocamento
		return "Fauno".equals(raca.getNome()) ? 1 : 0;
	}

	private void calcularDeterminacao() {
		int modificadorDeterminacao = Math.max(vontade, inteligencia);
		determinacao = 8 + modificadorDeterminacao + bonusDeterminacao;
	}
	
	public void calcularDinheiro() {
		dinheiro = 400;
	}
	
	public void calcularNivel() {
		switch (nivel) {
		case 1: 
			pontosMana = 60;
			pontosVida = 60;
			
			break;

		default:
			break;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Raca getRaca() {
		return raca;
	}

	public Classe getClasse() {
		return classe;
	}

	public int getXp() {
		return xp;
	}

	public int getNivel() {
		return nivel;
	}

	public String getMotivacao() {
		return motivacao;
	}

	public int getPontosVida() {
		return pontosVida;
	}

	public int getPontosMana() {
		return pontosMana;
	}

	public int getForca() {
		return forca;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getVontade() {
		return vontade;
	}

	public int getCargaBasica() {
		return cargaBasica;
	}

	public int getCargaPesada() {
		return cargaPesada;
	}

	public int getCargaMaxima() {
		return cargaMaxima;
	}

	public int getDeslocamento() {
		return deslocamento;
	}

	public int getCorrida() {
		return corrida;
	}

	public int getBloqueio() {
		return bloqueio;
	}

	public int getEsquiva() {
		return esquiva;
	}

	public int getDeterminacao() {
		return determinacao;
	}

	public int getBonusDeterminacao() {
		return bonusDeterminacao;
	}

	public int getBonusArmadura() {
		return bonusArmadura;
	}

	public int getBonusBloqueio() {
		return bonusBloqueio;
	}

	public int getBonusEsquiva() {
		return bonusEsquiva;
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public List<Arma> getArmas() {
		return armas;
	}

	public List<Armadura> getArmaduras() {
		return armaduras;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	protected void setRaca(Raca raca) {
		this.raca = raca;
	}

	protected void setClasse(Classe classe) {
		this.classe = classe;
	}

	protected void setXp(int xp) {
		this.xp = xp;
	}

	protected void setNivel(int nivel) {
		this.nivel = nivel;
	}

	protected void setMotivacao(String motivacao) {
		this.motivacao = motivacao;
	}

	protected void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}

	protected void setPontosMana(int pontosMana) {
		this.pontosMana = pontosMana;
	}

	protected void setForca(int forca) {
		this.forca = forca;
	}

	protected void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	protected void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	protected void setVontade(int vontade) {
		this.vontade = vontade;
	}

	protected void setCargaBasica(int cargaBasica) {
		this.cargaBasica = cargaBasica;
	}

	protected void setCargaPesada(int cargaPesada) {
		this.cargaPesada = cargaPesada;
	}

	protected void setCargaMaxima(int cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	protected void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}

	protected void setCorrida(int corrida) {
		this.corrida = corrida;
	}

	protected void setBloqueio(int bloqueio) {
		this.bloqueio = bloqueio;
	}

	protected void setEsquiva(int esquiva) {
		this.esquiva = esquiva;
	}

	protected void setDeterminacao(int determinacao) {
		this.determinacao = determinacao;
	}

	protected void setBonusDeterminacao(int bonusDeterminacao) {
		this.bonusDeterminacao = bonusDeterminacao;
	}

	protected void setBonusArmadura(int bonusArmadura) {
		this.bonusArmadura = bonusArmadura;
	}

	protected void setBonusBloqueio(int bonusBloqueio) {
		this.bonusBloqueio = bonusBloqueio;
	}

	protected void setBonusEsquiva(int bonusEsquiva) {
		this.bonusEsquiva = bonusEsquiva;
	}

	protected void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	protected void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	protected void setArmas(List<Arma> armas) {
		this.armas = armas;
	}

	protected void setArmaduras(List<Armadura> armaduras) {
		this.armaduras = armaduras;
	}

	protected void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public List<Municao> getMunicoes() {
		return municoes;
	}

	protected void setMunicoes(List<Municao> municoes) {
		this.municoes = municoes;
	}	

	public void modificaValores(String nome, Usuario usuario, Raca raca, Classe classe, int nivel, String motivacao,
								List<Habilidade> habilidades, List<Arma> armas, List<Armadura> armaduras, List<Equipamento> equipamentos,
								List<Municao> municoes) {
		this.nome = nome;
		this.usuario = usuario;
		this.raca = raca;
		this.classe = classe;
		this.nivel = nivel;
		this.motivacao = motivacao;
		this.habilidades = habilidades;
		this.armas = armas;
		this.armaduras = armaduras;
		this.equipamentos = equipamentos;
		this.municoes = municoes;
	}

}