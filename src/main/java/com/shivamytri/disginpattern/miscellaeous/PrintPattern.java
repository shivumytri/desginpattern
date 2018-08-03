package com.shivamytri.disginpattern.miscellaeous;

import java.util.Scanner;

public class PrintPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] mat = new int[2 * n - 1][2 * n - 1];
		int startRow = 0, endRow = 2 * n - 2, startCol = 0, endCol = 2 * n - 2;
		int num = n;
		while (startRow <= endRow && startCol <= endCol) {

			for (int i = startCol; i <= endCol; i++) {
				mat[startRow][i] = num;
			}

			startRow++;
			for (int i = startRow; i <= endRow; i++) {
				mat[i][endCol] = num;
			}

			endCol--;
			for (int i = endCol; i >= startCol; i--) {
				mat[endRow][i] = num;
			}
			
			endRow--;
			for (int i = endRow; i >= startRow; i--) {
				mat[i][startCol] = num;
			}
			
			startCol++;
			num--;
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
