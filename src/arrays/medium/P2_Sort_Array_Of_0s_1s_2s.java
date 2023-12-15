package arrays.medium;

import java.util.Arrays;

/**
 * GeeksForGeeks: Sort an array of 0s, 1s and 2s
 * 
 * Dutch National Flag Algorithm
 * 
 * Link:
 * https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P2_Sort_Array_Of_0s_1s_2s {

    public static void main(String[] args) {
        int[] a = { 0, 2, 1, 2, 0 };
        int n = 5;
        sort012(a, n);
    }

    public static void sort012(int a[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, mid, low);
                mid++;
                low++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                swap(a, mid, high);
                high--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

}
