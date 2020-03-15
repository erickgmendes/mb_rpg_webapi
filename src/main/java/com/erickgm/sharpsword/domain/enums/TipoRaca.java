package com.erickgm.sharpsword.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoRaca {

    //TODAS("Todas"),
    AESIR("Aesir"),
    ANAO("Anão"),
    ELFO("Elfo"),
    FAEN("Faen"),
    FAUNO("Fauno"),
    FIRA("Fira"),
    HUMANO("Humano"),
    JUBAN("Juban"),
    LEVENT("Levent"),
    MAHOK("Mahok"),
    TAILOX("Tailox");

    TipoRaca(String nome) {
        this.nome = nome;
    }

    TipoRaca() {
    }

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static TipoRaca getByNome(String nome) {
        if (nome == null || nome.isEmpty())
            return null;

        for (TipoRaca t : TipoRaca.values()) {
            if (t.nome.equals(nome))
                return t;
        }
        return null;
    }

    public static List<TipoRaca> obterTodas() {
        List<TipoRaca> retorno = new ArrayList<>();

        for (TipoRaca t : TipoRaca.values())
            retorno.add(t);

        return retorno;
    }

    public static List<TipoRaca> obterTodasMenos(TipoRaca tipo) {
        List<TipoRaca> retorno = new ArrayList<>();

        for (TipoRaca t : TipoRaca.values())
            if (!t.equals(tipo))
                retorno.add(t);

        return retorno;
    }

    public static List<TipoRaca> obterDupla(TipoRaca tipo1, TipoRaca tipo2) {
        List<TipoRaca> retorno = new ArrayList<>();

        for (TipoRaca t : TipoRaca.values())
            if (t.equals(tipo1) || t.equals(tipo2))
                retorno.add(t);

        return retorno;
    }

    public static List<TipoRaca> obterTrio(TipoRaca tipo1, TipoRaca tipo2, TipoRaca tipo3) {
        List<TipoRaca> retorno = new ArrayList<>();

        for (TipoRaca t : TipoRaca.values())
            if (t.equals(tipo1) || t.equals(tipo2) || t.equals(tipo3))
                retorno.add(t);

        return retorno;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}