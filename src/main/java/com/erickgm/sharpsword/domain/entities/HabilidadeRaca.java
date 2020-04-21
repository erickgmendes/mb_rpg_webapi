package com.erickgm.sharpsword.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "habilidades_racas")
public class HabilidadeRaca {

    public HabilidadeRaca() {
    }

    public HabilidadeRaca(Habilidade habilidade, Raca raca, Boolean automatica) {
        this.automatica = automatica;
        this.habilidade = habilidade;
        this.raca = raca;
    }

    public HabilidadeRaca(Long id, Habilidade habilidade, Raca raca, Boolean automatica) {
        this.id = id;
        this.automatica = automatica;
        this.habilidade = habilidade;
        this.raca = raca;
    }

    @Id
    @GeneratedValue(generator = "seq_habilidades_racas", strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean automatica;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Habilidade habilidade;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Raca raca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAutomatica() {
        return automatica;
    }

    public void setAutomatica(Boolean automatica) {
        this.automatica = automatica;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
}
