package model.entities;

public class Endereco {

	private String rua;
	private Integer numero;
	private String cidade;

	public Endereco() {
	}

	public Endereco(String rua, Integer numero, String cidade) {
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
