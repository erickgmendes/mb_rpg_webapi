package com.erickgm.sharpsword.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoClasse {

    //TODAS("Todas"),
    BARDO("Bardo"),
    DRUIDA("Druida"),
    ESPADACHIM("Espadachim"),
    FEITICEIRO("Feiticeiro"),
    GUERREIRO("Guerreiro"),
    LADINO("Ladino"),
    PALADINO("Paladino"),
    PATRULHEIRO("Patrulheiro"),
    RUNICO("Rúnico"),
    SACERDOTE("Sacerdote"),
    XAMA("Xamã");

    TipoClasse(String nome) {
        this.nome = nome;
    }

    TipoClasse() {
    }

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static TipoClasse getByNome(String nome) {
        if (nome == null || nome.isEmpty())
            return null;

        for (TipoClasse t : TipoClasse.values()) {
            if (t.nome.equals(nome))
                return t;
        }
        return null;
    }

    public static List<TipoClasse> obterTodas() {
        List<TipoClasse> retorno = new ArrayList<>();

        for (TipoClasse t : TipoClasse.values())
            retorno.add(t);

        return retorno;
    }

    public static List<TipoClasse> obterTodasMenos(TipoClasse tipo) {
        List<TipoClasse> retorno = new ArrayList<>();

        for (TipoClasse t : TipoClasse.values())
            if (!t.equals(tipo))
                retorno.add(t);

        return retorno;
    }

    public static List<TipoClasse> obterDupla(TipoClasse tipo1, TipoClasse tipo2) {
        List<TipoClasse> retorno = new ArrayList<>();

        for (TipoClasse t : TipoClasse.values())
            if (t.equals(tipo1) || t.equals(tipo2))
                retorno.add(t);

        return retorno;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}