package com.richard.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode131 {

    private static final List<List<String>> RESULT = new ArrayList<>();

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        RESULT.clear();
        boolean[][] cache = dpCache(s);
        dfs(s, 0, new ArrayList<>(), cache);
        return RESULT;
    }

    /**
     * 动态规划获取所有回文串缓存
     *
     * @param s
     * @return
     */
    public boolean[][] dpCache(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        for(int right = 0; right < n; right++) {
            for(int left = 0; left <= right; left++) {
                if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || cache[left + 1][right - 1])) {
                    cache[left][right] = true;
                }
            }
        }
        return cache;
    }

    /**
     * 获取所有回文串
     *
     * @param targetStr
     * @param start
     * @param segments
     */
    public void dfs(String targetStr, int start, List<String> segments, boolean[][] cache) {
        int n = targetStr.length();
        if(start == n) {
            // 这里是为了防止回溯时由于使用同一个引用导致的数据修改
            RESULT.add(new ArrayList<>(segments));
            return;
        }
        for(int end = start; end < n; end++) {
            if(cache[start][end]) {
                segments.add(targetStr.substring(start, end + 1));
                dfs(targetStr, end + 1, segments, cache);
                // 处理完的case回溯，重新处理
                segments.remove(segments.size() - 1);
            }
        }
    }

    /**
     * 判断子串是否为回文串
     *
     * @param substr
     * @return
     */
    private boolean valid(String substr) {
        if(substr.length() == 1) {
            return true;
        }
        int start = 0, end = substr.length() - 1;
        while(start < end) {
            if(substr.charAt(start) == substr.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
