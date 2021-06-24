package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Board {

	private static Scanner input = new Scanner(System.in);
	private static char symbol;
	private static boolean playing = true;
	private static char[][] board = {	{' ','|',' ','|',' '},
										{'-','+','-','+','-'},
										{' ','|',' ','|',' '},
										{'-','+','-','+','-'},
										{' ','|',' ','|',' '}};	

	public static void main(String[] args) {
		
		System.out.println("Pick who goes first");
		System.out.println("1 - you");
		System.out.println("2 - computer");
		String turn = input.next();
		
		//loop choosing who gets first move
		while(true) {
			
			switch(turn) {
				case "1": //player gets additional round as first one
					playerTurn();
					break;
				case "2": //computer gets 1st move as in later code
					break;
				default:
					System.out.println("Please select proper input");
					turn = input.next();
			}
				if (turn.equals("1") || turn.equals("2")) {
				break;
			}
		}
		
		
		//main playing loop
		//breaks when someone wins or there is a tie
		while (playing == true) {
			computerTurn();
			playerTurn();
		}
		
				
		
	}

	//Iterates over every board element to print the board
	public static void printBoard(char[][] board) {
		for (char[] c1 : board) {
			for (char c2 : c1) {
				System.out.print(c2);
			}
			System.out.println();
		}
	}	
	
	public static void computerTurn() {
		symbol = 'O';
		Random rand = new Random();
		System.out.println("-------------------------------------------------------");
		System.out.println("Move by computer:");
		putCharacterOntoBoard(rand.nextInt(8)+1);	
		printBoard(board);
		
	}
	
	public static void playerTurn() {
		symbol = 'X';		
		System.out.println("-------------------------------------------------------");
		System.out.println("Pick a number 1-9 corresponding to spot on the board");
		putCharacterOntoBoard(input.nextInt());
		printBoard(board);
	}
	
	//checks if there is place on the board, returns false if there is symbol already
	public static boolean checkIfPlacementAvailable(int position) {
		return boardAdresser(position) == ' ';
	}
	
	//this function simplifies board adressing
	//instead of writing indices everytime
	public static char boardAdresser(int position) {
		char result = 'a';
		switch(position) {
			case 1:
				result = board[0][0];
			case 2:
				result = board[0][2];
			case 3:
				result = board[0][4];
			case 4:
				result = board[2][0];
			case 5:
				result = board[2][2];
			case 6:
				result = board[2][4];
			case 7:
				result = board[4][0];
			case 8:
				result = board[4][2];
			case 9:
				result = board[4][4];
		}
		return result;
	}
	
	public static void putCharacterOntoBoard(int position) {
		switch(position) {
		case 1:
			board[0][0] = symbol;
		case 2:
			board[0][2] = symbol;
		case 3:
			board[0][4] = symbol;
		case 4:
			board[2][0] = symbol;
		case 5:
			board[2][2] = symbol;
		case 6:
			board[2][4] = symbol;
		case 7:
			board[4][0] = symbol;
		case 8:
			board[4][2] = symbol;
		case 9:
			board[4][4] = symbol;
		}
	}

}
