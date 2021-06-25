package tictactoe;

import java.util.Random;

public class Computer extends Behaviour{

    @Override
    void Turn() {
        symbol = 'O';
        Random rand = new Random();
        System.out.println("-------------------------------------------------------");
        System.out.println("Move by computer:");
        int position;
        do {
            position = rand.nextInt(9)+1;
        } while(Board.checkIfPlaceOnBoardTaken(position));

        Board.putCharacterOntoBoard(position, symbol);
        Board.printBoard();
    }
}
