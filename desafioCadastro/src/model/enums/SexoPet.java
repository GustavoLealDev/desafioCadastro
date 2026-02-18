package model.enums;

public enum SexoPet {
	
	MACHO("Macho"),
	FEMEA("Fêmea");
	
	private String descricao;
	
	SexoPet(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
