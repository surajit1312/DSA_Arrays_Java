/**
 * 
 */
package arrays.sorting;

import java.util.Arrays;

/**
 * 
 * GeeksForGeeks, CodingNinjas: Bubble Sort
 * 
 * Link: 
 * https://www.geeksforgeeks.org/problems/bubble-sort/1
 * https://www.codingninjas.com/studio/problems/bubble-sort_624380
 * 
 * TC: O(n^2)
 * SC: O(1)
 */
public class P1_Arrays_Bubble_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 13, 4, 1, 3, 6, 28 };
		bubbleSort(nums, nums.length);
		System.out.println("Sorted array (bubble sort) : " + Arrays.toString(nums));
	}

	private static void bubbleSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

}
