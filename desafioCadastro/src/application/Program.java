package application;

import java.util.Locale;
import java.util.Scanner;

import services.BuscarPet;
import services.CadastrarPet;
import services.FormFileService;
import services.MenuService;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US); 
		Scanner sc = new Scanner(System.in);
		
		FormFileService formFileService = new FormFileService();
		formFileService.createFormFile();
		MenuService menu = new MenuService(sc);
		int opcao = menu.printMenu();
		CadastrarPet cadastrarPet = new CadastrarPet();
		BuscarPet buscarPet = new BuscarPet();
		
		do{
			switch (opcao) {
				case 1:
					cadastrarPet.cadastrarPet();
					break;
				case 2:
					buscarPet.menuBuscar();
					break;
				case 3:
					System.out.println("Saindo do programa...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
			if (opcao != 3) {
				opcao = menu.printMenu();
			}
		} while (opcao != 3);
			
			
			
		sc.close();
	}
}
