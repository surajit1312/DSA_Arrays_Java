/**
 * 
 */
package arrays.sorting;

import java.util.Arrays;

/**
 * 
 * Coding Ninjas: Merge Sort
 * 
 * Link: https://www.codingninjas.com/studio/problems/merge-sort_5846
 * 
 * TC: O(n * log(n))
 * SC: O(n)
 * 
 */
public class P2_Arrays_Merge_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 13, 4, 1, 3, 6, 28 };
		int l = 0, r = nums.length - 1;
		mergeSort(nums, l, r);
		System.out.println("Sorted array (merge sort) : " + Arrays.toString(nums));
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			mergeArraysHelper(arr, l, mid, r);
		}
	}

	private static void mergeArraysHelper(int[] arr, int l, int mid, int r) {
		int i = l, j = mid + 1, k = l;
		int[] result = new int[arr.length];

		while (i <= mid && j <= r) {
			if (arr[i] <= arr[j]) {
				result[k] = arr[i];
				i++;
			} else if (arr[i] > arr[j]) {
				result[k] = arr[j];
				j++;
			}
			k++;
		}

		if (j > r) {
			while (i <= mid) {
				result[k] = arr[i];
				i++;
				k++;
			}
		}
		if (i > mid) {
			while (j <= r) {
				result[k] = arr[j];
				j++;
				k++;
			}
		}

		for (int p = l; p <= r; p++) {
			arr[p] = result[p];
		}
	}

}
