package com.erickgm.sharpsword.application.dto.response;

public class CalculoAtributoInteligenciaDtoResponse {

    private String idiomasAdicionais;
    private String chanceDeAprenderMagia;
    private String magiasArcanasAdicionais;

    public String getIdiomasAdicionais() {
        return idiomasAdicionais;
    }

    public void setIdiomasAdicionais(String idiomasAdicionais) {
        this.idiomasAdicionais = idiomasAdicionais;
    }

    public String getChanceDeAprenderMagia() {
        return chanceDeAprenderMagia;
    }

    public void setChanceDeAprenderMagia(String chanceDeAprenderMagia) {
        this.chanceDeAprenderMagia = chanceDeAprenderMagia;
    }

    public String getMagiasArcanasAdicionais() {
        return magiasArcanasAdicionais;
    }

    public void setMagiasArcanasAdicionais(String magiasArcanasAdicionais) {
        this.magiasArcanasAdicionais = magiasArcanasAdicionais;
    }
}