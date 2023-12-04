/**
 * 
 */
package arrays.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Largest Element in the Array
 * 
 * Link: https://www.codingninjas.com/studio/problems/largest-element-in-the-array-largest-element-in-the-array_5026279
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P1_Arrays_Find_Largest_Element {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 5, 9, 3, 4, 8, 4, 3, 10 };
		int largest = largestElement(nums, nums.length);
		System.out.println("Largest element in " + Arrays.toString(nums) + " is : " + largest);
	}

	private static int largestElement(int[] arr, int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

}
