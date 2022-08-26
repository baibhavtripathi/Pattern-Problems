package io.tribty;

import java.util.Arrays;

/**
 * Given an array, find the average of all contiguous sub-arrays of size ‘K’ in it.
 */
public class AverageOfN {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int n = 5;
        System.out.println("Trivial");
        long startTime = System.nanoTime();
        double[] res = averages(arr, n);
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.print("Output: ");
        System.out.println(Arrays.toString(res));

        System.out.println("SlidingWindow");
        startTime = System.nanoTime();
        double[] resSW = averageBySlidingWindow(arr, n);
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        System.out.print("Output: ");
        System.out.println(Arrays.toString(resSW));

    }
    /*
    Time complexity: Since for every element of the input array, we are calculating the sum of its next ‘K’ elements,
    the time complexity of the above algorithm will be
    O(N*K)         where ‘N’ is the number of elements in the input array.
     */
    static double[] averages(int[] arr, int n) {
        double[] res = new double[arr.length-n+1];
        for (int i = 0; i < arr.length-n+1; i++) {
            int sum = 0;
            for (int j = i; j < i+n; j++) {
                sum += arr[j];
            }   res[i] = sum/(n*1.0);
        }
        return res;
    }

    /**
     * The efficient way to solve this problem would be to visualize each contiguous subarray as a sliding window of ‘5’ elements.
     * This means that when we move on to the next subarray, we will slide the window by one element. So, to reuse the sum from
     * the previous subarray, we will subtract the element going out of the window and add the element now being included in the
     * sliding window. This will save us from going through the whole subarray to find the sum and, as a result, the algorithm
     * complexity will reduce to
     * O(N).
     *
     * @param arr
     * @param n
     * @return double[] of averages
     */
    static double[] averageBySlidingWindow(int[] arr, int n) {
        double[] res = new double[arr.length-n+1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        res[0] = sum/(n*1.0);
        for (int i = 1; i < arr.length-n+1; i++) {
            sum = sum - arr[i-1] + arr[i+n-1];
            res[i] = sum/(n*1.0);
        }
        return res;
    }
}
