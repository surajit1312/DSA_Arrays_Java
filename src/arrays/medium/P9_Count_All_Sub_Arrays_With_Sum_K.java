package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CodingNinjas: Count All Subarrays With Given Sum
 * 
 * Link: https://www.codingninjas.com/studio/problems/subarray-sums-i_1467103
 * 
 * TC: O(N)
 * SC: O(N) - Arbitrary Recursive stack space
 * 
 */
public class P9_Count_All_Sub_Arrays_With_Sum_K {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;
        int countSubArrays = findAllSubarraysWithGivenSum(arr, k);
        System.out.println(
                "Count of all sub-arrays of " + Arrays.toString(arr) + " with sum " + k + " is : " + countSubArrays);
    }

    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        int[] count = new int[1];
        ArrayList<Integer> result = new ArrayList<Integer>();
        getAllSubArrays(arr, result, count, 0, 0, s);
        return count[0];
    }

    private static void getAllSubArrays(int[] arr, ArrayList<Integer> result, int[] count, int sum, int index,
            int target) {
        if (arr == null) {
            count[0] = 0;
            return;
        }
        if (arr.length == 0) {
            count[0] = arr[0] == target ? 1 : 0;
        }
        if (index == arr.length) {
            if (sum == target) {
                count[0]++;
            }
            return;
        }
        // Include
        sum += arr[index];
        result.add(arr[index]);
        getAllSubArrays(arr, result, count, sum, index + 1, target);
        // Not include
        // Backtrack
        sum -= arr[index];
        result.remove(result.size() - 1);
        getAllSubArrays(arr, result, count, sum, index + 1, target);
    }
}
