package com.erickgm.sharpsword.application.dto.response;

public class DestrezaDtoResponse {

    private String ajuste;
    private String localizarDesarmarArmadilhas;
    private String moverSeEmSilecio;
    private String abrirFechaduras;
    private String esconderSeNasSombras;
    private String pungar;

    protected DestrezaDtoResponse() {}

    public DestrezaDtoResponse(String ajuste, String moverSeEmSilecioEabrirFechaduras,
                               String localizarDesarmarArmadilhas,
                               String esconderSeNasSombrasEPungar) {

        this.ajuste = ajuste;
        this.abrirFechaduras = moverSeEmSilecioEabrirFechaduras;
        this.localizarDesarmarArmadilhas = localizarDesarmarArmadilhas;
        this.moverSeEmSilecio = moverSeEmSilecioEabrirFechaduras;
        this.esconderSeNasSombras = esconderSeNasSombrasEPungar;
        this.pungar = esconderSeNasSombrasEPungar;
    }

    public String getAjuste() {
        return ajuste;
    }

    public String getAbrirFechaduras() {
        return abrirFechaduras;
    }

    public String getLocalizarDesarmarArmadilhas() {
        return localizarDesarmarArmadilhas;
    }

    public String getMoverSeEmSilecio() {
        return moverSeEmSilecio;
    }

    public String getEsconderSeNasSombras() {
        return esconderSeNasSombras;
    }

    public String getPungar() {
        return pungar;
    }
}
