package com.richard.algorithm.offer;

public class Offer10_2 {

    /**
     * dp数组缓存中间结果
     */
    private final int[] dpArray = new int[101];

    public int numWays(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(dpArray[n] > 0) {
            return dpArray[n];
        }
        int result = numWays(n - 2) + numWays(n - 1);
        result = result % 1000000007;
        dpArray[n] = result;
        return result;
    }
}
