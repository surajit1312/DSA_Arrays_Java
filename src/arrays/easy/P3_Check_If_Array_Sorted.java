/**
 * 
 */
package arrays.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Check Sorted Array
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/ninja-and-the-sorted-check_6581957
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P3_Check_If_Array_Sorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 4, 5, 4, 4, 4 };
		int isArraySorted1 = isSorted(nums1.length, nums1);
		System.out.println("Is Array " + Arrays.toString(nums1) + " sorted : " + isArraySorted1);

		int[] nums2 = { 4, 7, 9, 11, 15, 20 };
		int isArraySorted2 = isSorted(nums2.length, nums2);
		System.out.println("Is Array " + Arrays.toString(nums2) + " sorted : " + isArraySorted2);

		int[] nums3 = { 67, 45, 33, 12, -10 };
		int isArraySorted3 = isSorted(nums3.length, nums3);
		System.out.println("Is Array " + Arrays.toString(nums3) + " sorted : " + isArraySorted3);
	}

	public static int isSorted(int n, int[] a) {
		boolean isAscendSort = true;
		boolean isDecendSort = true;
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				isAscendSort = false;
				break;
			}
		}
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				isDecendSort = false;
				break;
			}
		}
		return isAscendSort || isDecendSort ? 1 : 0;
	}
}
