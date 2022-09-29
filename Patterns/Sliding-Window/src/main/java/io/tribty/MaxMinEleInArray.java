package io.tribty;

public class MaxMinEleInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,7,-1,9};
        Pair pair = maxMinElementOfArray(arr);
        System.out.println("Minimum element: "+pair.getMin()+", Maximum element: "+pair.getMax());
    }
    private static Pair maxMinElementOfArray(int[] arr) {
        Pair pair = new Pair();
        for (int ele : arr) {
            pair.setMin( Math.min(pair.getMin(), ele) );
            pair.setMax( Math.max(pair.getMax(), ele) );
        }
        return pair;
    }

}

class Pair {
    private int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public Pair() {
    }

    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}