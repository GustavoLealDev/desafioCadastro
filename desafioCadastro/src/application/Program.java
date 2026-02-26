package application;

import java.util.Locale;
import java.util.Scanner;

import services.SearchPet;
import services.CreatePet;
import services.UpdatePet;
import services.DeletePet;
import services.MenuService;
import util.FormFileUtil;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        FormFileUtil formFileService = new FormFileUtil();
        formFileService.createFormFile();

        MenuService menu = new MenuService(sc);

        CreatePet createPet = new CreatePet();
        SearchPet searchPet = new SearchPet();
        UpdatePet updatePet = new UpdatePet();
        DeletePet deletePet = new DeletePet();

        int option;

        do {

        	option = menu.printMenu();

            if (option == 1) {
            	createPet.createPet();
            }
            else if (option == 2) {
                searchPet.searchMenu();
            }
            else if (option == 3) {
            	deletePet.deletePet(sc);
            }
            else if (option == 4) {
                searchPet.showResults();
            }
            else if (option == 5) {
                updatePet.updatePet();
            }
            else if (option == 6) {
                System.out.println("Saindo do programa...");
            }
            else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 6);

        sc.close();
    }
}