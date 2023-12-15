package arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * CodingNinjas: Two Sum
 * 
 * Link: https://www.codingninjas.com/studio/problems/reading_6845742
 * 
 */
public class P11_Two_Sum_In_Array {
    public static void main(String[] args) {
        int[] book = { 4, 2, 2, 3, 1 };
        int n = 5;
        int target = 5;
        String twoSumExists = checkTwoSum(n, book, target);
        System.out.println("Two Sum exists in array " + Arrays.toString(book) + " with target sum " + target + " : "
                + twoSumExists);
        int[] nums = { 2, 6, 5, 8, 11 };
        int k = 14;
        String twoSumExistsGreedy = checkTwoSumGreedy(nums.length, nums, k);
        System.out.println(
                "Two Sum exists in array " + Arrays.toString(nums) + " with target sum " + k + " (Greedy Approach) : "
                        + twoSumExistsGreedy);
    }

    /**
     * Using Hashmap
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param n
     * @param book
     * @param target
     * @return
     */
    private static String checkTwoSum(int n, int[] book, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int[] indices = new int[2];
        for (int i = 0; i < n; i++) {
            int rem = target - book[i];
            if (numMap.containsKey(rem)) {
                indices[1] = i;
                indices[0] = numMap.get(rem);
                System.out.println(Arrays.toString(indices));
                return "YES";
            } else {
                numMap.put(book[i], i);
            }
        }
        return "NO";
    }

    /**
     * Using Two Pointers/Greedy Approach
     * 
     * TC: O(N) + O(Nlog(N))
     * SC: O(1)
     * 
     * @param n
     * @param book
     * @param target
     * @return
     */
    private static String checkTwoSumGreedy(int n, int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        int currentSum = 0;
        while (left <= right) {
            currentSum = nums[left] + nums[right];
            if (currentSum > k) {
                right--;
            } else if (currentSum < k) {
                left++;
            } else {
                return "YES";
            }
        }
        return "NO";
    }
}
