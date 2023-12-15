package arrays.easy;

import java.util.Arrays;

/**
 * 
 * GeeksForGeeks: Find the element that appears once
 * 
 * Link: https://www.geeksforgeeks.org/problems/element-appearing-once2552/1
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P10_Find_Element_Appears_Once_In_Array {
    public static void main(String[] args) {
        int[] A = { 1, 1, 2, 5, 5 };
        int N = 5;
        int singleNumber = search(A, N);
        System.out.println("Number that appears once in array " + Arrays.toString(A) + " is : " + singleNumber);
    }

    private static int search(int A[], int N) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = result ^ A[i];
        }
        return result;
    }

}
