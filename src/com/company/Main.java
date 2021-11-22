package com.company;

import java.util.*;

public class Main {

    // lista de todos os contatos
    public static Map<Integer, List<String>> listaDeContatos = new HashMap<Integer, List<String>>();

    // controlador do auto incremento dos contatos
    public static int idAutoIncrement = 1;

    //começo da classe menu
    // criamos um menu porque assim fica mais organizado dividir oq é função do menu e do sitema das funções auxiliares
    class Menu{

        //mostrar mensgaem de boas vindas
        static void printWelcomeMsg(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("=-=-=-= Sistema de Controle de Agendas =-=-=-=");
            breakLine(1);
            System.out.println("Seja bem vindo ao nosso sistema!");
            breakLine(1);

        }

        // mostrar mensagem para operação inválida
        static void notFoundOperationMessage(){
            breakLine(1);
            System.out.println("XXX Por favor, digite uma operação válida! XXX");
        }

        // mostrar mensagem de adeus
        static void printByeMsg(){
            breakLine(1);
            System.out.println("Até mais!");
        }

        //mostrar operações iniciais
        static void printInitialOperations(){
            breakLine(1);
            System.out.println(
                    "+----------------------------------+\n" +
                    "|    >>> Operações iniciais <<<    |\n" +
                    "+----------------------------------+\n" +
                    "| (1) - Para Listar contatos       |\n" +
                    "| (2) - Para Adicionar um contato  |\n" +
                    "| (3) - Para Deletar um contato    |\n" +
                    "| (4) - Para Alterar um contato    |\n" +
                    "| (5) - Para Sair                  |\n" +
                    "+----------------------------------+\n"
            );
            System.out.println("Digite a operação abaixo :");
            System.out.print("❯ ");
        }

        // capturar a operação digitada e lançar a função respectiva
        static void catchTheOperation(int operation){
            switch (operation){
                case 1:
                    listarContatosOperation();
                    break;
                case 2:
                    addContatoOperation();
                    break;
                case 3:
                    deletarContatoOperation();
                    break;
                case 4:
                    alterarContatoOperation();
                    break;
                case 5:
                    printByeMsg();
                    break;
                default:
                    notFoundOperationMessage();
                    break;

            }
        }

       // iniciar o menu
        static void startedMenu(){
            Scanner scanner = new Scanner(System.in);

            //atributo de estado do menu(ligado ou nao)
            boolean systemOn = true;

            do{
                // variavel auxiliar para controle das operacoes
                int systemOperation = 0;

                // print the operations
                printInitialOperations();

                // checar se o numero digitado é um inteiro
                checkNumberPressedIsAInteger(scanner);

                // pegar a operação e mandar a função resposta
                systemOperation = scanner.nextInt();
                Menu.catchTheOperation(systemOperation);

                // caso o usuário digite 5 para sair
                if (systemOperation==5)
                    //colocando que o sistema esta desligado para sair do while
                    systemOn=false;
            // condição para sair
            }while (systemOn);

        }

        //função para adicionar um contato
        static void addContatoOperation(){
            Scanner scanner = new Scanner(System.in);
            List<String> dadosContato = new ArrayList<>();

            breakLine(5);
            System.out.println("=-=-=-= ADICIONAR UM CONTATO =-=-=-=");
            breakLine(1);

            //pegando o nome
            System.out.println("Digite o nome: ");
            System.out.print("❯ ");
            //chamando função para checar se o dado está vazio
            String nome = checkScannerValueIsEmpty();

            //pegando o telefone
            System.out.println("Digite o telefone: ");
            System.out.print("❯ ");
            //checando se o dado esta vazio
            String telefone =checkScannerValueIsEmpty();

            //pegando o telefone
            System.out.println("Digite o email: ");
            System.out.print("❯ ");
            //checando se o dado esta vazio
            String email = checkScannerValueIsEmpty();

            //adicionando campos/variaveis a uma array(List) que vai lidar com todos os dados de um usuario
            dadosContato.add(nome);
            dadosContato.add(telefone);
            dadosContato.add(email);

            //colocando os dados/Array do usuario e respectivo id
            listaDeContatos.put(idAutoIncrement,dadosContato);
            //fazendo auto incremento do id
            idAutoIncrement++;

            breakLine(10);
            System.out.println(">> CONTATO ADICIONADO COM SUCESSO!");

        }

        //listando todos os contatos
        static void listarContatosOperation(){

            breakLine(5);
            System.out.println("=-=-= Lista de Contatos =-=-=");
            breakLine(1);
            //pegando o numero de contatos do map/lista de contatos
            System.out.println("Quantidade de contatos: ["+listaDeContatos.size()+"]");

           //checando se a lista de constatos esta vazia
            if(listaDeContatos.isEmpty()){
                System.out.println(">> NENHUM CONTATO ADICIONADO <<");
            }else{

                // pegando todos as chaves de acesso aos mapas(maps)
                Iterator<Integer> keysListaDeContatos = listaDeContatos.keySet().iterator();

                // usando iterador para navegar dentro do array de chaves
                while (keysListaDeContatos.hasNext()) {
                    //pegando a lista de contato proxima, caso seja a primeira ela msm
                        Integer key = keysListaDeContatos.next();
                        //puxando os dados da lista do contato com sua respectiva chave
                        String linha= "ID: "+key
                                +" - Nome: "+listaDeContatos.get(key).get(0)
                                +" - Telefone:"+listaDeContatos.get(key).get(1)
                                +" - Email: "+listaDeContatos.get(key).get(2);

                        //printando a string com a linha do contato
                        System.out.println(linha);
                }

            }
        }

        // alterando um contato
        static void alterarContatoOperation(){
            Scanner scanner = new Scanner(System.in);
            //variavel auxiliar para receber o id do contato
            int contatoID = 0;

            breakLine(5);
            System.out.println("=-=-= Alterar um contato =-=-=");
            breakLine(1);

            //vendo se a lista de contato esta vazia
            if(listaDeContatos.isEmpty()){
                System.out.println(">> NENHUM CONTATO ADICIONADO <<");
            }else{

                System.out.println("Digite o ID do contato :");
                System.out.print("❯ ");

                // checando se o numero digitado é um inteiro
                checkNumberPressedIsAInteger(scanner);
                contatoID =  scanner.nextInt();

                //vendo se aquela chave/id digitado existe na lista
                if (listaDeContatos.containsKey(contatoID)){
                    //varivavel tipo lista que vai receber os contatos
                    List<String> dadosContato = new ArrayList<>();

                    breakLine(1);
                    System.out.println(">>> ADICIONE OS NOVOS DADOS <<<");
                    breakLine(1);

                    System.out.println("Digite o novo nome: ");
                    System.out.print("❯ ");
                    //checar se o digitado esta vazio
                    String nome = checkScannerValueIsEmpty();

                    System.out.println("Digite o novo telefone: ");
                    System.out.print("❯ ");
                    //checar se o digitado esta vazio
                    String telefone =checkScannerValueIsEmpty();

                    System.out.println("Digite o novo email: ");
                    System.out.print("❯ ");
                    //checar se o digitado esta vazio

                    String email = checkScannerValueIsEmpty();

                    //adicionando novos campos a um novo arraylista
                    dadosContato.add(nome);
                    dadosContato.add(telefone);
                    dadosContato.add(email);

                    //colocando o array dos campos na posicao relativa ao id digitado
                    listaDeContatos.put(contatoID,dadosContato);

                    breakLine(10);
                    System.out.println(">> CONTATO ALTERADO COM SUCESSO!");

                }else{
                    System.out.println(">> NÃO EXISTE NENHUM CONTATO COM ESSE ID <<");
                }

            }

        }

        //função para deletar um contato
        static void deletarContatoOperation(){
            Scanner scanner = new Scanner(System.in);
            //variavel auxiliar que vai receber o id do contato
            int contatoID = 0;

            breakLine(5);
            System.out.println("=-=-= Deletar um contato =-=-=");
            breakLine(1);

            //checando se a lista esta vazia
            if(listaDeContatos.isEmpty()){
                System.out.println(">> NENHUM CONTATO ADICIONADO <<");
            }else{

                System.out.println("Digite o ID do contato :");
                System.out.print("❯ ");

                //checando se o digitado é um inteiro
                checkNumberPressedIsAInteger(scanner);
                //pegando o dado digitado
                contatoID =  scanner.nextInt();

                //vendo se o id digitado existe na lista
                if (listaDeContatos.containsKey(contatoID)){

                    //remove contato usando a chave(map)/id do contato
                    listaDeContatos.remove(contatoID);

                    breakLine(10);
                    System.out.println(">> CONTATO DELETADO COM SUCESSO!");

                }else{
                    System.out.println(">> NÃO EXISTE NENHUM CONTATO COM ESSE ID <<");
                }

            }
        }

    }//fim da classe menu

    // função auxiliar para quebrar linhas/ printar linhas em branco
    static void breakLine(int numberLineForBreak){
        //for vai printar o numero de linhas em branco passados pelo parametro
        for (int i = 0; i < numberLineForBreak; i++){
            System.out.println();
        }
    }

    // função que checa se um número digitado é um inteiro
    static void checkNumberPressedIsAInteger(Scanner scanner){

        //enquanto não tiver um inteiro ele vai rodar
        while (!scanner.hasNextInt()) {
            System.out.println(">> POR FAVOR, DIGITE UM NÚMERO INTEIRO DENTRO DAS OPERAÇÕES!");
            System.out.print("❯");
            //seguindo para o proximo scanner/pedindo pra digitar de novo
            scanner.next();
        }
    }

    // função que checa se o número digitado está vazio
    static String checkScannerValueIsEmpty(){
        Scanner keyboard = new Scanner(System.in);
        String line = null;
        //enquanto o digitado for uma string vazia continua
        while((line = keyboard.nextLine()).isEmpty()) {

            System.out.println(">> POR FAVOR, NÃO DEIXE O CAMPO VAZIO");
            System.out.print("❯ ");
        }

        //retorna o valor
        return line;
    }

    // persistir os dados do time de desenvolvimento
    static String[][] developerTeamData(){
        //matriz auxiliar que recebe 5 linhas(pra cada pessoa) e 3 colunas( pra cada campo)
        String[][] teamData = new String[5][3];

        //Info João Vitor
        teamData[0][0] = "Nome: João Vitor Monteiro de Araújo";
        teamData[0][1] = "Matrícula: 1-2021221873";
        teamData[0][2] = "Curso: Análise e Desenvolvimento de Sistemas";

        //Info João Pedro
        teamData[1][0] = "Nome: João Pedro Estanislau Correia";
        teamData[1][1] = "Matrícula: 1-2021221151";
        teamData[1][2] = "Curso: Análise e Desenvolvimento de Sistemas";

        //Info Phylyp
        teamData[2][0] = "Nome: Phylyp Cavalcante";
        teamData[2][1] = "Matrícula: 1-2021221448";
        teamData[2][2] = "Curso: Sistema de Informação";

        //info Rafael
        teamData[3][0] = "Nome: Rafael Teles Portela Policarpo";
        teamData[3][1] = "Matrícula: 1-2021221183";
        teamData[3][2] = "Curso: Análise e Desenvolvimento de Sistemas";

        //Info Wilson
        teamData[4][0] = "Nome: Wilson Costa de Castro";
        teamData[4][1] = "Matrícula: 1-2021221251";
        teamData[4][2] = "Curso: Sistema de Informação";

        //retornando os dados do time de desenvolvimento
        return teamData;
    }

    //mostrar as informações do time de desenvolvimento
    static void teamInfo(){

        breakLine(1);
        System.out.println("=-=-=-=-=-= INFORMAÇÕES DA EQUIPE =-=-=-=-=-=");
        breakLine(1);

        //Matriz auxiliar para receber os dados e mostra-los
        String[][] infoOfDevelopers = developerTeamData();

        //pega o numero de linhas
        int numberOfRows= infoOfDevelopers.length;
        //pega o numero de colunas
        int numberOfColumns = infoOfDevelopers[0].length;

        //primeira for vai roda as listas
        for (int rows =0; rows < numberOfRows;rows++){
            //segundo for roda as colunas da lista
            for (int columns=0; columns < numberOfColumns;columns++){
                System.out.println(infoOfDevelopers[rows][columns]);
            }
            breakLine(1);
        }

    }

    // MAIN METHOD
    public static void main(String[] args) {

        // printar informações do time
        teamInfo();

        // printar mensagem de boas vindas
        Menu.printWelcomeMsg();

        // menu ligado
       Menu.startedMenu();

    }
}
