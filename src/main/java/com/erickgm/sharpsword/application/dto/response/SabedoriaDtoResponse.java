package com.erickgm.sharpsword.application.dto.response;

public class SabedoriaDtoResponse {

    private String ajusteProtecao;
    private String magiasAdicionais;

    protected SabedoriaDtoResponse() {}

    public SabedoriaDtoResponse(String ajusteProtecao, String magiasAdicionais) {
        this.ajusteProtecao = ajusteProtecao;
        this.magiasAdicionais = magiasAdicionais;
    }

    public String getAjusteProtecao() {
        return ajusteProtecao;
    }

    public String getMagiasAdicionais() {
        return magiasAdicionais;
    }
}
