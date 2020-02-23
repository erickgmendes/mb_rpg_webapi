package com.erickgm.sharpsword.application.dto.response;

public class CarismaDtoResponse {

    private String ajuste;
    private String numeroSeguidores;
    private String mortosVivos;

    protected CarismaDtoResponse() {}

    public CarismaDtoResponse(String ajuste, String numeroSeguidores, String mortosVivos) {
        this.ajuste = ajuste;
        this.numeroSeguidores = numeroSeguidores;
        this.mortosVivos = mortosVivos;
    }

    public String getAjuste() {
        return ajuste;
    }

    public String getNumeroSeguidores() {
        return numeroSeguidores;
    }

    public String getMortosVivos() {
        return mortosVivos;
    }
}
