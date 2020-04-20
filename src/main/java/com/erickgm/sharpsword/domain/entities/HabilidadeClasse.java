package com.erickgm.sharpsword.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "habilidades_classes")
public class HabilidadeClasse {

    public HabilidadeClasse() {}

    public HabilidadeClasse(Habilidade habilidade, Classe classe, Boolean automatica) {
        this.automatica = automatica;
        this.habilidade = habilidade;
        this.classe = classe;
    }

    public HabilidadeClasse(Long id, Habilidade habilidade, Classe classe, Boolean automatica) {
        this.id = id;
        this.automatica = automatica;
        this.habilidade = habilidade;
        this.classe = classe;
    }

    @Id
    @GeneratedValue(generator = "seq_habilidades_classes", strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean automatica;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Habilidade habilidade;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Classe classe;

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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}