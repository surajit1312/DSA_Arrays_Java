/**
 * 
 */
package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * CodingNinjas: Rotate array by k places
 * 
 * Link: https://www.codingninjas.com/studio/problems/rotate-array_1230543
 * 
 * TC: O(n)
 * SC: O(n)
 */
public class P6_Left_Rotate_Array_By_K_Places {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 3, 4, 5 };
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(nums));
		int k = 4;
		ArrayList<Integer> rotatedNums = rotateArray(arr, k);
		System.out.println(
				"Rotated array of " + Arrays.toString(nums) + " by " + k + " left shifts looks like : " + rotatedNums);
	}

	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
		int n = arr.size();
		if (arr == null || n == 0) {
			return arr;
		}
		k = k % n;
		ArrayList<Integer> rotatedPortion = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			rotatedPortion.add(arr.get(i));
		}
		for (int i = k; i < n; i++) {
			arr.set(i - k, arr.get(i));
		}
		for (int i = 0; i < rotatedPortion.size(); i++) {
			arr.set(n - k + i, rotatedPortion.get(i));
		}
		return arr;
	}

}
