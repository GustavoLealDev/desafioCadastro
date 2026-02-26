package model.enums;

public enum PetSex {
	
	MACHO("Macho"),
	FEMEA("Fêmea");
	
	private String descricao;
	
	PetSex(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
