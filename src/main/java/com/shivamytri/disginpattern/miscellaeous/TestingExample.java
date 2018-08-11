package com.shivamytri.disginpattern.miscellaeous;

public class TestingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] { 0, 1, 0, 1, 1 };
		System.out.println(TestingExample.solution(input));
		System.out.println(TestingExample.solutionTwo(input));

	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		int count = 0;
		int[] temp = new int[A.length];
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i + 1] == 1) {
				count++;
				temp[i] = count;
			} else {
				temp[i] = count;
			}
		}

		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				ans = ans + temp[i];
			}
		}
		return ans;
	}

	public static int solutionTwo(int[] A) {
		// write your code in Java SE 8
		int ans = 0;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				count += 1;
			} else {
				ans = ans + count;
			}
		}
		return ans;
	}
}
