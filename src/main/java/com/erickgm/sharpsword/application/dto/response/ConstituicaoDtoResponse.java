package com.erickgm.sharpsword.application.dto.response;

public class ConstituicaoDtoResponse {

    private String pontosDeVidaEProtecao;
    private String percentualRessurreicao;

    public String getPontosDeVidaEProtecao() {
        return pontosDeVidaEProtecao;
    }

    public String getPercentualRessurreicao() {
        return percentualRessurreicao;
    }

    protected ConstituicaoDtoResponse() {}

    public ConstituicaoDtoResponse(String pontosDeVidaEProtecao, String percentualRessurreicao) {
        this.pontosDeVidaEProtecao = pontosDeVidaEProtecao;
        this.percentualRessurreicao = percentualRessurreicao;
    }
}
