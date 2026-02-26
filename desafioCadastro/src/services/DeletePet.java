package services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Pet;

public class DeletePet {

	private static final Path PET_DIRECTORY = Paths.get("C:\\temp\\petsCadastrados");

	public void deletePet(Scanner sc) {

		SearchPet searchPet = new SearchPet();
		ArrayList<Pet> petsList = searchPet.searchPet();

		if (petsList == null || petsList.isEmpty()) {
			System.out.println("Nenhum pet encontrado!!");
			return;
		}

		searchPet.formatSearch(petsList);

		System.out.print("Digite o número do pet que deseja excluir: ");
		int petChoice;

		try {
			petChoice = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida. tente novamente.");
			return;
		}

		if (petChoice < 1 || petChoice > petsList.size()) {
			System.out.println("Número inválido. Tente novamente.");
			return;
		}

		Pet pet = petsList.get(petChoice - 1);

		System.out.println("Tem certeza que deseja excluir o pet: " + pet.getName() + "? (S/N)");
		char confirmation = sc.next().charAt(0);

		if (confirmation == 'N' || confirmation == 'n') {
			System.out.println("Exclusão cancelada.");
			return;
		}

		File path = new File(String.valueOf(PET_DIRECTORY));
		File petFiles = new File(path, pet.getFileName());

		if (petFiles.exists()) {
			if (petFiles.delete()) {
				System.out.println("Pet excluído com sucesso!");
			} else {
				System.out.println("Erro ao excluir o pet. Tente novamente.");
			}
		} else {
			System.out.println("Arquivo do pet não encontrado. Tente novamente.");
		}
	}
}
