/**
 * 
 */
package arrays.easy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * CodingNinjas: Subset Sum
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/subset-sum_3843086
 * 
 * TC: O(2^n)
 * SC: O(2^n)
 * 
 */
public class P7_Arrays_Get_All_Subset_Sums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		ArrayList<Integer> sums = subsetSum(nums);
		System.out.println(sums);
	}

	private static ArrayList<Integer> subsetSum(int num[]) {
		ArrayList<Integer> subsetSums = new ArrayList<Integer>();
		subsetSumHelper(num, subsetSums, 0, 0);
		Collections.sort(subsetSums);
		return subsetSums;
	}

	private static void subsetSumHelper(int[] num, ArrayList<Integer> subsetSums, int currentSum, int index) {
		if (index == num.length) {
			subsetSums.add(currentSum);
			return;
		}
		// include
		subsetSumHelper(num, subsetSums, currentSum + num[index], index + 1);
		// not include
		subsetSumHelper(num, subsetSums, currentSum, index + 1);
	}

}
