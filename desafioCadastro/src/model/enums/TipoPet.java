package model.enums;

public enum TipoPet {
	
	CACHORRO("Cachorro"),
	GATO("Gato"),
	OUTRO("Outro");
	
	private String descricao;
	
	TipoPet(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
