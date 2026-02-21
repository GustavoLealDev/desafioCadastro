package model.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.enums.SexoPet;
import model.enums.TipoPet;

public class Pet {

	private String nomeCompleto;
	private TipoPet tipoPet;
	private SexoPet sexoPet;
	private Endereco endereco;
	private Double idade;
	private Double peso;
	private String raca;

	private static final String NAO_INFORMADO = "Não Informado";
	
	public Pet() {
	}

	public Pet(String nomeCompleto, TipoPet tipoPet, SexoPet sexoPet, Endereco endereco, Double idade, Double peso,String raca) {
		this.nomeCompleto = nomeCompleto;
		this.tipoPet = tipoPet;
		this.sexoPet = sexoPet;
		this.endereco = endereco;
		this.idade = idade;
		this.peso = peso;
		this.raca = raca;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public static Path getCadastro() {
		return cadastro;
	}
	
	private String formatar(Object valor) {
	    return (valor == null || valor.toString().isBlank())
	            ? NAO_INFORMADO
	            : valor.toString();
	}

	static final Path cadastro = Paths.get("C:\\temp\\petsCadastrados");

	public void salvarPet() {

		String nomeRegistrado = getNomeCompleto().replaceAll(" ", "");
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(dd-MM-yyyy_HH-mm-ss)");

		String nomeArquivo = formatter.format(dataHoraAtual) + nomeRegistrado + ".txt";

		File file = new File(String.valueOf(cadastro));
		File fileCadastro = new File(file, nomeArquivo);
		if (!file.exists()) {
			if (file.mkdirs()) {
				System.out.println("Arquivo criado com sucesso");
			} else {
				System.out.println("Error: Tente criar o cadastro novamente.");
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileCadastro))) {
			bw.write("Nome: " + getNomeCompleto() + 
					"\nTipo do Pet: " + formatar(getTipoPet()) + 
					"\nSexo do Pet: "+ formatar(getSexoPet()) + 
					"\nEndereço: " + formatar(getEndereco().getRua()) + ", " + formatar(getEndereco().getNumero()) + ", " + formatar(getEndereco().getCidade()) + 
					"\nIdade: " + formatar(getIdade()) + " ano(s)"+ 
					"\nPeso: " + formatar(getPeso()) + " Kg" + 
					"\nRaça: " + formatar(getRaca()));
			bw.flush();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Cadastro do pet salvo em: " + fileCadastro.getAbsolutePath());
	}
}