package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.erickgm.sharpsword.domain.enums.TipoHabilidade;

@Entity
@Table(name = "habilidades")
public class Habilidade implements Serializable {

    protected Habilidade() {
        super();
    }

    public Habilidade(Long id, String nome, TipoHabilidade tipoHabilidade, List<Raca> racas, List<Classe> classes,
                      Integer nivel, String descricao, String especial, String dificuldade, String mana,
                      String requisito, Integer modificadorForca, Integer modificadorAgilidade,
                      Integer modificadorInteligencia, Integer modificadorVontade, Integer modificadorMana,
                      Integer modificadorPv, Integer modificadorDefesa, Integer modificadorDeslocamento,
                      Boolean automatica) {
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
        this.modificadorForca = modificadorForca;
        this.modificadorAgilidade = modificadorAgilidade;
        this.modificadorInteligencia = modificadorInteligencia;
        this.modificadorVontade = modificadorVontade;
        this.modificadorMana = modificadorMana;
        this.modificadorPv = modificadorPv;
        this.modificadorDefesa = modificadorDefesa;
        this.modificadorDeslocamento = modificadorDeslocamento;
        this.automatica = automatica;
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

    @Column(length = 400)
    private String especial;

    private String dificuldade;

    private String mana;

    private String requisito;

    private Integer modificadorForca;

    private Integer modificadorAgilidade;

    private Integer modificadorInteligencia;

    private Integer modificadorVontade;

    private Integer modificadorMana;

    private Integer modificadorPv;

    private Integer modificadorDefesa;

    private Integer modificadorDeslocamento;

    private Boolean automatica;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }

    public List<Raca> getRacas() {
        return racas;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public Integer getNivel() {
        return nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEspecial() {
        return especial;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public String getMana() {
        return mana;
    }

    public String getRequisito() {
        return requisito;
    }

    public Integer getModificadorForca() {
        return modificadorForca;
    }

    public Integer getModificadorAgilidade() {
        return modificadorAgilidade;
    }

    public Integer getModificadorInteligencia() {
        return modificadorInteligencia;
    }

    public Integer getModificadorVontade() {
        return modificadorVontade;
    }

    public Integer getModificadorMana() {
        return modificadorMana;
    }

    public Integer getModificadorPv() {
        return modificadorPv;
    }

    public Integer getModificadorDefesa() {
        return modificadorDefesa;
    }

    public Integer getModificadorDeslocamento() {
        return modificadorDeslocamento;
    }

    public Boolean getAutomatica() {
        return automatica;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
        this.tipoHabilidade = tipoHabilidade;
    }

    protected void setRacas(List<Raca> racas) {
        this.racas = racas;
    }

    protected void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    protected void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    protected void setEspecial(String especial) {
        this.especial = especial;
    }

    protected void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    protected void setMana(String mana) {
        this.mana = mana;
    }

    protected void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    protected void setModificadorForca(Integer modificadorForca) {
        this.modificadorForca = modificadorForca;
    }

    protected void setModificadorAgilidade(Integer modificadorAgilidade) {
        this.modificadorAgilidade = modificadorAgilidade;
    }

    protected void setModificadorInteligencia(Integer modificadorInteligencia) {
        this.modificadorInteligencia = modificadorInteligencia;
    }

    protected void setModificadorVontade(Integer modificadorVontade) {
        this.modificadorVontade = modificadorVontade;
    }

    protected void setModificadorMana(Integer modificadorMana) {
        this.modificadorMana = modificadorMana;
    }

    protected void setModificadorPv(Integer modificadorPv) {
        this.modificadorPv = modificadorPv;
    }

    protected void setModificadorDefesa(Integer modificadorDefesa) {
        this.modificadorDefesa = modificadorDefesa;
    }

    protected void setModificadorDeslocamento(Integer modificadorDeslocamento) {
        this.modificadorDeslocamento = modificadorDeslocamento;
    }

    protected void setAutomatica(Boolean automatica) {
        this.automatica = automatica;
    }
}