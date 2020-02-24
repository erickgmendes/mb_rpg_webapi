package com.erickgm.sharpsword.application.dto.response;

public class ForcaDtoResponse {

    private String ajuste;
    private String cargaLeve;
    private String cargaPesada;
    private String cargaMaxima;

    public String getAjuste() {
        return ajuste;
    }

    public String getCargaLeve() {
        return cargaLeve;
    }

    public String getCargaPesada() {
        return cargaPesada;
    }

    public String getCargaMaxima() {
        return cargaMaxima;
    }

    protected ForcaDtoResponse() {

    }

    public ForcaDtoResponse(String ajuste, String cargaLeve, String cargaPesada, String cargaMaxima)
    {
        this.ajuste = ajuste;
        this.cargaLeve = cargaLeve;
        this.cargaPesada = cargaPesada;
        this.cargaMaxima = cargaMaxima;
    }
}
