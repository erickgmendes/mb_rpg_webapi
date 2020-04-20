package com.erickgm.sharpsword.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.erickgm.sharpsword.domain.enums.TipoHabilidade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "habilidades")
public class Habilidade implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_habilidade", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    private TipoHabilidade tipoHabilidade;

    @OneToMany(mappedBy = "raca")
    private List<HabilidadeRaca> habilidadesRacas;

    @OneToMany(mappedBy = "classe")
    private List<HabilidadeClasse> habilidadesClasses;

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

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }

    public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
        this.tipoHabilidade = tipoHabilidade;
    }

    public List<HabilidadeRaca> getHabilidadesRacas() {
        return habilidadesRacas;
    }

    public void setHabilidadesRacas(List<HabilidadeRaca> habilidadesRacas) {
        this.habilidadesRacas = habilidadesRacas;
    }

    public List<HabilidadeClasse> getHabilidadesClasses() {
        return habilidadesClasses;
    }

    public void setHabilidadesClasses(List<HabilidadeClasse> habilidadesClasses) {
        this.habilidadesClasses = habilidadesClasses;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecial() {
        return especial;
    }

    public void setEspecial(String especial) {
        this.especial = especial;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public Integer getModificadorForca() {
        return modificadorForca;
    }

    public void setModificadorForca(Integer modificadorForca) {
        this.modificadorForca = modificadorForca;
    }

    public Integer getModificadorAgilidade() {
        return modificadorAgilidade;
    }

    public void setModificadorAgilidade(Integer modificadorAgilidade) {
        this.modificadorAgilidade = modificadorAgilidade;
    }

    public Integer getModificadorInteligencia() {
        return modificadorInteligencia;
    }

    public void setModificadorInteligencia(Integer modificadorInteligencia) {
        this.modificadorInteligencia = modificadorInteligencia;
    }

    public Integer getModificadorVontade() {
        return modificadorVontade;
    }

    public void setModificadorVontade(Integer modificadorVontade) {
        this.modificadorVontade = modificadorVontade;
    }

    public Integer getModificadorMana() {
        return modificadorMana;
    }

    public void setModificadorMana(Integer modificadorMana) {
        this.modificadorMana = modificadorMana;
    }

    public Integer getModificadorPv() {
        return modificadorPv;
    }

    public void setModificadorPv(Integer modificadorPv) {
        this.modificadorPv = modificadorPv;
    }

    public Integer getModificadorDefesa() {
        return modificadorDefesa;
    }

    public void setModificadorDefesa(Integer modificadorDefesa) {
        this.modificadorDefesa = modificadorDefesa;
    }

    public Integer getModificadorDeslocamento() {
        return modificadorDeslocamento;
    }

    public void setModificadorDeslocamento(Integer modificadorDeslocamento) {
        this.modificadorDeslocamento = modificadorDeslocamento;
    }
}