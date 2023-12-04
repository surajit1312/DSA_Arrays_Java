/**
 * 
 */
package arrays.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Left Rotate an Array by One
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P5_Left_Rotate_Array_By_1_Place {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] rotatedNums = rotateArray(nums, nums.length);
		System.out.println("Rotated array of " + Arrays.toString(nums) + " by single left shift looks like : "
				+ Arrays.toString(rotatedNums));
	}

	private static int[] rotateArray(int[] arr, int n) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int temp = arr[0];
		int i = 1;
		for (i = 1; i < n; i++) {
			arr[i - 1] = arr[i];
		}
		arr[i - 1] = temp;
		return arr;
	}

}
