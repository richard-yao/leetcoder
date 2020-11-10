package com.richard.algorithm.test;

import com.richard.algorithm.Leetcode5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode5Test {

    @Test
    public void testCase() {
        Leetcode5 leetcode5 = new Leetcode5();
        Assertions.assertEquals("aa", leetcode5.longestPalindrome("aa"));
        Assertions.assertEquals("aba", leetcode5.longestPalindrome("aba"));
        Assertions.assertEquals("abccba", leetcode5.longestPalindrome("abccbaaa"));
    }

    @Test
    public void testCase2() {
        Leetcode5 leetcode5 = new Leetcode5();
        Assertions.assertEquals("aa", leetcode5.longestPalindromeSecond("aa"));
        Assertions.assertEquals("aba", leetcode5.longestPalindromeSecond("aba"));
        Assertions.assertEquals("abccba", leetcode5.longestPalindromeSecond("abccbaaa"));
    }
}
