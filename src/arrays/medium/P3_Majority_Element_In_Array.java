package arrays.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Majority Element - Moore's Voting Algorithm
 * 
 * Link: https://www.codingninjas.com/studio/problems/majority-element_6783241
 * 
 * TC: O(2N) ~ O(N)
 * SC: O(1)
 * 
 */
public class P3_Majority_Element_In_Array {
    public static void main(String[] args) {
        int[] v = { 2, 2, 1, 3, 1, 1, 3, 1, 1 };
        int majorityValue = majorityElement(v);
        System.out.println("Majority Element in array " + Arrays.toString(v) + " is : " + majorityValue);
    }

    private static int majorityElement(int[] v) {
        int element = -1;
        int count = 0;
        for (int i = 0; i < v.length; i++) {
            if (count == 0) {
                element = v[i];
            }
            if (v[i] == element) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 0;
            }
        }
        count = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] == element) {
                count++;
            }
        }
        if (count > v.length / 2) {
            return element;
        }
        return -1;
    }
}
