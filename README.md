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


### ⚠️ Regras

1. O usuário não poderá utilizar `0` ou números negativos.  
2. Caso o usuário digite um número inválido, o menu deverá ser exibido novamente.  
3. O usuário poderá digitar apenas números, não sendo permitido letras ou caracteres especiais.  

## 📍 Passo 3: Cadastro de Novos Pets 📝

O usuário, ao selecionar a opção 1, deve ser capaz de cadastrar um novo pet. Neste momento, você deverá ler as **PERGUNTAS** do arquivo `formulario.txt` e armazenar as respostas em um objeto do tipo `Pet`.


### ⚠️ Regras

1. O usuário obrigatoriamente deverá cadastrar um pet com **nome e sobrenome**, caso contrário, deverá ser lançada uma exceção.  

2. O nome completo **não poderá conter caracteres especiais**, sendo permitido apenas letras de **A-Z**.  

3. Para os campos **TIPO** e **SEXO** do pet, deverá ser utilizado `ENUM`.  

4. Na pergunta sobre o endereço, o sistema deverá solicitar:
   - Número da casa  
   - Cidade  
   - Rua  

5. Na idade e peso aproximados do pet, o usuário poderá digitar números com vírgulas ou ponto, mas somente números.
6. Caso o usuário digite um peso maior que 60kg ou um peso menor que 0.5kg, lance uma exceção.
7. Caso o usuário digite uma idade maior que 20 anos, lance uma exceção.
8. Caso o usuário digite uma idade menor que 1 ano (idade em meses), transforme em 0.x anos.
9. No campo raça o usuário não poderá usar números nem caracteres especiais.
10. Nas perguntas sobre NOME, RAÇA, PESO, IDADE e ENDEREÇO (somente o campo número), caso o usuário NÃO INFORME ou deixe em branco, você deverá preencher com NÃO INFORMADO (deve ser uma constante)!

## 📍Passo 4: Armazenamento em Arquivo 📂
Agora, ao salvar o PET em um objeto, você deverá salvar as respostas em um arquivo `.txt` com o nome formatado da seguinte maneira:

`20231101T1234-FLORZINHADASILVA.TXT.`

### Regras ⚠️
1. O nome do arquivo deverá seguir o formato: ano, mês, dia,T, hora, minuto - NOME+SOBRENOME em maiúsculo.
2. O arquivo deverá ser salvo na pasta `petsCadastrados` na raiz do projeto.
3. O conteúdo do arquivo deverá conter TODAS AS RESPOSTAS POR LINHA, ou seja, cada resposta deverá estar em uma linha diferente.
4. O campo endereço deverá ser salvo todo na mesma linha.
5. O arquivo somente conterá RESPOSTAS, PERGUNTAS NÃO!

Exemplo de arquivo salvo:

```
1 - Florzinha da Silva
2 - Gato
3 - Femea
4 - Rua 2, 456, Seilandia
5 - 6 anos
6 - 5kg
7 - Siames
```
