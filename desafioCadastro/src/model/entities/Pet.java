package model.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.enums.PetSex;
import model.enums.PetType;

public class Pet {

	private String name;
	private PetType petType;
	private PetSex petSex;
	private PetAddress address;
	private Double age;
	private Double weight;
	private String race;

	private String fileName;
	private static final String NAO_INFORMADO = "Não Informado";
	private static final Path PET_DIRECTORY = Paths.get("C:\\temp\\petsCadastrados");

	public Pet() {
	}

	public Pet(String name, PetType petType, PetSex petSex, PetAddress address, Double age, Double weight, String race) {
		this.name = name;
		this.petType = petType;
		this.petSex = petSex;
		this.address = address;
		this.age = age;
		this.weight = weight;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public PetSex getPetSex() {
		return petSex;
	}

	public void setPetSex(PetSex petSex) {
		this.petSex = petSex;
	}

	public PetAddress getAddress() {
		return address;
	}

	public void setAddress(PetAddress address) {
		this.address = address;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static Path getPetDirectory() {
		return PET_DIRECTORY;
	}

	private String format(Object value) {
		return (value == null || value.toString().isBlank()) ? NAO_INFORMADO : value.toString();
	}

	public void savePet() {

		String registeredName = getName().replaceAll(" ", "").toUpperCase();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(dd-MM-yyyy_HH-mm-ss)");

		this.fileName = formatter.format(currentDateTime) + registeredName + ".txt";

		File file = new File(String.valueOf(PET_DIRECTORY));
		File fileRegister = new File(file, fileName);
		if (!file.exists()) {
			if (file.mkdirs()) {
				System.out.println("Arquivo criado com sucesso");
			} else {
				System.out.println("Error: Tente criar o cadastro novamente.");
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileRegister))) {
			bw.write("1 Nome - " + getName() + "\n2 Espécie - " + format(getPetType()) + "\n3 Sexo - "
					+ format(getPetSex()) + "\n4 Endereço - " + format(getAddress().getRoad()) + ", "
					+ format(getAddress().getNumberHouse()) + ", " + format(getAddress().getNeighborhood()) + "\n5 Idade - "
					+ format(getAge()) + " Ano(s)" + "\n6 Peso - " + format(getWeight()) + " Kg" + "\n7 Raça - "
					+ format(getRace()));
			bw.flush();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Cadastro do pet salvo em: " + fileRegister.getAbsolutePath());
	}
}