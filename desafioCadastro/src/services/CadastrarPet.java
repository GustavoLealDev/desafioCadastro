package services;

import java.util.Scanner;

import model.entities.Endereco;
import model.entities.Pet;

public class CadastrarPet {

	Scanner sc = new Scanner(System.in);
	Pet pet = new Pet();
	Endereco endereco = new Endereco();
	ValidadorService validador = new ValidadorService();

	public void cadastrarPet() {
		FormFileService.readLine(1);
		pet.setNomeCompleto(validador.validarNome(sc));

		FormFileService.readLine(2);
		System.out.println("Escolha uma opção: 1 - Cachorro, 2 - Gato");
		pet.setTipoPet(validador.validarTipoPet(sc));

		FormFileService.readLine(3);
		System.out.println("Escolha uma opção: 1 - Macho, 2 - Fêmea");
		pet.setSexoPet(validador.validarSexoPet(sc));

		FormFileService.readLine(4);
		System.out.print("\nNúmero  da casa: ");
		endereco.setNumero(validador.validarNumero(sc));

		System.out.print("Rua: ");
		endereco.setRua(sc.nextLine());

		System.out.print("Cidade: ");
		endereco.setCidade(sc.nextLine());

		pet.setEndereco(endereco);

		FormFileService.readLine(5);
		pet.setIdade(validador.validarIdade(sc));

		FormFileService.readLine(6);
		pet.setPeso(validador.validarPeso(sc));

		FormFileService.readLine(7);
		pet.setRaca(sc.nextLine());

	}

}
