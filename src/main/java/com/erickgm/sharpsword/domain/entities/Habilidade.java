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

    public Habilidade(Long id, String nome, TipoHabilidade tipoHabilidade, List<Raca> racas, List<Classe> classes, Integer nivel, String descricao, String especial, Integer dificuldade, Integer mana, String requisito, Integer modificadorForca, Integer modificadorAgilidade, Integer modificadorInteligencia, Integer modificadorVontade, Integer modificadorMana, Integer modificadorPv, Integer modificadorDefesa, Integer modificadorDeslocamento, Boolean automatica) {
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

    private Integer dificuldade;

    private Integer mana;

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


}