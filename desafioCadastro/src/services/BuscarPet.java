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

import model.entities.EnderecoPet;
import model.entities.Pet;
import model.enums.SexoPet;
import model.enums.TipoPet;

public class BuscarPet {

    static final Path cadastros = Paths.get("C:\\temp\\petsCadastrados");

    public ArrayList<Pet> buscarPet() {

        File pasta = new File(String.valueOf(cadastros));
        File[] arquivos = pasta.listFiles();

        ArrayList<Pet> pets = new ArrayList<>();

        if (arquivos == null) {
            return pets;
        }

        for (File arquivo : arquivos) {

            if (!arquivo.getName().endsWith(".txt")) {
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

                String nome = extrairValor(br.readLine());
                String tipo = extrairValor(br.readLine());
                String sexo = extrairValor(br.readLine());
                String endereco = extrairValor(br.readLine());

                String idadeStr = extrairValor(br.readLine());
                idadeStr = idadeStr.replaceAll("[^0-9.]", "");
                Double idade = idadeStr.isBlank() ? 0.0 : Double.parseDouble(idadeStr);

                String pesoStr = extrairValor(br.readLine());
                pesoStr = pesoStr.replaceAll("[^0-9.]", "");
                Double peso = pesoStr.isBlank() ? 0.0 : Double.parseDouble(pesoStr);

                String raca = extrairValor(br.readLine());

                Pet pet = new Pet();
                EnderecoPet enderecoPet = new EnderecoPet();

                String[] enderecoSplit = endereco.split(",");

                enderecoPet.setRua(enderecoSplit[0].trim());
                enderecoPet.setNumero(
                        enderecoSplit[1].trim().equalsIgnoreCase("NAO_INFORMADO")
                                ? null
                                : Integer.parseInt(enderecoSplit[1].trim())
                );
                enderecoPet.setCidade(enderecoSplit[2].trim());

                pet.setNomeCompleto(nome);
                pet.setTipoPet(TipoPet.valueOf(tipo.toUpperCase()));
                pet.setSexoPet(SexoPet.valueOf(sexo.toUpperCase()));
                pet.setIdade(idade);
                pet.setPeso(peso);
                pet.setRaca(raca);
                pet.setEndereco(enderecoPet);

                pets.add(pet);

            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
            }
        }

        return pets;
    }


    private String extrairValor(String linha) {
        if (linha == null || !linha.contains(" - ")) {
            return "";
        }

        String[] partes = linha.split(" - ", 2);
        return partes[1].trim();
    }

    public void opcoesDeBusca() {
        System.out.println("1 - Nome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
    }

    private List<Pet> buscaPorNome(String nomeBuscado, List<Pet> listaPets) {

        if (nomeBuscado == null || nomeBuscado.isBlank()) {
            return listaPets;
        }

        String nome = nomeBuscado.toLowerCase();

        return listaPets.stream()
                .filter(pet -> pet.getNomeCompleto() != null &&
                        pet.getNomeCompleto().toLowerCase().contains(nome))
                .toList();
    }

    private List<Pet> buscaPorIdade(double idadeBuscada, List<Pet> listaPets) {

        return listaPets.stream()
                .filter(pet -> pet.getIdade() == idadeBuscada)
                .toList();
    }

    public void menuBuscar() {

        Scanner sc = new Scanner(System.in);
        ValidadorService validacao = new ValidadorService();

        List<Pet> listaPets = buscarPet();
        List<Pet> listaPetsEncontrados;

        System.out.println("Você deseja buscar: (1 - Cachorro / 2 - Gato)");
        System.out.print("Escolha: ");
        int opcaoTipo = sc.nextInt();

        TipoPet tipoPet;

        if (opcaoTipo == 1) {
            tipoPet = TipoPet.CACHORRO;
        } else if (opcaoTipo == 2) {
            tipoPet = TipoPet.GATO;
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        listaPetsEncontrados = listaPets.stream()
                .filter(pet -> pet.getTipoPet() == tipoPet)
                .toList();

        System.out.println("Escolha a primeira opção de busca: ");
        opcoesDeBusca();
        System.out.print("Escolha: ");
        int opcaoBusca1 = sc.nextInt();

        System.out.print("Escolha a segunda opção de busca: ");
        int opcaoBusca2 = sc.nextInt();

        sc.nextLine();

        if (opcaoBusca1 == 1 || opcaoBusca2 == 1) {

            System.out.println("Digite o nome do pet: ");
            String busca = sc.nextLine().toLowerCase().trim();

            listaPetsEncontrados = buscaPorNome(busca, listaPetsEncontrados);
        }

        if (opcaoBusca1 == 2 || opcaoBusca2 == 2) {

            System.out.println("Você deseja buscar: (1 - Macho / 2 - Femea)");
            int opcaoSexo = validacao.validarNumero(sc);

            SexoPet sexoPet;

            if (opcaoSexo == 1) {
                sexoPet = SexoPet.MACHO;
            } else if (opcaoSexo == 2) {
                sexoPet = SexoPet.FEMEA;
            } else {
                System.out.println("Opção inválida.");
                return;
            }

            listaPetsEncontrados = listaPetsEncontrados.stream()
                    .filter(pet -> pet.getSexoPet() == sexoPet)
                    .toList();
        }

        if (opcaoBusca1 == 3 || opcaoBusca2 == 3) {

            System.out.println("Digite a idade do pet: ");
            double idadeBuscada = validacao.validarNumero(sc);

            listaPetsEncontrados = buscaPorIdade(idadeBuscada, listaPetsEncontrados);
        }

        formatarBusca(listaPetsEncontrados);
    }

    public void formatarBusca(List<Pet> resultados) {
    	System.out.println("Resultados da busca:");	
    	System.out.println("-----------------------------------");
        if (resultados == null || resultados.isEmpty()) {
            System.out.println("Nenhum pet encontrado!");
            return;
        }

        int cont = 1;

        for (Pet pet : resultados) {

            System.out.println(String.format(
                    "%d - %s, %s, %s, %s, %.1f anos, %.1f kg, raça: %s",
                    cont++,
                    pet.getNomeCompleto(),
                    pet.getTipoPet(),
                    pet.getSexoPet(),
                    pet.getEndereco().getRua() + ", "
                            + pet.getEndereco().getNumero() + ", "
                            + pet.getEndereco().getCidade(),
                    pet.getIdade(),
                    pet.getPeso(),
                    pet.getRaca()
            ));
        }
        System.out.println("-----------------------------------");
    }

    public void exibirResultados() {
        formatarBusca(buscarPet());
    }
}