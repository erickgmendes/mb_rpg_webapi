package com.erickgm.sharpsword.domain.enums;

public enum TipoArma {
	
	TODAS(0L, "Todas"), 
	CORPORAL(1L, "Armas Corporais"), 
	DISTANCIA(2L, "Armas de distância"); 

	private TipoArma(Long indice, String nome) {
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
	
	public static TipoArma getByIndice(Long indice){
		if (indice == null)
			return null;
		
		for (TipoArma t : TipoArma.values()){
			if (t.indice.equals(indice))
				return t;
		}
		return null;
	}
	
	public static TipoArma getByNome(String nome){
		if (nome == null || nome.isEmpty())
			return null;
		
		for (TipoArma t : TipoArma.values()){
			if (t.nome.equals(nome))
				return t;
		}
		return null;
	}

}