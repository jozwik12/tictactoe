package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Computer comp = new Computer();
        Player player = new Player();

        System.out.println("Pick who goes first");
        System.out.println("1 - you");
        System.out.println("2 - computer");
        String choice = input.next();

        //choosing who gets first move
        //loops if input is neither 1 nor 2
        do {
            switch (choice) {
                case "1": //player gets additional round as first one
                    player.Turn();
                    break;
                case "2": //computer gets 1st move as in later code
                    break;
                default:
                    System.out.println("Please select proper input");
                    choice = input.next();
            }
        } while (!(choice.equals("1") || choice.equals("2")));

/*
      main playing loop
      breaks when someone wins or there is a tie
*/
        while (!Board.checkIfPlayerWon() && !Board.checkIfComputerWon()) {
                comp.Turn();
                if (Board.isBoardFull() || Board.checkIfComputerWon()) break;
                player.Turn();
                if (Board.isBoardFull() || Board.checkIfPlayerWon()) break;
            }

        if (Board.checkIfPlayerWon()){
            System.out.println();
            System.out.println("***********");
            System.out.println("  YOU WON  ");
            System.out.println("***********");
        } else if (Board.checkIfComputerWon()){
            System.out.println();
            System.out.println("***********");
            System.out.println("  YOU SUCK ");
            System.out.println("***********");
        } else {
            System.out.println();
            System.out.println("************");
            System.out.println(" It's a TIE ");
            System.out.println("************");
        }
    }
}
