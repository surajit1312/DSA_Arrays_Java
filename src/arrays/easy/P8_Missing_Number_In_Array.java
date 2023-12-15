package arrays.easy;

import java.util.Arrays;

/**
 * 
 * GeeksForGeeks: Missing number in array
 * Link: https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P8_Missing_Number_In_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int n = 5;
        int missing = missingNumber(arr, n);
        System.out.println("Missing number in array " + Arrays.toString(arr) + " is: " + missing);
    }

    private static int missingNumber(int array[], int n) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 1; i < n; i++) {
            xor1 = xor1 ^ i;
            xor2 = xor2 ^ array[i - 1];
        }
        return xor1 ^ xor2 ^ n;
    }
}
