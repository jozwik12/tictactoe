package tictactoe;

public class Board {

	private static char[][] board = {	{' ','|',' ','|',' '},
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
	public static boolean checkIfPlacementAvailable(int position) {
		return boardAddresser(position) == ' ';
	}
	
	//this function simplifies board addressing
	//instead of writing indices everytime
	public static char boardAddresser(int position) {
		char result = switch (position) {
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
		return result;
	}

	public static void putCharacterOntoBoard(int position, char symbol) {
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

//	public static boolean checkIfThereIsWinner(){
//		boolean winner = false;
//
//		return winner;
//	}

	public static boolean isBoardPlayable(){
		return Board.amountOfTurns < 9;
	}

	public static int getAmountOfTurns() {
		return amountOfTurns;
	}
}
