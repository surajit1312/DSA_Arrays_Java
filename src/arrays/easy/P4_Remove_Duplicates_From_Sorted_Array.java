/**
 * 
 */
package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * CodingNinjas: Remove Duplicates from Sorted Array
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/remove-duplicates-from-sorted-array_1102307
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P4_Remove_Duplicates_From_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(nums));
		int count = removeDuplicates(arr, arr.size());
		System.out.println("Size of unique array : " + count);
	}

	private static int removeDuplicates(ArrayList<Integer> arr, int n) {
		if (arr == null) {
			return 0;
		}
		if (arr.size() == 1) {
			return 1;
		}
		int currentIndex = 0;
		for (int i = 1; i < n; i++) {
			if (arr.get(currentIndex) != arr.get(i)) {
				arr.set(currentIndex + 1, arr.get(i));
				currentIndex++;
			}
		}
		List<Integer> result = arr.subList(0, currentIndex + 1);
		System.out.println(result);
		return result.size();
	}

}
