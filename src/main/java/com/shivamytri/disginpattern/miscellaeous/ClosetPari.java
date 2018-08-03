package com.shivamytri.disginpattern.miscellaeous;

public class ClosetPari {

	public static void printClosest(int arr[], int size, int x) {

		int l = 0, r = size - 1, diff = Integer.MAX_VALUE;
		int res_l = 0, res_r = 0;

		while (r > l) {
			if (Math.abs(arr[l] * arr[r] - x) < diff) {
				res_l = l;
				res_r = r;
				diff = Math.abs(arr[l] * arr[r] - x);
			}

			if (arr[l] * arr[r] > x)
				r--;
			else
				l++;
		}
		System.out.println(arr[res_l] + " - " + arr[res_r]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 5, 9 }, x = 8;
		int n = arr.length;
		printClosest(arr, n, x);
	}

}
