package io.tribty;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 0, 5, 3, 0, 0, 6, 0, 9};
        System.out.println(Arrays.toString(movedArray(arr)));
    }

    static int[] movedArray(int[] arr) {
        int[] res = new int[arr.length];
        int k = 0;
        for (int num: arr) {
            if (num != 0) res[k++] = num;
        }
        return res;
    }

    static void inPlaceMoved(int[] arr) {
        int slow = arr.length-1;
        int fast = arr.length-2;
        for (int i = arr.length-1; i > -1 ; i--) {
            if (arr[fast] != 0) swap(arr, arr[fast], arr[slow]);
        }
    }

    static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}
