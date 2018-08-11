package com.shivamytri.disginpattern.miscellaeous;

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {1,3,4,5,6};
		
		System.out.println(Arrays.toString(CyclicRotation.solution(input, 3)));	
	
	}

	public static int[] solution(int[] A, int K) {
		int len = A.length;
		for (int i = 0; i < K; i++) {			
			if (len != 0) {
				int temp = A[len - 1];
				for (int j = len - 1; j > 0; j--) {
					A[j] = A[j - 1];
				}
				A[0] = temp;
			}

		}
		return A;
	}
}
