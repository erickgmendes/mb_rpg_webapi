package com.erickgm.sharpsword.domain.enums;

public enum TipoRaca {

    TODAS("Todas"),
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

    @Override
    public String toString() {
        return this.nome;
    }
}