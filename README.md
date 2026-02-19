# Desafio PROGRAMAÇÃO - Sistema de Cadastros 🚀

## Objetivo
O desafio será criar um sistema de cadastro via CLI (interface de linha de comando), para nossos futuros adotantes poderem escolher o seu animalzinho.

O dono do abrigo de animais que será o usuário do seu programa será capaz de:

- Cadastrar um novo pet
- Buscar dados do pet cadastrado
- Deletar um pet cadastrado
- Listar todos os pets cadastrados
- Listar pets por algum critério (idade, nome, raça)
- E muito mais!

O sistema deve ser implementado utilizando conceitos de Orientação a Objetos e outras boas práticas de programação. 🚀

## Conhecimentos que irei aplicar:
- Orientação a Objetos (OO)
- Manipulação de arquivos e arrays
- Java IO
- Exceções
- Boas práticas de código
- File Systems

## 📍Passo 1 - Leitura do arquivo de base com as perguntas essenciais. 📄
Crie um arquivo chamado `formulario.txt`, que deverá conter as seguintes perguntas:

1 - Qual o nome e sobrenome do pet?

2 - Qual o tipo do pet (Cachorro/Gato)?

3 - Qual o sexo do animal?

4 - Qual endereço e bairro que ele foi encontrado?

5 - Qual a idade aproximada do pet?

6 - Qual o peso aproximado do pet?

7 - Qual a raça do pet?

Sua aplicação deve ler o conteúdo desse arquivo `.txt` e exibir as perguntas no terminal.

Não é permitido usar o "print" nas perguntas no código, você deverá LER o arquivo!

## 📌 Passo 2: Criação do Menu Inicial

Após o arquivo imprimir o conteúdo do `formulario.txt` no terminal, deve ser criado um menu inicial com as seguintes opções:

1. Cadastrar um novo pet  
2. Alterar os dados do pet cadastrado  
3. Deletar um pet cadastrado  
4. Listar todos os pets cadastrados  
5. Listar pets por algum critério (idade, nome ou raça)  
6. Sair  

O menu deve ser exibido no terminal e o usuário deve escolher uma opção digitando o número correspondente.


⚠️ Regras

1. O usuário não poderá utilizar `0` ou números negativos.  
2. Caso o usuário digite um número inválido, o menu deverá ser exibido novamente.  
3. O usuário poderá digitar apenas números, não sendo permitido letras ou caracteres especiais.  

