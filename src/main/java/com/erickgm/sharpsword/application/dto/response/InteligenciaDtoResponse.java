package com.erickgm.sharpsword.application.dto.response;

public class InteligenciaDtoResponse {

    private String idiomasAdicionais;
    private String chanceDeAprenderMagia;
    private String magiasArcanasAdicionais;

    protected InteligenciaDtoResponse() {
    }

    public InteligenciaDtoResponse(String idiomasAdicionais, String chanceDeAprenderMagia, String magiasArcanasAdicionais) {
        this.idiomasAdicionais = idiomasAdicionais;
        this.chanceDeAprenderMagia = chanceDeAprenderMagia;
        this.magiasArcanasAdicionais = magiasArcanasAdicionais;
    }

    public String getIdiomasAdicionais() {
        return idiomasAdicionais;
    }

    public String getChanceDeAprenderMagia() {
        return chanceDeAprenderMagia;
    }

    public String getMagiasArcanasAdicionais() {
        return magiasArcanasAdicionais;
    }

}