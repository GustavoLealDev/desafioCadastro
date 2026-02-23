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

public class EditarPet {

    private static final Path cadastro = Paths.get("C:\\temp\\petsCadastrados");

    public void editarPet() {
    	
        BuscarPet buscarPet = new BuscarPet();
        ArrayList<Pet> petsList = buscarPet.buscarPet();

        if (petsList == null || petsList.isEmpty()) {
            System.out.println("Nenhum pet encontrado para editar.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        buscarPet.formatarBusca(petsList);

        System.out.print("Digite o número do pet que deseja alterar: ");

        int petEscolha;

        try {
            petEscolha = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. tente novamente.");
            return;
        }

        if (petEscolha < 1 || petEscolha > petsList.size()) {
            System.out.println("Número inválido. Tente novamente.");
            return; 
        }

        Pet petEscolhido = petsList.get(petEscolha - 1);

        System.out.println("Editando: " + petEscolhido.getNomeCompleto());

        System.out.print("Novo nome (ENTER para manter): ");
        String novoNome = sc.nextLine();
        if (!novoNome.isBlank()) {
            petEscolhido.setNomeCompleto(novoNome);
        }

        System.out.print("Nova idade (ENTER para manter): ");
        String idadeStr = sc.nextLine();
        if (!idadeStr.isBlank()) {
            try {
                petEscolhido.setIdade(Double.parseDouble(idadeStr));
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Mantendo valor anterior.");
            }
        }

        System.out.print("Novo peso (ENTER para manter): ");
        String pesoStr = sc.nextLine();
        if (!pesoStr.isBlank()) {
            try {
                petEscolhido.setPeso(Double.parseDouble(pesoStr));
            } catch (NumberFormatException e) {
                System.out.println("Peso inválido. Mantendo valor anterior.");
            }
        }

        System.out.print("Nova raça (ENTER para manter): ");
        String novaRaca = sc.nextLine();
        if (!novaRaca.isBlank()) {
            petEscolhido.setRaca(novaRaca);
        }

        File fileCadastro = new File(cadastro + "\\" + petEscolhido.getNomeArquivo());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileCadastro))) {

            bw.write("1 Nome - " + petEscolhido.getNomeCompleto()
                    + "\n2 Espécie - " + petEscolhido.getTipoPet()
                    + "\n3 Sexo - " + petEscolhido.getSexoPet()
                    + "\n4 Endereço - "
                    + petEscolhido.getEndereco().getRua() + ", "
                    + petEscolhido.getEndereco().getNumero() + ", "
                    + petEscolhido.getEndereco().getCidade()
                    + "\n5 Idade - " + petEscolhido.getIdade() + " Ano(s)"
                    + "\n6 Peso - " + petEscolhido.getPeso() + " Kg"
                    + "\n7 Raça - " + petEscolhido.getRaca());

        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            return;
        }

        System.out.println("Pet atualizado com sucesso!");
    }
}