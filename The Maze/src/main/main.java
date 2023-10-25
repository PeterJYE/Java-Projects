package main;

import java.util.Arrays;

import Support.LinkQueue;
import Support.Node;
import Support.QueueUnderflowException;

public class main {

	public static void main(String[] args) throws QueueUnderflowException {
		// TODO Auto-generated method stub
		int[][] example = { { 2, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 9, 0, 0, 1, 1, 1, 1 }, };
		PrintEx(example);
		Solve(example);

	}

	public static void Solve(int[][] ex) throws QueueUnderflowException {
		LinkQueue m = new LinkQueue();
		int curr = ex[0][0];
		int i = 0;
		int j = 0;
		m.enqueue(curr);
		while (!(curr == 9)) {
			m.dequeue();
			if (Checkr(ex, i, j) == 0) {
				i++;
				curr = ex[i][j];
				m.enqueue(curr);
				ex[i][j] = 3;
				PrintEx(ex);
			}
			if (Checkb(ex, i, j) == 0) {
				j++;
				curr = ex[i][j];
				m.enqueue(curr);
				ex[i][j] = 3;
				PrintEx(ex);
			}
			if (Checkb(ex, i, j) == 1) {
				break;
			}
			if (Checkl(ex, i, j) == 0) {
				i++;
				curr = ex[i][j];
				m.enqueue(curr);
				ex[i][j] = 3;
				PrintEx(ex);
			}
			if (Checkl(ex, i, j) == 1) {
				break;
			}
			if (Checkt(ex, i, j) == 0) {
				j++;
				curr = ex[i][j];
				m.enqueue(curr);
				ex[i][j] = 3;
				PrintEx(ex);
			}
			if (Checkt(ex, i, j) == 1) {
				break;
			}
		
		}
	}

	public static int Checkr(int[][] ex, int i, int j) {
		if (i < ex[0].length) {
			i++;
			if (ex[i][j] == 0) {
				return 0;
			}
			if (ex[i][j] == 9) {
				return 1;
			}
		}
		return -1;
	}

	public static int Checkb(int[][] ex, int i, int j) {
		if (j < ex.length) {
			j++;
			if (ex[i][j] == 0) {
				return 0;
			}
			if (ex[i][j] == 9) {
				return 1;
			}
		}
		return -1;
	}
	public static int Checkl(int[][] ex, int i, int j) {
		if (i >0) {
			i--;
			if (ex[i][j] == 0) {
				return 0;
			}
			if (ex[i][j] == 9) {
				return 1;
			}
		}
		return -1;
	}

	public static int Checkt(int[][] ex, int i, int j) {
		if (j >0) {
			j--;
			if (ex[i][j] == 0) {
				return 0;
			}
			if (ex[i][j] == 9) {
				return 1;
			}
		}
		return -1;
	}

	public static void PrintEx(int[][] ex) {
		for (int[] row : ex) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("---------");

	}
}
