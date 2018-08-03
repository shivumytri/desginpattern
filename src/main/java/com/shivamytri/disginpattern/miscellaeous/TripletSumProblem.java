package com.shivamytri.disginpattern.miscellaeous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TripletSumProblem {

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> pair = new ArrayList<>();
		Set<String> uniqPairCheckSet = new TreeSet();
		List<Integer> cur_triplets = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == 0) {
					String str = nums[i] + ":" + nums[l] + ":" + nums[r];
					if (!uniqPairCheckSet.contains(str)) {
						cur_triplets.add(nums[i]);
						cur_triplets.add(nums[l]);
						cur_triplets.add(nums[r]);
						pair.add(cur_triplets);
						cur_triplets = new ArrayList<>();
						uniqPairCheckSet.add(str);
					}
					l++;
					r--;
				} else if (nums[i] + nums[l] + nums[r] < 0) {
					l++;
				} else {
					r--;
				}

			}
		}

		return pair;
	}

	public static void main(String[] args) {
		int A[] = { -1, 0, 1, 2, -1, -4 };
		int sum = 22;
		int arr_size = A.length;
		System.out.println(threeSum(A));
	}

}
