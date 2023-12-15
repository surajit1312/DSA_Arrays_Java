package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * GeeksForGeeks: Longest Sub-Array with Sum K
 * 
 * Link:
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 * https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505
 * 
 */
public class P1_Longest_Sub_Array_With_Sum_K {
    public static void main(String[] args) {
        int[] A = { 1, 4, 3, 3, 5, 5 };
        int N = 6;
        int K = 16;
        int maxLength = lenOfLongSubarr(A, N, K);
        System.out.println(
                "Maximum sub-array length of sum " + K + " in array " + Arrays.toString(A) + " is : " + maxLength);

        int[] nums = { 1, 2, 3, 1, 1, 1, 1 };
        int k = 3;
        int bestMaxLength = getLongestSubarray(nums, k);
        System.out.println(
                "Maximum sub-array length of sum " + k + " in array " + Arrays.toString(nums) + " is : "
                        + bestMaxLength);
    }

    /**
     * Best Approach using Two Pointers
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int getLongestSubarray(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < nums.length) {
            currentSum += nums[right];
            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            while (currentSum > k && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return maxLength;
    }

    /**
     * Better Approach
     * 
     * Using Hashmap Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param A
     * @param N
     * @param K
     * @return
     */
    private static int lenOfLongSubarr(int A[], int N, int K) {
        int maxLength = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            currentSum += A[i];
            if (currentSum == K) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int rem = currentSum - K;
            if (prefixMap.containsKey(rem)) {
                maxLength = Math.max(maxLength, i - prefixMap.get(rem));
            }
            if (!prefixMap.containsKey(currentSum)) {
                prefixMap.put(currentSum, i);
            }
        }
        return maxLength;
    }
}
