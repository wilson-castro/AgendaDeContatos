package com.company;

import java.util.*;

public class Main {

    // List of all Contatos
    public static Map<Integer, List<String>> listaDeContatos = new HashMap<Integer, List<String>>();

    // id contato increment controller
    public static int idAutoIncrement = 0;

    class Menu{

        //show the welcome message
        static void printWelcomeMsg(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("=-=-=-= Sistema de Controle de Agendas =-=-=-=");
            breakLine(1);
            System.out.println("Seja bem vindo ao nosso sistema!");
            breakLine(1);

        }

        // message for invalid operations
        static void notFoundOperationMessage(){
            breakLine(1);
            System.out.println("XXX Por favor, digite uma operação válida! XXX");
        }

        //show the bye message
        static void printByeMsg(){
            breakLine(1);
            System.out.println("Até mais!");
        }

        //show the initial operations
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

        // capture the operation and send the response function
        static void catchTheOperation(int operation){

            switch (operation){
                case 1:
                    listarContatosOperation();
                    break;
                case 2:
                    addContatoOperation();
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    printByeMsg();
                    break;
                default:
                    notFoundOperationMessage();
                    break;

            }
        }

        static void startedMenu(){
            Scanner scanner = new Scanner(System.in);

            // atribute status menu
            boolean systemOn = true;

            do{
                int systemOperation = 0;

                // print the operations
                printInitialOperations();

                // check if a integer value digited
                checkNumberPressedIsAInteger(scanner);

                // catch the key pressed and send the operation
                systemOperation = scanner.nextInt();
                Menu.catchTheOperation(systemOperation);

                // if user quit
                if (systemOperation==5)
                    systemOn=false;

            }while (systemOn);

        }

        static void addContatoOperation(){
            Scanner scanner = new Scanner(System.in);
            List<String> dadosContato = new ArrayList<>();

            breakLine(5);
            System.out.println("=-=-=-= ADICIONAR UM CONTATO =-=-=-=");
            breakLine(1);

            System.out.println("Digite o nome: ");
            System.out.print("❯ ");
            String nome = checkScannerValueIsEmpty();

            System.out.println("Digite o telefone: ");
            System.out.print("❯ ");
            String telefone =checkScannerValueIsEmpty();

            System.out.println("Digite o email: ");
            System.out.print("❯ ");
            String email = checkScannerValueIsEmpty();

            dadosContato.add(nome);
            dadosContato.add(telefone);
            dadosContato.add(email);

            listaDeContatos.put(idAutoIncrement,dadosContato);
            idAutoIncrement++;

            breakLine(10);
            System.out.println(">> CONTATO ADICIONADO COM SUCESSO!");

        }

        static void listarContatosOperation(){

            breakLine(5);
            System.out.println("=-=-= Lista de Contatos =-=-=");
            breakLine(1);
           System.out.println("Quantidade de contatos: ["+listaDeContatos.size()+"]");

            if(listaDeContatos.isEmpty()){
                System.out.println(">> NENHUM CONTATO ADICIONADO <<");
            }else{
               for(int i=0 ; i<listaDeContatos.size(); i++){
                   String linha= "ID: "+i
                           +" - Nome: "+listaDeContatos.get(i).get(0)
                           +" - Telefone:"+listaDeContatos.get(i).get(1)
                           +" - Email: "+listaDeContatos.get(i).get(2);

                   System.out.println(linha);
               }

            }
        }

    }

    // function for break many lines
    static void breakLine(int numberLineForBreak){
        for (int i = 0; i < numberLineForBreak; i++){
            System.out.println();
        }
    }

    static void checkNumberPressedIsAInteger(Scanner scanner){
        while (!scanner.hasNextInt()) {
            System.out.println(">> POR FAVOR, DIGITE UM NÚMERO INTEIRO DENTRO DAS OPERAÇÕES!");
            System.out.print("❯");
            scanner.next();
        }
    }

    static String checkScannerValueIsEmpty(){
        Scanner keyboard = new Scanner(System.in);
        String line = null;

        while((line = keyboard.nextLine()).isEmpty()) {

            System.out.println(">> POR FAVOR, NÃO DEIXE O CAMPO VAZIO");
            System.out.print("❯ ");
        }

        return line;
    }

    // persist data of develper team
    static String[][] developerTeamData(){
        String[][] teamData = new String[5][3];

        //Info João Vitor
        teamData[0][0] = "Nome: João Vitor Monteiro de Araújo";
        teamData[0][1] = "Matrícula: 1-2021221873";
        teamData[0][2] = "Curso: Análise e Desenvolvimento de Sistemas";

        //Info João Pedro
        teamData[1][0] = "Nome: Jp";
        teamData[1][1] = "Matrícula: ";
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

        return teamData;
    }

    // Print informations for the team
    static void teamInfo(){

        breakLine(1);
        System.out.println("=-=-=-=-=-= INFORMAÇÕES DA EQUIPE =-=-=-=-=-=");
        breakLine(1);

        String[][] infoOfDevelopers = developerTeamData();

        int numberOfRows= infoOfDevelopers.length;
        int numberOfColumns = infoOfDevelopers[0].length;

        for (int rows =0; rows < numberOfRows;rows++){
            for (int columns=0; columns < numberOfColumns;columns++){
                System.out.println(infoOfDevelopers[rows][columns]);
            }
            breakLine(1);
        }

    }


    // MAIN METHOD
    public static void main(String[] args) {

        // print info of the team
        teamInfo();

        // print welcome menssage
        Menu.printWelcomeMsg();

        // menu on
       Menu.startedMenu();

    }
}
