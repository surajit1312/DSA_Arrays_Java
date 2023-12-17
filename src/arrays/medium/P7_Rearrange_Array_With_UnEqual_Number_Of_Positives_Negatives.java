package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * CodingNinjas: Rearrange Alternatively
 * 
 * Link: https://www.codingninjas.com/studio/problems/rearrange-alternatively_873851
 * 
 * TC: O(2N) ~ O(N)
 * SC: O(N)
 * 
 */
public class P7_Rearrange_Array_With_UnEqual_Number_Of_Positives_Negatives {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 10, -8, 6, -4 };
        int[] result = rearrange(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] rearrange(int[] arr) {
        ArrayList<Integer> posArr = new ArrayList<Integer>();
        ArrayList<Integer> negArr = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                posArr.add(arr[i]);
            } else {
                negArr.add(arr[i]);
            }
        }

        int[] result = new int[arr.length];
        int commonSize = Math.abs(posArr.size() - negArr.size());
        int count = 0;
        for (int i = 0; i < commonSize; i++) {
            result[2 * i] = negArr.get(i);
            result[2 * i + 1] = posArr.get(i);
            count++;
        }
        if (posArr.size() > negArr.size()) {
            for (int i = count; i < posArr.size(); i++) {
                result[count + i] = posArr.get(i);
            }
        } else {
            for (int i = count; i < negArr.size(); i++) {
                result[count + i] = negArr.get(i);
            }
        }
        return result;
    }
}
