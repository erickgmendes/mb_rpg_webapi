package com.erickgm.sharpsword.domain.enums;

public enum TipoDistanciaArma {

	TODOS(0L, "Todos"), 
	CORPO_A_CORPO(1L, "Corpo-a-corpo"), 
	HASTE(2L, "Haste"), 
	CURTO(3L, "Curto"),
	MEDIO(4L, "Médio"),
	LONGO(5L, "Longo");

	private TipoDistanciaArma(Long indice, String nome) {
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
	
	public static TipoDistanciaArma getByIndice(Long indice){
		if (indice == null)
			return null;
		
		for (TipoDistanciaArma t : TipoDistanciaArma.values()){
			if (t.indice.equals(indice))
				return t;
		}
		return null;
	}
	
	public static TipoDistanciaArma getByNome(String nome){
		if (nome == null || nome.isEmpty())
			return null;
		
		for (TipoDistanciaArma t : TipoDistanciaArma.values()){
			if (t.nome.equals(nome))
				return t;
		}
		return null;
	}

}
