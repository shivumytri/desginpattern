package com.shivamytri.disginpattern.miscellaeous;

public class RoatationofArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3, 8, 9, 7, 6};
		int k = 3;
		for (int j = 0; j <= k - 1; j++) {
		//	System.out.println(j);
			int i, temp = a[a.length -1];
			for (i = a.length - 1; i > 0; i--) {
				System.out.println(i);
				a[i] = a[i - 1];
			}
			a[0] = temp;
			for(i=0;i<a.length;i++) {
				System.out.print(a[i]);
			}
		}
		
		
	}

}
