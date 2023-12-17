package arrays.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Maximum Subarray Sum (Kadane's Algorithm)
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/maximum-subarray-sum_630526
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P4_Maximum_Sub_Array_Sum {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("Maximum sub-array sum in " + Arrays.toString(arr) + " is : " + maxSum);
        int[] maxSubArray = getSubArrayWithMaximumSum(arr, n);
        System.out.println(
                "Sub-array with maximum sum in " + Arrays.toString(arr) + " is : " + Arrays.toString(maxSubArray));
    }

    private static long maxSubarraySum(int[] arr, int n) {
        long maxSum = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    private static int[] getSubArrayWithMaximumSum(int[] arr, int n) {
        long maxSum = 0;
        long currentSum = 0;
        int startIndex = -1;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (currentSum == 0) {
                startIndex = i;
            }
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (maxSum < currentSum) {
                endIndex = i;
                maxSum = currentSum;
            }
        }
        int[] subArrayResult = new int[endIndex - startIndex + 1];
        for (int i = startIndex; i <= endIndex; i++) {
            subArrayResult[i - startIndex] = arr[i];
        }
        return subArrayResult;
    }
}
