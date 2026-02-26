package util;

import java.util.Scanner;

import model.enums.PetSex;
import model.enums.PetType;

public class ValidatorUtil {

	public String validateName(Scanner sc) {

		while (true) {
			System.out.print("R: ");
			try {
				String name = sc.nextLine();

				if (name.isBlank()) {
					throw new IllegalArgumentException("Nome é obrigatório.");
				}

				if (!name.contains(" ")) {
					throw new IllegalArgumentException("Informe nome e sobrenome.");
				}

				if (!name.matches("[a-zA-Z ]+")) {
					throw new IllegalArgumentException("Nome não pode conter caracteres especiais ou números.");
				}

				return name;

			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				System.out.print("Digite novamente: ");
			}
		}

	}

	public Double validateAge(Scanner sc) {

		System.out.print("R: ");
		while (true) {
			String input = sc.nextLine().trim();

			if (input.isEmpty()) {
				return null;
			}

			try {
				input = input.replace(",", ".");
				double age = Double.parseDouble(input);
				if (age < 0.5 || age > 20) {
					throw new IllegalArgumentException("Error: Idade deve ser um número entre 0-20 anos");
				} else {
					return age;
				}

			} catch (NumberFormatException e) {
				System.out.println("Erro: Idade deve ser um número válido.");
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}

	public Double validateWeight(Scanner sc) {
		System.out.print("R: ");
		while (true) {
			String input = sc.nextLine().trim();

			if (input.isEmpty()) {
				return null;
			}

			try {
				input = input.replace(",", ".");
				double weight = Double.parseDouble(input);
				if (weight < 0 || weight > 60) {
					throw new IllegalArgumentException("Error: Peso deve ser um número entre 0-60 kg");
				} else {
					return weight;
				}

			} catch (NumberFormatException e) {
				System.out.println("Erro: Peso deve ser um número válido.");
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}
	

	public String validateRace(Scanner sc) {
		while(true) {
			try {
				System.out.print("R: ");
				String race = sc.nextLine().trim();
				if (race.isEmpty()) {
					return null;
				}
				if (!race.matches("[\\p{L} ]+")) {
					throw new IllegalArgumentException("Raça não pode conter caracteres especiais ou números.");
				}
				return race;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				System.out.print("Digite novamente: ");
			}
		}
	}

	public PetType validatePetType(Scanner sc) {

		
	    while (true) {
	        try {
	        	System.out.print("R: ");
	            String input = sc.nextLine().trim();
	            int choice = Integer.parseInt(input);

	            if (choice == 1) {
	                return PetType.CACHORRO;
	            } else if (choice == 2) {
	                return PetType.GATO;
	            } else {
	                throw new IllegalArgumentException("Opção inválida. Digite 1 ou 2.");
	            }

	        } catch (NumberFormatException e) {
	            System.out.println("Erro: Digite um número válido (1 ou 2).");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	}
	
	public PetSex validatePetSex(Scanner sc) {

		System.out.print("R: ");
	    while (true) {
	        try {
	            String input = sc.nextLine().trim();
	            int opcao = Integer.parseInt(input);

	            if (opcao == 1) {
	                return PetSex.MACHO;
	            } else if (opcao == 2) {
	                return PetSex.FEMEA;
	            } else {
	                throw new IllegalArgumentException("Opção inválida. Digite 1 ou 2.");
	            }

	        } catch (NumberFormatException e) {
	            System.out.println("Erro: Digite um número válido (1 ou 2).");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	}
	
	public Integer validateNumber(Scanner sc) {

	    while (true) {

	        System.out.print("Digite o número da casa: ");
	        String input = sc.nextLine().trim();

	        if (input.isEmpty()) {
	            return null;
	        }

	        if (input.matches("\\d+")) {
	            return Integer.parseInt(input);
	        } else {
	            System.out.println("Entrada inválida! Digite apenas números ou Enter para deixar em branco.");
	        }
	    }
	}
}
