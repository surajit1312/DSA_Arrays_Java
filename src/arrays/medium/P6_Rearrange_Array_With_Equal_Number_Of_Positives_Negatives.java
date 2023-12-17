package arrays.medium;

import java.util.Arrays;

/**
 * CodingNinjas: Alternate Numbers/ Alternate Positive and Negative
 * 
 * Link: https://www.codingninjas.com/studio/problems/alternate-numbers_6783445
 * 
 */
public class P6_Rearrange_Array_With_Equal_Number_Of_Positives_Negatives {
    public static void main(String[] args) {
        int[] arr1 = { -2, -3, 4, 5 };
        int[] result1 = alternateNumbers1(arr1);
        System.out.println(Arrays.toString(result1));

        int[] arr2 = { 1, 2, 3, -1, -2, -3 };
        int[] result2 = alternateNumbers2(arr2);
        System.out.println(Arrays.toString(result2));

        int[] arr3 = { -2, -3, 4, 5 };
        int[] result3 = alternateNumbers3(arr3);
        System.out.println(Arrays.toString(result3));
    }

    /**
     * This will work if the positive negative order does not matter
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param a
     * @return
     */
    private static int[] alternateNumbers1(int[] a) {
        int pos = 0;
        int neg = 0;
        int current = 0;
        while (current < a.length && neg < a.length && pos < a.length) {
            while (a[pos] < 0) {
                pos++;
            }
            while (a[neg] > 0) {
                neg++;
            }
            if (current % 2 == 0) {
                swap(a, current, pos);
                pos++;
            } else {
                swap(a, current, neg);
                neg++;
            }
            current++;
        }
        return a;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    /**
     * Brute-Force Approach
     * This will work if order of positive and negative numbers matter
     * 
     * TC: O(3N/2) ~ O(N)
     * SC: O(N)
     * 
     * @param a
     * @return
     */
    private static int[] alternateNumbers2(int[] a) {
        int[] pos = new int[a.length / 2];
        int[] neg = new int[a.length / 2];
        int pIndex = 0;
        int nIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                pos[pIndex] = a[i];
                pIndex++;
            } else {
                neg[nIndex] = a[i];
                nIndex++;
            }
        }

        for (int i = 0; i < a.length / 2; i++) {
            a[2 * i] = pos[i];
            a[2 * i + 1] = neg[i];
        }
        return a;
    }

    /**
     * Best Approach
     * This will work if order of positive and negative numbers matter
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param a
     * @return
     */
    private static int[] alternateNumbers3(int[] a) {
        int posIndex = 0;
        int negIndex = 1;
        int n = a.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                result[posIndex] = a[i];
                posIndex += 2;
            } else {
                result[negIndex] = a[i];
                negIndex += 2;
            }
        }
        return result;
    }

}
