package com.richard.algorithm.offer;

public class Offer11 {

    /**
     * dp数组缓存斐波那契数列的前项结果
     */
    private final int[] dpArray = new int[101];

    public int fib(int n) {
        if(n < 2) {
            return n;
        }
        if(dpArray[n] > 0) {
            return dpArray[n];
        }
        int result = fib(n - 1) + fib(n - 2);
        result = result % 1000000007;
        dpArray[n] = result;
        return result;
    }
}
