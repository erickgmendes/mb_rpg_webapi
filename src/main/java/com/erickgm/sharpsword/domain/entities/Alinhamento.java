package com.erickgm.sharpsword.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alinhamentos")
public class Alinhamento implements Serializable {

    protected Alinhamento() {
        super();
    }

    public Alinhamento(Long id, String nome) {
        super();
        this.id = id;
        modificaValores(nome);
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "seq_alinhamento", strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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
}