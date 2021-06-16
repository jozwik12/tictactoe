package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

	public static void main(String[] args) {
		
		char[][] board = {	{' ','|',' ','|',' '},
							{'-','+','-','+','-'},
							{' ','|',' ','|',' '},
							{'-','+','-','+','-'},
							{' ','|',' ','|',' '}
		};
		printBoard(board);
		
		
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
		System.out.println("Pick a number 1-9 corresponding to spot on the board");
		switch(input.nextInt()) {
			case 1:
				board[0][0] = 'X';
			break;
			case 2:
				board[0][2] = 'X';
			break;
			case 3:
				board[0][4] = 'X';
			break;
			case 4:
				board[2][0] = 'X';
			break;
			case 5:
				board[2][2] = 'X';
			break;
			case 6:
				board[2][4] = 'X';
			break;
			case 7:
				board[4][0] = 'X';
			break;
			case 8:
				board[4][2] = 'X';
			break;
			case 9:
				board[4][4] = 'X';
			break;
			default:
				System.out.println("Pick a proper number from range 1-9");
			break;
		}
		printBoard(board);
		}
		
		
	}

//	Iterates over every board element to print the board
	public static void printBoard(char[][] board) {
		for (char[] c1 : board) {
			for (char c2 : c1) {
				System.out.print(c2);
			}
			System.out.println();
		}
	}	
}
