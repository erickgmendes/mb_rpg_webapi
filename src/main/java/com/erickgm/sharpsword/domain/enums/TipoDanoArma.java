package com.erickgm.sharpsword.domain.enums;

public enum TipoDanoArma {

	TODOS(0L, "Todos"), 
	CONTUSAO(1L, "Contusão"), 
	CORTE(2L, "Corte"),
	PERFURACAO(3L, "Perfuração"),
	CORTE_PERFURACAO(4L, "Corte e Perfuração");
	
	private TipoDanoArma(Long indice, String nome) {
		this.indice = indice;
		this.nome = nome;
	}

	private Long indice;
	private String nome;

	public Long getIndice() {
		return indice;
	}

	public void setIndice(Long indice) {
		this.indice = indice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static TipoDanoArma getByIndice(Long indice){
		if (indice == null)
			return null;
		
		for (TipoDanoArma t : TipoDanoArma.values()){
			if (t.indice.equals(indice))
				return t;
		}
		return null;
	}
	
	public static TipoDanoArma getByNome(String nome){
		if (nome == null || nome.isEmpty())
			return null;
		
		for (TipoDanoArma t : TipoDanoArma.values()){
			if (t.nome.equals(nome))
				return t;
		}
		return null;
	}

}