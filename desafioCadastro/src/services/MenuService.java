package services;

import java.util.Scanner;

public class MenuService {

    private Scanner input;

    public MenuService(Scanner input) {
        this.input = input;
    }

    public int printMenu() {

        while (true) {
        	
            System.out.println("\n1. Cadastrar um novo pet");
            System.out.println("2. Listar pets por critério (idade, nome, raça)");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Alterar os dados do pet cadastrado");
            System.out.println("6. Sair");

            System.out.print("Digite um número de 1 a 6: ");

            if (input.hasNextInt()) {
                int escolha = input.nextInt();
                input.nextLine();

                if (escolha >= 1 && escolha <= 6) {
                    return escolha;
                } else {
                    System.out.println("Número fora do intervalo. Tente novamente.\n");
                }

            } else {
                System.out.println("Entrada inválida. Digite apenas números.\n");
                input.nextLine();
            }
        }
    }
}
