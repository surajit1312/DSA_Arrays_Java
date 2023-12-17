package arrays.medium;

import java.util.ArrayList;

/**
 * 
 * CodingNinjas: Zero Matrix
 * 
 * Link: https://www.codingninjas.com/studio/problems/zero-matrix_1171153
 * 
 */
public class P8_Set_Matrix_Zeros {
    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };
        Integer n = 4;
        Integer m = 4;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> rows = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                rows.add(mat[i][j]);
            }
            matrix.add(rows);
        }
        ArrayList<ArrayList<Integer>> result = zeroMatrix(matrix, n, m);
        System.out.println(result);

        int[][] matOpt = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };
        matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> rows = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                rows.add(matOpt[i][j]);
            }
            matrix.add(rows);
        }
        ArrayList<ArrayList<Integer>> resultOptimal = zeroMatrixOptimal(matrix, n, m);
        System.out.println(resultOptimal);
    }

    /**
     * Better Solution
     * 
     * TC: O(n x m) + O(n x m) = O(2 x n x m)
     * SC: O(n + m)
     * 
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    private static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n,
            Integer m) {
        int[] rowMark = new int[n];
        int[] colMark = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    rowMark[i] = 1;
                    colMark[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < m; j++) {
                if (rowMark[i] == 1 || colMark[j] == 1) {
                    row.set(j, 0);
                }
            }
        }
        return matrix;
    }

    /**
     * Better Solution: To use 1st row and 1st column to mark zero rows and zero
     * columns
     * 
     * TC: O(n x m) + O(n x m) = O(2 x n x m)
     * SC: O(1)
     * 
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    private static ArrayList<ArrayList<Integer>> zeroMatrixOptimal(ArrayList<ArrayList<Integer>> matrix, Integer n,
            Integer m) {
        int col0 = matrix.get(0).get(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else {
                        col0 = 0;
                    }
                    matrix.get(i).set(0, 0);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) == 1) {
                    if (matrix.get(0).get(j) == 0 || matrix.get(i).get(0) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
}
