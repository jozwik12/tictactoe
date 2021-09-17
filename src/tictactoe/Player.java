package tictactoe;

import java.util.Scanner;

public class Player extends Behaviour {

    Scanner input = new Scanner(System.in);

    @Override
    void Turn() {
        symbol = 'X';
        System.out.println("-------------------------------------------------------");
        System.out.println("Pick a number 1-9 corresponding to spot on the board");
        int position = askForProperInput();

        while (Board.checkIfPlaceOnBoardTaken(position)) {
            System.out.println("This place is occupied");
            position = askForProperInput();
        }

        Board.putCharacterOntoBoard(position, symbol);
        Board.printBoard();
    }

    int askForProperInput() {

        int position;
        do {
            try {
                position = Integer.parseInt(input.next());
                if (position >= 1 && position <= 9) {
                    break;
                } else {
                    System.out.println("Please select proper input (1-9)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please select proper input (1-9)");
            }
        } while (true);
        return position;
    }
}

