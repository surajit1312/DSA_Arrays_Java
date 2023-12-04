/**
 * 
 */
package arrays.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Second Largest Number
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P2_Arrays_Find_Second_Largest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 3, 3, 3, 2, 7, 7, 5, 4 };
		int[] secondOrders = getSecondOrderElements(nums.length, nums);
		System.out.println(
				"Second order elements in " + Arrays.toString(nums) + " are : " + Arrays.toString(secondOrders));
	}

	private static int[] getSecondOrderElements(int n, int[] a) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int smin = Integer.MAX_VALUE, smax = Integer.MIN_VALUE;
		int[] result = new int[2];
		for (int i = 0; i < a.length; i++) {
			// find max and smax
			if (a[i] > max) {
				smax = max;
				max = a[i];
			} else {
				if (a[i] < max && a[i] > smax) {
					smax = a[i];
				}
			}
			// find min and smin
			if (a[i] < min) {
				smin = min;
				min = a[i];
			} else {
				if (a[i] > min && a[i] < smin) {
					smin = a[i];
				}
			}
		}
		result[0] = smax;
        result[1] = smin;
		return result;
	}

}
