package com.company;

import java.util.Scanner;

public class Main {

    // function for break many lines
    static void breakLine(int numberLineForBreak){
        for (int i = 0; i < numberLineForBreak; i++){
            System.out.println();
        }
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
        teamData[2][0] = "Nome: Phylyp";
        teamData[2][1] = "Matrícula: ";
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
        Scanner scanner = new Scanner(System.in);
        boolean systemOn = true;

        // print info of the team
        teamInfo();

        /*do{


        }while (true);*/

    }
}
