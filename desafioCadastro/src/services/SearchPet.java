package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.PetAddress;
import model.entities.Pet;
import model.enums.PetSex;
import model.enums.PetType;
import util.ValidatorUtil;

public class SearchPet {

    static final Path PET_DIRECTORY = Paths.get("C:\\temp\\petsCadastrados");

    public ArrayList<Pet> searchPet() {

        File path = new File(String.valueOf(PET_DIRECTORY));
        File[] files = path.listFiles();

        ArrayList<Pet> pets = new ArrayList<>();

        if (files == null) {
            return pets;
        }

        for (File file : files) {

            if (!file.getName().endsWith(".txt")) {
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String name = extractValue(br.readLine());
                String type = extractValue(br.readLine());
                String sex = extractValue(br.readLine());
                String address = extractValue(br.readLine());

                String ageStr = extractValue(br.readLine());
                ageStr = ageStr.replaceAll("[^0-9.]", "");
                Double age = ageStr.isBlank() ? 0.0 : Double.parseDouble(ageStr);

                String weightStr = extractValue(br.readLine());
                weightStr = weightStr.replaceAll("[^0-9.]", "");
                Double weight = weightStr.isBlank() ? 0.0 : Double.parseDouble(weightStr);

                String race = extractValue(br.readLine());

                Pet pet = new Pet();
                pet.setFileName(file.getName());
                PetAddress addressPet = new PetAddress();

                String[] addressSplit = address.split(",");

                addressPet.setRoad(addressSplit[0].trim());
                addressPet.setNumberHouse(
                		addressSplit[1].trim().equalsIgnoreCase("NAO_INFORMADO")
                                ? null
                                : Integer.parseInt(addressSplit[1].trim())
                );
                addressPet.setNeighborhood(addressSplit[2].trim());

                pet.setName(name);
                pet.setPetType(PetType.valueOf(type.toUpperCase()));
                pet.setPetSex(PetSex.valueOf(sex.toUpperCase()));
                pet.setAge(age);
                pet.setWeight(weight);
                pet.setRace(race);
                pet.setAddress(addressPet);

                pets.add(pet);

            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
            }
        }

        return pets;
    }


    private String extractValue(String line) {
        if (line == null || !line.contains(" - ")) {
            return "";
        }

        String[] parts = line.split(" - ", 2);
        return parts[1].trim();
    }

    public void searchOptions() {
        System.out.println("1 - Nome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
    }

    private List<Pet> searchByName(String searchName, List<Pet> petList) {

        if (searchName == null || searchName.isBlank()) {
            return petList;
        }

        String nome = searchName.toLowerCase();

        return petList.stream()
                .filter(pet -> pet.getName() != null &&
                        pet.getName().toLowerCase().contains(nome))
                .toList();
    }

    private List<Pet> searchByAge(double searchAge, List<Pet> petList) {

        return petList.stream()
                .filter(pet -> pet.getAge() == searchAge)
                .toList();
    }

    public void searchMenu() {

        Scanner sc = new Scanner(System.in);
        ValidatorUtil validacao = new ValidatorUtil();

        List<Pet> petList = searchPet();
        List<Pet> petListFound;

        System.out.println("Você deseja buscar: (1 - Cachorro / 2 - Gato)");
        System.out.print("Escolha: ");
        int typeOptions = sc.nextInt();

        PetType petType;

        if (typeOptions == 1) {
        	petType = PetType.CACHORRO;
        } else if (typeOptions == 2) {
        	petType = PetType.GATO;
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        petListFound = petList.stream()
                .filter(pet -> pet.getPetType() == petType)
                .toList();

        System.out.println("Escolha a primeira opção de busca: ");
        searchOptions();
        System.out.print("Escolha: ");
        int searchOption1 = sc.nextInt();

        System.out.print("Escolha a segunda opção de busca: ");
        int searchOption2 = sc.nextInt();

        sc.nextLine();

        if (searchOption1 == 1 || searchOption2 == 1) {

            System.out.print("Digite o nome do pet: ");
            String search = sc.nextLine().toLowerCase().trim();

            petListFound = searchByName(search, petListFound);
        }

        if (searchOption1 == 2 || searchOption2 == 2) {

            System.out.println("Você deseja buscar: (1 - Macho / 2 - Femea)");
            System.out.print("Escolha: ");
            int sexOptions = sc.nextInt();

            PetSex petSex;

            if (sexOptions == 1) {
            	petSex = PetSex.MACHO;
            } else if (sexOptions == 2) {
            	petSex = PetSex.FEMEA;
            } else {
                System.out.println("Opção inválida.");
                return;
            }

            petListFound = petListFound.stream()
                    .filter(pet -> pet.getPetSex() == petSex)
                    .toList();
        }

        if (searchOption1 == 3 || searchOption2 == 3) {

            System.out.println("Digite a idade do pet: ");
            double ageSearch = validacao.validateNumber(sc);

            petListFound = searchByAge(ageSearch, petListFound);
        }

        formatSearch(petListFound);
    }

    public void formatSearch(List<Pet> results) {
    	System.out.println();
    	System.out.println("Resultados da busca:");	
    	System.out.println("-----------------------------------");
        if (results == null || results.isEmpty()) {
            System.out.println("Nenhum pet encontrado!");
            return;
        }

        int cont = 1;

        for (Pet pet : results) {

            System.out.println(String.format(
                    "%d - %s, %s, %s, %s, %.1f anos, %.1f kg, raça: %s",
                    cont++,
                    pet.getName(),
                    pet.getPetType(),
                    pet.getPetSex(),
                    pet.getAddress().getRoad() + ", " + pet.getAddress().getNumberHouse() + ", " + pet.getAddress().getNeighborhood(),
                    pet.getAge(),
                    pet.getWeight(),
                    pet.getRace()
            ));
        }
        System.out.println("-----------------------------------");
    }

    public void showResults() {
    	formatSearch(searchPet());
    }
}