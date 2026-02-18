package model.entities;

import model.enums.SexoPet;
import model.enums.TipoPet;

public class Pet {

	private String nomeCompleto;
	private String raca;
	private double idade;
	private double peso;
	private TipoPet tipoPet;
	private SexoPet sexoPet;
	private Endereco endereco;

	public Pet() {}
	
	public Pet(String nomeCompleto, String raca, double idade, double peso, TipoPet tipoPet, SexoPet sexoPet,
			Endereco endereco) {
		this.nomeCompleto = nomeCompleto;
		this.raca = raca;
		this.idade = idade;
		this.peso = peso;
		this.tipoPet = tipoPet;
		this.sexoPet = sexoPet;
		this.endereco = endereco;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public double getIdade() {
		return idade;
	}

	public void setIdade(double idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public TipoPet getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}

	public SexoPet getSexoPet() {
		return sexoPet;
	}

	public void setSexoPet(SexoPet sexoPet) {
		this.sexoPet = sexoPet;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("1 - " + nomeCompleto + "\n");
		sb.append("2 - " + tipoPet.getDescricao() + "\n");
		sb.append("3 - " + sexoPet.getDescricao() + "\n");
		sb.append("4 - " + endereco.toString() + "\n");
		sb.append("5 - " + idade + "\n");
		sb.append("6 - " + peso + "\n");
		sb.append("7 - " + raca + "\n");
		return sb.toString();
	}
}
