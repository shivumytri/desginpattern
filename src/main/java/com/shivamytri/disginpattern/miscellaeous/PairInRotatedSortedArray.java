package com.shivamytri.disginpattern.miscellaeous;

public class PairInRotatedSortedArray {

	public static boolean pairInRoatedSortedArr(int arr[], int size, int sum) {

		int i;
		for (i = 0; i < size - 1; i++) {
			if (arr[i] > arr[i + 1])
				break;
		}

		int l = (i + 1) % size;
		int r = i;
		while (l != r) {
			if (arr[l] + arr[r] == sum)
				return true;

			if (arr[l] + arr[r] < sum)
				l = (l + 1) % size;
			else
				r = (size + r - 1) % size;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 16;
		int n = arr.length;
		if (pairInRoatedSortedArr(arr, n, sum))
			System.out.print("Array has two elements" + " with sum 16");
		else
			System.out.print("Array doesn't have two" + " elements with sum 16 ");

	}

}
