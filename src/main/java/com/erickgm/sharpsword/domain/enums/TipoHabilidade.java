package com.erickgm.sharpsword.domain.enums;

public enum TipoHabilidade {

	SUPORTE(1L, "Suporte", "Está sempre acionada. Seus efeitos estão sempre ativos, não importa o que o personagem faça. Não se pode “desligar” os efeitos de Habilidades do tipo Suporte."), 
	ACAO(2L, "Ação", "Requer uma ação padrão para acionar. Um personagem pode usar essas habilidades a qualquer momento em que fosse realizar uma ação padrão a menos que ela especifique que o personagem precisa desempenha-la como uma ação de turno completo – como realizar um Encontrão. (veja combate, adiante, para mais detalhes sobre os tipos de ações)"), 
	REACAO(3L, "Reação", "Acionada a partir de um acontecimento. Sempre que o acontecimento descrito na Habilidade ocorrer, o efeito de Reação pode ser acionado – mesmo em turnos em que o personagem tenha usado Habilidades de Ação ou realizado ações de turno completo. No entanto, nenhuma Habilidade de Reação ocorre automaticamente. O jogador precisa anunciar que seu personagem irá reagir à situação que aciona sua Habilidade de Reação para que ela tenha efeito. Além disso, cada Reação só pode ser acionada uma vez para cada efeito que a desencadeie."), 
	ESPECIAL(4L, "Especial", ""); 

	private TipoHabilidade(Long indice, String nome, String descricao) {
		this.indice = indice;
		this.nome = nome;
	}

	private TipoHabilidade() {
	}

	private Long indice;
	private String nome;
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoHabilidade getByIndice(Long indice) {
		if (indice == null)
			return null;

		for (TipoHabilidade t : TipoHabilidade.values()) {
			if (t.indice.equals(indice))
				return t;
		}
		return null;
	}

	public static TipoHabilidade getByNome(String nome) {
		if (nome == null || nome.isEmpty())
			return null;

		for (TipoHabilidade t : TipoHabilidade.values()) {
			if (t.nome.equals(nome))
				return t;
		}
		return null;
	}
	
	public static TipoHabilidade getByDescricao(String descricao) {
		if (descricao == null || descricao.isEmpty())
			return null;

		for (TipoHabilidade t : TipoHabilidade.values()) {
			if (t.descricao.equals(descricao))
				return t;
		}
		return null;
	}

}