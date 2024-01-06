package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * CodingNinjas:
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/next-greater-permutation_6929564
 * 
 * TC: O(3n) ~ O(n)
 * SC: O(1)
 * 
 */
public class P10_Next_Greater_Permutation {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(6, 10, 8, 13, 13));
        List<Integer> nextPermutation = nextGreaterPermutation(A);
        System.out.println(
                "Next greater permutation of " + Arrays.asList(6, 10, 8, 13, 13) + " is: " + nextPermutation);
    }

    private static List<Integer> nextGreaterPermutation(List<Integer> A) {
        int pivotIndex = getPivotIndex(A);
        if (pivotIndex == -1) {
            Collections.reverse(A);
            return A;
        } else {
            int min = A.get(pivotIndex);
            int minCloseIndex = -1;
            int minClose = Integer.MAX_VALUE;
            for (int i = pivotIndex + 1; i < A.size(); i++) {
                if (A.get(i) > min && minClose > A.get(i)) {
                    minClose = A.get(i);
                    minCloseIndex = i;
                }
            }
            // swap minClose value with A.get(pivotIndex);
            swap(A, pivotIndex, minCloseIndex);
            // sort the Arraylist from pivotIndex + 1;
            return sortList(A, pivotIndex + 1);
        }
    }

    private static List<Integer> sortList(List<Integer> A, int k) {
        List<Integer> sorted = new ArrayList<>();
        for (int i = k; i < A.size(); i++) {
            sorted.add(A.get(i));
        }
        Collections.sort(sorted);
        for (int i = k; i < A.size(); i++) {
            A.set(i, sorted.get(i - k));
        }
        return A;
    }

    private static int getPivotIndex(List<Integer> A) {
        int pivot = -1;
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    private static void swap(List<Integer> A, int a, int b) {
        Integer temp = A.get(b);
        A.set(b, A.get(a));
        A.set(a, temp);
    }
}
