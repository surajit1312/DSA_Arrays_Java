package arrays.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Rotate The Matrix
 * 
 * Link: https://www.codingninjas.com/studio/problems/rotate-the-matrix_6825090
 * 
 * TC: O(N x N) - for Transpose + O(N x N) for Reverse ~ O(N x N)
 * SC: O(1)
 * 
 */
public class P11_Rotate_Image_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        rotateMatrix(matrix);
    }

    private static void rotateMatrix(int[][] mat) {
        transposeMatrix(mat);
        reverseRows(mat);
    }

    private static void transposeMatrix(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swapMatrix(mat, i, j);
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }

    private static void reverseRows(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            mat[i] = reverseArray(mat[i]);
        }
        System.out.println(Arrays.deepToString(mat));
    }

    private static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            swap(arr, low, high);
            low++;
            high--;
        }
        return arr;
    }

    private static void swapMatrix(int[][] mat, int i, int j) {
        int temp = mat[j][i];
        mat[j][i] = mat[i][j];
        mat[i][j] = temp;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
