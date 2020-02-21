package com.erickgm.sharpsword.application.dto.response;

public class CalculoAtributoForcaDtoResponse {

    private String ajuste;

    public String getAjuste() {
        return ajuste;
    }

    protected CalculoAtributoForcaDtoResponse() {

    }

    public CalculoAtributoForcaDtoResponse(String ajuste) {
        this.ajuste = ajuste;
    }
}
