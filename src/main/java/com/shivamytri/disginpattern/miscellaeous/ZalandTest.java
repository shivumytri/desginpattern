package com.shivamytri.disginpattern.miscellaeous;

public class ZalandTest {

	/*
	 * Utility function that puts all non-positive (0 and negative) numbers on left
	 * side of arr[] and return count of such numbers
	 */
	static int segregate(int arr[], int size) {
		int j = 0, i;
		for (i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}

		return j;
	}

	/*
	 * Find the smallest positive missing number in an array that contains all
	 * positive integers
	 */
	static int findMissingPositive(int arr[], int size) {

		for (int i = 0; i < size; i++) {
			if (Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0) {
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			}
		}

		for (int j = 0; j < size; j++) {
			if (arr[j] > 0)
				return j + 1;
		}
		return size + 1;
	}

	/*
	 * Find the smallest positive missing number in an array that contains both
	 * positive and negative integers
	 */
	static int findMissing(int arr[], int size) {
		int j = 0;
		int shift = segregate(arr, size);
		int[] arr2 = new int[size - shift];

		for (int i = shift; i < size; i++) {
			arr2[j] = arr[i];
			j++;
		}

		return findMissingPositive(arr2, j);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 4, 1, 2 };
		int arr_size = arr.length;
		int missing = findMissing(arr, arr_size);
		System.out.println("The smallest positive missing number is " + missing);

	}

}
