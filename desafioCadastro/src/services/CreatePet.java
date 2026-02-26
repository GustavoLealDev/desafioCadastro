package services;

import java.util.Scanner;

import model.entities.PetAddress;
import model.entities.Pet;
import util.FormFileUtil;
import util.ValidatorUtil;

public class CreatePet {

	Scanner sc = new Scanner(System.in);
	Pet pet = new Pet();
	PetAddress address = new PetAddress();
	ValidatorUtil validator = new ValidatorUtil();

	public void createPet() {
		FormFileUtil.readLine(1);
		pet.setName(validator.validateName(sc));

		FormFileUtil.readLine(2);
		pet.setPetType(validator.validatePetType(sc));

		FormFileUtil.readLine(3);
		pet.setPetSex(validator.validatePetSex(sc));

		FormFileUtil.readLine(4);
		address.setNumberHouse(validator.validateNumber(sc));
		
		System.out.print("Rua: ");
		address.setRoad(sc.nextLine());

		System.out.print("Bairro: ");
		address.setNeighborhood(sc.nextLine());

		pet.setAddress(address);

		FormFileUtil.readLine(5);
		pet.setAge(validator.validateAge(sc));

		FormFileUtil.readLine(6);
		pet.setWeight(validator.validateWeight(sc));

		FormFileUtil.readLine(7);
		pet.setRace(validator.validateRace(sc));
		
		pet.savePet();

	}

}
