package com.shivamytri.disginpattern.miscellaeous;

import java.util.Arrays;

public class MaxInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxInteger maxInt= new MaxInteger();
		System.out.println(Arrays.toString(maxInt.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
		System.out.println(Arrays.toString(maxInt.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
		System.out.println(Arrays.toString(maxInt.solution(1, new int[] { 2, 1, 1, 2, 1 })));
	}
	
	public int[] solution(int N, int[] A) {
        // write your code in Java SE 
       /* int[] counter = new int[N];
        int max=-1;
        for(int i=0;i<A.length;i++){
            
            if(A[i] <= N){
                counter[A[i]-1] = counter[A[i]-1] + 1;
            } else if(A[i] == N+1) {
                
                for(int j=0;j<N;j++){
                    if(counter[j] >= max)
                        max =  counter[j];
                }
                
                for(int j=0;j<N;j++){
                    counter[j] = max;
                }
                
                max=-1;
            }
        }
        return counter;*/
		int max = 0;
		int lastMax = 0;
		int[] counters = new int[N];

		for (int k = 0; k < A.length; k++) {
			if (A[k] >= 1 && A[k] <= N) {
				// this is instead of the nested loop in solution2
				counters[A[k] - 1] = Math.max(counters[A[k] - 1], lastMax);
				counters[A[k] - 1] += 1;
				max = Math.max(max, counters[A[k] - 1]);
			} else if (A[k] == N + 1) {
				lastMax = max;
			}
		}
		
		for(int i = 0 ; i < counters.length; i++) {
			counters[i] = Math.max(counters[i], lastMax);
		}

		return counters;
    }

}
