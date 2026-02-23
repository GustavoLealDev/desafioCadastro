package application;

import java.util.Locale;
import java.util.Scanner;

import services.BuscarPet;
import services.CadastrarPet;
import services.EditarPet;
import services.MenuService;
import util.FormFileService;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        FormFileService formFileService = new FormFileService();
        formFileService.createFormFile();

        MenuService menu = new MenuService(sc);

        CadastrarPet cadastrarPet = new CadastrarPet();
        BuscarPet buscarPet = new BuscarPet();
        EditarPet editarPet = new EditarPet();

        int opcao;

        do {

            opcao = menu.printMenu();

            if (opcao == 1) {
                cadastrarPet.cadastrarPet();
            }
            else if (opcao == 2) {
                buscarPet.menuBuscar();
            }
            else if (opcao == 3) {
            }
            else if (opcao == 4) {
                buscarPet.exibirResultados();
            }
            else if (opcao == 5) {
                editarPet.editarPet();
            }
            else if (opcao == 6) {
                System.out.println("Saindo do programa...");
            }
            else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);

        sc.close();
    }
}