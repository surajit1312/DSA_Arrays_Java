package arrays.hard;

import java.util.Arrays;

/**
 * CodingNinjas: Subarray With Maximum Product
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/subarray-with-maximum-product_6890008
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P1_Maximum_Product_SubArrays {
    public static void main(String[] args) {
        int[] arr = { -1, 3, 0, -4, 3 };
        int maxProductSubArray = subarrayWithMaxProduct(arr);
        System.out.println("Maximum product sub-array in " + Arrays.toString(arr) + " is : " + maxProductSubArray);
    }

    private static int subarrayWithMaxProduct(int[] arr) {
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * arr[i];
            suffix = suffix * arr[arr.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
