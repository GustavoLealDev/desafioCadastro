package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Pet;

public class UpdatePet {

    private static final Path PET_DIRECTORY = Paths.get("C:\\temp\\petsCadastrados");

    public void updatePet() {
    	
        SearchPet searchPet = new SearchPet();
        ArrayList<Pet> petsList = searchPet.searchPet();

        if (petsList == null || petsList.isEmpty()) {
            System.out.println("Nenhum pet encontrado para editar.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        searchPet.formatSearch(petsList);

        System.out.print("Digite o número do pet que deseja alterar: ");

        int choice;

        try {
        	choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. tente novamente.");
            return;
        }

        if (choice < 1 || choice > petsList.size()) {
            System.out.println("Número inválido. Tente novamente.");
            return; 
        }

        Pet pet = petsList.get(choice - 1);

        System.out.println("Editando: " + pet.getName());

        System.out.print("Novo nome (ENTER para manter): ");
        String newName = sc.nextLine();
        if (!newName.isBlank()) {
        	pet.setName(newName);
        }

        System.out.print("Nova idade (ENTER para manter): ");
        String ageStr = sc.nextLine();
        if (!ageStr.isBlank()) {
            try {
            	pet.setAge(Double.parseDouble(ageStr));
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Mantendo valor anterior.");
            }
        }

        System.out.print("Novo peso (ENTER para manter): ");
        String weightStr = sc.nextLine();
        if (!weightStr.isBlank()) {
            try {
            	pet.setWeight(Double.parseDouble(weightStr));
            } catch (NumberFormatException e) {
                System.out.println("Peso inválido. Mantendo valor anterior.");
            }
        }

        System.out.print("Nova raça (ENTER para manter): ");
        String newRace = sc.nextLine();
        if (!newRace.isBlank()) {
        	pet.setRace(newRace);
        }

        File fileRegister = new File(PET_DIRECTORY + "\\" + pet.getFileName());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileRegister))) {

            bw.write("1 Nome - " + pet.getName()
                    + "\n2 Espécie - " + pet.getPetType()
                    + "\n3 Sexo - " + pet.getPetSex()
                    + "\n4 Endereço - "
                    + pet.getAddress().getRoad() + ", "
                    + pet.getAddress().getNumberHouse() + ", "
                    + pet.getAddress().getNeighborhood()
                    + "\n5 Idade - " + pet.getAge() + " Ano(s)"
                    + "\n6 Peso - " + pet.getWeight() + " Kg"
                    + "\n7 Raça - " + pet.getRace());

        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            return;
        }

        System.out.println("Pet atualizado com sucesso!");
    }
}