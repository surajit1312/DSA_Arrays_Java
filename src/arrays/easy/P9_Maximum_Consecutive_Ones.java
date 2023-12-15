package arrays.easy;

import java.util.ArrayList;

/**
 * GeeksForGeeks: Longest Consecutive 1's
 * 
 * Link:
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P9_Maximum_Consecutive_Ones {
    public static void main(String[] args) {
        int N = 222;
        int max1s = maxConsecutiveOnes(N);
        System.out.println("Maximum consecutive one's in binary respresentation of " + N + " is : " + max1s);
    }

    private static int maxConsecutiveOnes(int N) {
        ArrayList<Integer> bIntegers = convertToBinaryArray(N);
        int maxOnes = 0;
        int currentOnes = 0;
        for (Integer it : bIntegers) {
            if (it == 1) {
                currentOnes++;
            } else {
                currentOnes = 0;
            }
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return maxOnes;
    }

    private static ArrayList<Integer> convertToBinaryArray(int N) {
        ArrayList<Integer> binary = new ArrayList<Integer>();
        while (N != 0) {
            int rem = N % 2;
            binary.add(0, rem);
            N = N / 2;
        }
        return binary;
    }

}
