package services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Pet;

public class ExcluirPet {

	static final Path cadastros = Paths.get("C:\\temp\\petsCadastrados");

	public void excluirPet(Scanner sc) {

		BuscarPet buscarPet = new BuscarPet();
		ArrayList<Pet> petsList = buscarPet.buscarPet();

		if (petsList == null || petsList.isEmpty()) {
			System.out.println("Nenhum pet encontrado!!");
			return;
		}

		buscarPet.formatarBusca(petsList);

		System.out.print("Digite o número do pet que deseja excluir: ");
		int petEscolha;

		try {
			petEscolha = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida. tente novamente.");
			return;
		}

		if (petEscolha < 1 || petEscolha > petsList.size()) {
			System.out.println("Número inválido. Tente novamente.");
			return;
		}

		Pet petEscolhido = petsList.get(petEscolha - 1);

		System.out.println("Tem certeza que deseja excluir o pet: " + petEscolhido.getNomeCompleto() + "? (S/N)");
		char confirmacao = sc.next().charAt(0);

		if (confirmacao == 'N' || confirmacao == 'n') {
			System.out.println("Exclusão cancelada.");
			return;
		}

		File path = new File(String.valueOf(cadastros));
		File arquivoPet = new File(path, petEscolhido.getNomeArquivo());

		if (arquivoPet.exists()) {
			if (arquivoPet.delete()) {
				System.out.println("Pet excluído com sucesso!");
			} else {
				System.out.println("Erro ao excluir o pet. Tente novamente.");
			}
		} else {
			System.out.println("Arquivo do pet não encontrado. Tente novamente.");
		}
	}
}
