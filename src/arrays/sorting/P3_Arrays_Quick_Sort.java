/**
 * 
 */
package arrays.sorting;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Quick Sort
 * 
 * Link: https://www.codingninjas.com/studio/problems/quick-sort_5844
 * 
 * TC: O(n * log(n), Worst case - O(n^2)
 * SC: O(n)
 * 
 */
public class P3_Arrays_Quick_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 13, 4, 1, 3, 6, 28 };
		int l = 0, r = nums.length - 1;
		quickSort(nums, l, r);
		System.out.println("Sorted array (quick sort) : " + Arrays.toString(nums));
	}

	private static void quickSort(int[] input, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivotIndex = getPivotIndex(input, startIndex, endIndex);
			quickSort(input, startIndex, pivotIndex - 1);
			quickSort(input, pivotIndex + 1, endIndex);
		}
	}

	private static int getPivotIndex(int[] input, int startIndex, int endIndex) {
		int i = startIndex, j = endIndex;
		int pivot = startIndex;
		while (i < j) {
			while (input[i] <= input[pivot]) {
				i++;
			}
			while (input[j] > input[pivot]) {
				j--;
			}
			if (i < j) {
				swap(input, i, j);
			}
		}
		swap(input, j, pivot);
		return j;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

}
