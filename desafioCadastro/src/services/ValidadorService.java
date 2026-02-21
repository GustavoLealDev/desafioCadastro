package services;

import java.util.Scanner;

import model.enums.SexoPet;
import model.enums.TipoPet;

public class ValidadorService {

	public String validarNome(Scanner sc) {

		while (true) {
			System.out.print("R: ");
			try {
				String nomeCompleto = sc.nextLine();

				if (nomeCompleto.isBlank()) {
					throw new IllegalArgumentException("Nome é obrigatório.");
				}

				if (!nomeCompleto.contains(" ")) {
					throw new IllegalArgumentException("Informe nome e sobrenome.");
				}

				if (!nomeCompleto.matches("[a-zA-Z ]+")) {
					throw new IllegalArgumentException("Nome não pode conter caracteres especiais ou números.");
				}

				return nomeCompleto;

			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				System.out.print("Digite novamente: ");
			}
		}

	}

	public Double validarIdade(Scanner sc) {

		System.out.print("R: ");
		while (true) {
			String input = sc.nextLine().trim();

			if (input.isEmpty()) {
				return null;
			}

			try {
				input = input.replace(",", ".");
				double idade = Double.parseDouble(input);
				if (idade < 0.5 || idade > 20) {
					throw new IllegalArgumentException("Error: Idade deve ser um número entre 0-20 anos");
				} else {
					return idade;
				}

			} catch (NumberFormatException e) {
				System.out.println("Erro: Idade deve ser um número válido.");
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}

	public Double validarPeso(Scanner sc) {
		System.out.print("R: ");
		while (true) {
			String input = sc.nextLine().trim();

			if (input.isEmpty()) {
				return null;
			}

			try {
				input = input.replace(",", ".");
				double peso = Double.parseDouble(input);
				if (peso < 0 || peso > 60) {
					throw new IllegalArgumentException("Error: Peso deve ser um número entre 0-60 kg");
				} else {
					return peso;
				}

			} catch (NumberFormatException e) {
				System.out.println("Erro: Peso deve ser um número válido.");
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}

	public TipoPet validarTipoPet(Scanner sc) {

		System.out.print("R: ");
	    while (true) {
	        try {
	            String input = sc.nextLine().trim();
	            int opcao = Integer.parseInt(input);

	            if (opcao == 1) {
	                return TipoPet.CACHORRO;
	            } else if (opcao == 2) {
	                return TipoPet.GATO;
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
	
	public SexoPet validarSexoPet(Scanner sc) {

		System.out.print("R: ");
	    while (true) {
	        try {
	            String input = sc.nextLine().trim();
	            int opcao = Integer.parseInt(input);

	            if (opcao == 1) {
	                return SexoPet.MACHO;
	            } else if (opcao == 2) {
	                return SexoPet.FEMEA;
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
	
	public Integer validarNumero(Scanner input) {

	    while (true) {

	        System.out.print("Digite o número da casa: ");
	        String entrada = input.nextLine().trim();

	        if (entrada.isEmpty()) {
	            return null;
	        }

	        if (entrada.matches("\\d+")) {
	            return Integer.parseInt(entrada);
	        } else {
	            System.out.println("Entrada inválida! Digite apenas números ou Enter para deixar em branco.");
	        }
	    }
	}
}
