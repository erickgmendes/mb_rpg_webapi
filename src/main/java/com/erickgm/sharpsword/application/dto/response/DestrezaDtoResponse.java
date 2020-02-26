package com.erickgm.sharpsword.application.dto.response;

public class DestrezaDtoResponse {

    private String ajusteAtaqueSurpresaDefesaProtecao;
    private String localizarDesarmarArmadilhas;
    private String moverSeEmSilecioAbrirFechaduras;
    private String esconderSeNasSombrasPungar;

    protected DestrezaDtoResponse() {}

    public DestrezaDtoResponse(String ajusteAtaqueSurpresaDefesaProtecao, String localizarDesarmarArmadilhas,
                               String moverSeEmSilecioAbrirFechaduras, String esconderSeNasSombrasPungar) {

        this.ajusteAtaqueSurpresaDefesaProtecao = ajusteAtaqueSurpresaDefesaProtecao;
        this.localizarDesarmarArmadilhas = localizarDesarmarArmadilhas;
        this.moverSeEmSilecioAbrirFechaduras = moverSeEmSilecioAbrirFechaduras;
        this.esconderSeNasSombrasPungar = esconderSeNasSombrasPungar;
    }

    public String getAjusteAtaqueSurpresaDefesaProtecao() {
        return ajusteAtaqueSurpresaDefesaProtecao;
    }

    public String getLocalizarDesarmarArmadilhas() {
        return localizarDesarmarArmadilhas;
    }

    public String getMoverSeEmSilecioAbrirFechaduras() {
        return moverSeEmSilecioAbrirFechaduras;
    }

    public String getEsconderSeNasSombrasPungar() {
        return esconderSeNasSombrasPungar;
    }
}
