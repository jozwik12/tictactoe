package tictactoe;

import java.util.Map;

public class Board {

    private static final char[][] board = {	{' ', '|', ' ', '|', ' '},
											{'-', '+', '-', '+', '-'},
            								{' ', '|', ' ', '|', ' '},
											{'-', '+', '-', '+', '-'},
           									{' ', '|', ' ', '|', ' '}
    };

    private static Map<Integer, Position> positions = Map.of(
            1, new Position(0, 0),
            2, new Position(0, 2),
            3, new Position(0, 4),
            4, new Position(2, 0),
            5, new Position(2, 2),
            6, new Position(2, 4),
            7, new Position(4, 0),
            8, new Position(4, 2),
            9, new Position(4, 4)
    );

    private static int amountOfTurns;

    static {
        amountOfTurns = 0;
    }


    //Iterates over every board element to print the board
    public static void printBoard() {
        for (char[] c1 : board) {
            for (char c2 : c1) {
                System.out.print(c2);
            }
            System.out.println();
        }
    }

    //this function simplifies board addressing
    //instead of writing indices everytime
    private static Position boardAddresser(int address) {
        return positions.get(address);
    }

    //checks if there is place on the board, returns false if there is symbol already
    static boolean checkIfPlaceOnBoardTaken(int address) {
    	Position position = boardAddresser(address);
		return board[position.x][position.y] != ' ';
	}

    static void putCharacterOntoBoard(int address, char symbol) {
        amountOfTurns++;
		Position position = boardAddresser(address);
		board[position.x][position.y] = symbol;
    }

    // cVal is short for character value
    // returns ASCII decimal value of character at given position on board
    public static int cVal(int address) {
        Position position = boardAddresser(address);
        return board[position.x][position.y];
    }

    public static boolean checkIfComputerWon() {
        boolean winner = false;
        if (cVal(1) + cVal(2) + cVal(3) == 237) winner = true;
        if (cVal(4) + cVal(5) + cVal(6) == 237) winner = true;
        if (cVal(7) + cVal(8) + cVal(9) == 237) winner = true;
        if (cVal(1) + cVal(4) + cVal(7) == 237) winner = true;
        if (cVal(2) + cVal(5) + cVal(8) == 237) winner = true;
        if (cVal(3) + cVal(6) + cVal(9) == 237) winner = true;
        if (cVal(1) + cVal(5) + cVal(9) == 237) winner = true;
        if (cVal(3) + cVal(5) + cVal(7) == 237) winner = true;
        return winner;
    }

    public static boolean checkIfPlayerWon() {
        boolean winner = false;
        if (cVal(1) + cVal(2) + cVal(3) == 264) winner = true;
        if (cVal(4) + cVal(5) + cVal(6) == 264) winner = true;
        if (cVal(7) + cVal(8) + cVal(9) == 264) winner = true;
        if (cVal(1) + cVal(4) + cVal(7) == 264) winner = true;
        if (cVal(2) + cVal(5) + cVal(8) == 264) winner = true;
        if (cVal(3) + cVal(6) + cVal(9) == 264) winner = true;
        if (cVal(1) + cVal(5) + cVal(9) == 264) winner = true;
        if (cVal(3) + cVal(5) + cVal(7) == 264) winner = true;
        return winner;
    }

    public static boolean isBoardFull() {
        return Board.amountOfTurns == 9;
    }

}
