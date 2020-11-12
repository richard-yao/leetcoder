package com.richard.algorithm.leetcode;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode5 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 单个字符必定是回文的
        if(s.length() <= 1) {
            return s;
        }
        int n = s.length();
        int maxStart = 0, maxEnd = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for(int right = 1; right < n; right++) {
            for(int left = 0; left < right; left++) {
                // 回文串的状态转移方程：s[left] == s[right] && dp[left + 1][right -1] == true
                // 状态转移的边界条件是[left, right]的区间长度小于等于2，因为当长度为1例如aa时，长度为2例如aba时，由于s[left] == s[right], 此必为回文串
                if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if(right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        maxStart = left;
                        maxEnd = right;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * 采用中心扩散算法的最大回文子串问题
     *
     * @param s
     * @return
     */
    public String longestPalindromeSecond(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }
        int maxLen = 1;
        // 初始化res
        String res = s.substring(0, 1);
        for(int i = 0; i < len - 1; i++) {
            // 给定指定的字符开始中心位置，开始扩张
            // 偶数回文串
            String oddStr = centerSpread(s, i, i);
            // 奇数回文串
            String evenStr = centerSpread(s, i, i + 1);
            // 取交大的回文子串，进行比较后继续迭代
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if(maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        int len = s.length();
        while(left >= 0 && right < len) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        // 跳出循环时s.charAt(left) != s.charAt(right)
        return s.substring(left + 1, right);
    }
}
