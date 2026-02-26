package model.enums;

public enum PetType {
	
	CACHORRO("Cachorro"),
	GATO("Gato");
	
	private String descricao;
	
	PetType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
