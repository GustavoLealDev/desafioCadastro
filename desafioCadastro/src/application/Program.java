package application;

import java.util.Locale;
import java.util.Scanner;

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
		menu.printMenu();
		CadastrarPet cadastrarPet = new CadastrarPet();
		
		cadastrarPet.cadastrarPet();
			
		
		sc.close();
	}
}
