package com.shivamytri.disginpattern.miscellaeous;

public class MatrixZero {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

	
		int rowL = matrix.length;
		int colL =  matrix[0].length;
		MatrixZero.setZeroes(matrix, rowL, colL);
		for (int i = 0; i < rowL; i++) {
			for (int j = 0; j < colL; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix, int rowL, int colL) {

		int[] row = new int[rowL];
		int[] col = new int[colL];

		System.out.println(rowL);
		System.out.println(colL);

		for (int i = 0; i < rowL; i++) {
			// System.out.println("i" + i);

			for (int j = 0; j < colL; j++) {
				// System.out.println("j" + j);
				if (matrix[i][j] == 1) {
					row[i] = 1;
					col[i] = 1;
				}
			}
		}
		for (int i = 0; i < rowL; i++) {
			for (int j = 0; j < colL; j++) {
				if (row[i] == 1 || col[j] == 1) {
					matrix[i][j] = 1;
				}
			}
		}

	}

}
