package tictactoe;

public class Board {

	private static final char[][] board = {	{' ','|',' ','|',' '},
										{'-','+','-','+','-'},
										{' ','|',' ','|',' '},
										{'-','+','-','+','-'},
										{' ','|',' ','|',' '}};
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

//	checks if there is place on the board, returns false if there is symbol already
	static boolean checkIfPlaceOnBoardTaken(int position) {
		return boardAddresser(position) != ' ';
	}
	
	//this function simplifies board addressing
	//instead of writing indices everytime
	private static char boardAddresser(int position) {
		return switch (position) {
			case 1 -> board[0][0];
			case 2 -> board[0][2];
			case 3 -> board[0][4];
			case 4 -> board[2][0];
			case 5 -> board[2][2];
			case 6 -> board[2][4];
			case 7 -> board[4][0];
			case 8 -> board[4][2];
			case 9 -> board[4][4];
			default -> 'a';
		};
	}

	static void putCharacterOntoBoard(int position, char symbol) {
		amountOfTurns++;
		switch (position) {
			case 1 -> board[0][0] = symbol;
			case 2 -> board[0][2] = symbol;
			case 3 -> board[0][4] = symbol;
			case 4 -> board[2][0] = symbol;
			case 5 -> board[2][2] = symbol;
			case 6 -> board[2][4] = symbol;
			case 7 -> board[4][0] = symbol;
			case 8 -> board[4][2] = symbol;
			case 9 -> board[4][4] = symbol;
		}
	}

	// cVal is short for character value
	// returns ASCII decimal value of character at given position on board
	public static int cVal(int position){
		char sym = boardAddresser(position);
		int value = sym;
		return value;
	}

	public static boolean checkIfComputerWon(){
		boolean winner = false;
		if (cVal(1)+cVal(2)+cVal(3)==237) winner = true;
		if (cVal(4)+cVal(5)+cVal(6)==237) winner = true;
		if (cVal(7)+cVal(8)+cVal(9)==237) winner = true;
		if (cVal(1)+cVal(4)+cVal(7)==237) winner = true;
		if (cVal(2)+cVal(5)+cVal(8)==237) winner = true;
		if (cVal(3)+cVal(6)+cVal(9)==237) winner = true;
		if (cVal(1)+cVal(5)+cVal(9)==237) winner = true;
		if (cVal(3)+cVal(5)+cVal(7)==237) winner = true;
		return winner;
	}

	public static boolean checkIfPlayerWon(){
		boolean winner = false;
		if (cVal(1)+cVal(2)+cVal(3)==264) winner = true;
		if (cVal(4)+cVal(5)+cVal(6)==264) winner = true;
		if (cVal(7)+cVal(8)+cVal(9)==264) winner = true;
		if (cVal(1)+cVal(4)+cVal(7)==264) winner = true;
		if (cVal(2)+cVal(5)+cVal(8)==264) winner = true;
		if (cVal(3)+cVal(6)+cVal(9)==264) winner = true;
		if (cVal(1)+cVal(5)+cVal(9)==264) winner = true;
		if (cVal(3)+cVal(5)+cVal(7)==264) winner = true;
		return winner;
	}

	public static boolean isBoardFull(){
		return Board.amountOfTurns == 9;
	}

}
