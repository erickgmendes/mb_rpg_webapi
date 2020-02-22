package com.erickgm.sharpsword.application.dto.response;

public class ForcaDtoResponse {

    private String ajuste;

    public String getAjuste() {
        return ajuste;
    }

    protected ForcaDtoResponse() {

    }

    public ForcaDtoResponse(String ajuste) {
        this.ajuste = ajuste;
    }
}
