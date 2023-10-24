package main;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

import support.ArrayStack;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n(at least 4)");
		int n = sc.nextInt();
		String board[][] = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = "_";
			}
		}
		solution(board);
		for (String[] row : board) {
			System.out.println(Arrays.toString(row));
		}

	}

	public static boolean isSafe(String[][] board, int r, int c) {
		for (int i = r; i >= 0; i--) {
			if (board[i][c].equals("Q")) {
				return false;
			}
		}
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}
		for (int i = r, j = c; i < board.length && j >=0; i++, j--) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}
		for (int i = r, j = c; i >=0 && j < board.length; i--, j++) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}

		return true;
	}

	public static void solution(String board[][]) {
		int i = 0;
		int j = 0;

		while (i < board.length) {
			int idx = findSafe(board, i, j);
			if (idx != -1) {
				board[i][idx] = "Q";
				i++;
				j = 0;
			} else {
				i--;
				j = QPosition(board, i) + 1;
			}
		}
	}

	public static int findSafe(String board[][], int i, int c) {
		while (c < board.length) {
			if (isSafe(board, i, c)) {
				return c;
			} else {
				c++;
			}
		}
		return -1;
	}

	public static int QPosition(String board[][], int i) {
		int m = 0;
		for (int j = 0; j < board.length; j++) {
			if (board[i][j].equals("Q")) {
				board[i][j] = "_";
				m = j;
			}
		}
		return m;
	}
}
