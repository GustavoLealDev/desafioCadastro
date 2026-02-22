package model.entities;

public class EnderecoPet {

	private String rua;
	private Integer numero;
	private String cidade;

	public EnderecoPet() {
	}

	public EnderecoPet(String rua, Integer numero, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return rua + ", " + numero + ", " + cidade;
	}
}
