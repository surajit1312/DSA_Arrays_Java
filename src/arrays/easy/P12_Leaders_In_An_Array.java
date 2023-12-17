package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * GeeksForGeeks: Leaders in an array
 * 
 * Link: https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
 * 
 * TC: O(N)
 * SC: O(1)
 */
public class P12_Leaders_In_An_Array {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        ArrayList<Integer> leadersArr = leaders(arr, arr.length);
        System.out.println("Leaders in array " + Arrays.toString(arr) + " are : " + leadersArr);
    }

    private static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> leadersArr = new ArrayList<Integer>();
        int max = arr[n - 1];
        leadersArr.add(0, max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                leadersArr.add(0, max);
            }
        }
        return leadersArr;
    }

}
