package com.richard.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode1218 {

    /**
     * 给你一个整数数组arr和一个整数difference，请你找出arr中所有相邻元素之间的差等于给定difference的等差子序列，并返回其中最长的等差子序列的长度。
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<>(n);
        for (int temp : arr) {
            // 等差序列是非连续的，但是可以通过difference找到上一阶段的值
            int subLength = dp.getOrDefault(temp - difference, 0) + 1;
            dp.put(temp, subLength);
            ans = Math.max(ans, subLength);
        }
        return ans;
    }
}
