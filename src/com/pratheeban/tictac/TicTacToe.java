package com.pratheeban.tictac;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	private static int row, col;
	private static Scanner scan = new Scanner(System.in);
	private static char[][] board = new char[3][3];
	private static char turn = 'X';

	private static void play() {
		boolean playing = true;
		while (playing) {
			System.out.println("Please enter row and column:");
			row = scan.nextInt() - 1;
			col = scan.nextInt() - 1;
			board[row][col] = turn;
			if (gameOver(row, col)) {
				playing = false;
				System.out.println("Game over! Player " + turn + " wins!");
			}
			printBoard();
			if (turn == 'X') {
				turn = 'O';
			} else {
				turn = 'X';
			}
		}
	}

	private static void printBoard() {
		for (int i = 0; i < board.length; i++) {
			System.out.println();
			for (int j = 0; j < board.length; j++) {
				if (j == 0)
					System.out.print("| ");
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}

	private static boolean gameOver(int rMove, int cMove) {
		// Check vertical victory
		if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) {
			return true;
		}
		// Check horizontal victory
		if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2]) {
			return true;
		}
		// Check diagonal victory
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
			return true;
		}
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}
		printBoard();
		play();
	}
}
