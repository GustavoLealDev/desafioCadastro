package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormFileService {

	static Path path = Paths.get("C:\\temp\\formulario.txt");
	
	public void createFormFile() {
		File file = path.toFile();
		
		File createFolder = file.getParentFile();
		if (!createFolder.exists()) {
			createFolder.mkdirs();
			System.out.println("Pasta criada com sucesso!");
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			 bw.write("1 - Qual o nome e sobrenome do pet?"
			 		+ "\n2 - Qual o tipo do pet (Cachorro/Gato)"
			 		+ "\n3 - Qual o sexo do animal?"
			 		+ "\n4 - Qual endereço e bairro que ele foi encontrado?"
			 		+ "\n5 - Qual a idade aproximada do pet?"
			 		+ "\n6 - Qual o peso aproximado do pet?"
			 		+ "\n7 - Qual a raça do pet?");
			bw.flush();
			System.out.println("Arquivo criado com sucesso!");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void readFormFile() {
		String path = "C:\\temp\\formulario.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
