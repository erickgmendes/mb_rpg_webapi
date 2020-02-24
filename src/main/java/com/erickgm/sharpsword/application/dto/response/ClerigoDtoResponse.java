package com.erickgm.sharpsword.application.dto.response;

public class ClerigoDtoResponse {

    private	String xpMinimo;
    private	String dvQuantidade;
    private	String dv;
    private	String ba;
    private	String jp;
    private	String magiasNivel1;
    private	String magiasNivel2;
    private	String magiasNivel3;
    private String esqueleto;
    private String zumbi;
    private String carnical;
    private String inumano;
    private String aparicao;

    protected ClerigoDtoResponse() {}

    public ClerigoDtoResponse(String xpMinimo, String dvQuantidade, String ba, String jp, String magiasNivel1, String magiasNivel2, String magiasNivel3, String esqueleto, String zumbi, String carnical, String inumano, String aparicao) {
        this.xpMinimo = xpMinimo;
        this.dvQuantidade = dvQuantidade;
        this.ba = ba;
        this.jp = jp;
        this.magiasNivel1 = magiasNivel1;
        this.magiasNivel2 = magiasNivel2;
        this.magiasNivel3 = magiasNivel3;
        this.esqueleto = esqueleto;
        this.zumbi = zumbi;
        this.carnical = carnical;
        this.inumano = inumano;
        this.aparicao = aparicao;
        this.dv = "d8";
    }

    public String getXpMinimo() {
        return xpMinimo;
    }

    public String getDv() {
        return dv;
    }

    public String getBa() {
        return ba;
    }

    public String getJp() {
        return jp;
    }

    public String getMagiasNivel1() {
        return magiasNivel1;
    }

    public String getMagiasNivel2() {
        return magiasNivel2;
    }

    public String getMagiasNivel3() {
        return magiasNivel3;
    }

    public String getEsqueleto() {
        return esqueleto;
    }

    public String getZumbi() {
        return zumbi;
    }

    public String getCarnical() {
        return carnical;
    }

    public String getInumano() {
        return inumano;
    }

    public String getAparicao() {
        return aparicao;
    }

    public String getDvQuantidade() {
        return dvQuantidade;
    }
}
